package ru.fotoochkarik.checkcollector.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.fotoochkarik.checkcollector.data.dto.response.BodyReceiptInfo;
import ru.fotoochkarik.checkcollector.data.mapper.ReceiptMapper;
import ru.fotoochkarik.checkcollector.service.ReceiptService;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@RequiredArgsConstructor
@Component
public class ReceiptFacade {

  private final ReceiptService receiptService;
  private final ReceiptMapper receiptMapper;

  public BodyReceiptInfo saveReceipt(String qrraw) throws JsonProcessingException {
    var receipt = receiptService.saveReceipt(qrraw);
    return receiptMapper.toBodyReceiptInfo(receipt);
  }

}
