package ru.fotoochkarik.checkcollector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fotoochkarik.checkcollector.data.mapper.ReceiptMapper;
import ru.fotoochkarik.checkcollector.data.model.Receipt;
import ru.fotoochkarik.checkcollector.data.model.ReceiptTemp;
import ru.fotoochkarik.checkcollector.data.repository.ReceiptRepository;
import ru.fotoochkarik.checkcollector.data.repository.ReceiptTempRepository;
import ru.fotoochkarik.checkcollector.integration.feign.ExternalReceiptClient;
import ru.fotoochkarik.generated.v1.dto.ReceiptInfo;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiptService {

  private final ReceiptTempRepository receiptTempRepository;
  private final ExternalReceiptClient receiptClient;
  private final ReceiptRepository receiptRepository;
  private final ExternalReceiptService externalReceiptService;
  private final ObjectMapper objectMapper;
  private final ReceiptMapper receiptMapper;


  public void saveReceiptTemp(ReceiptInfo receiptInfo, String request) throws JsonProcessingException {
    saveTemp(objectMapper.writeValueAsString(receiptInfo), request);
  }

  @Transactional
  public void saveTemp(String json, String request) {
    var receiptTemp = new ReceiptTemp();
    receiptTemp.setRequest(request);
    receiptTemp.setCreated(LocalDateTime.now());
    receiptTemp.setData(json);
    var exists = receiptTempRepository.existsByRequest(receiptTemp.getRequest());
    if (!exists) {
      receiptTempRepository.save(receiptTemp);
    }
  }

  public String getJson(String request) {
    var requestInfo = externalReceiptService.createRequestInfo(request);
    return receiptClient.getJsonChek(requestInfo);
  }


  public Receipt saveReceipt(String requestStr) throws JsonProcessingException {
    log.info("ReceiptService:: saveReceipt request = {} ", requestStr);
    var request = externalReceiptService.createRequestInfo(requestStr);
    var receiptInfo = receiptClient.getReceiptInfo(request);
    saveReceiptTemp(receiptInfo, requestStr);
    return saveReceipt(receiptInfo);
  }

  @Transactional
  public Receipt saveReceipt(ReceiptInfo receiptInfo) {
    var receipt = receiptMapper.toReceipt(receiptInfo.getData().getJson());
    receipt.getItems()
        .forEach(item -> item.setReceipt(receipt));
    var exists = receiptRepository.existsByDateTimeAndTotalSum(receipt.getDateTime(), receipt.getTotalSum());
    if (exists) {
      return receipt;
    }
    return receiptRepository.save(receipt);
  }

}
