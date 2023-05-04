package ru.fotoochkarik.checkcollector.component;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.fotoochkarik.checkcollector.data.dto.request.ReceiptShortInfo;
import ru.fotoochkarik.checkcollector.data.mapper.ReceiptMapper;
import ru.fotoochkarik.checkcollector.service.InternalReportService;
import ru.fotoochkarik.checkcollector.service.ReceiptService;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RequiredArgsConstructor
@Component
public class ReceiptFacade {

  private final ReceiptService receiptService;
  private final InternalReportService internalReportService;
  private final ReceiptMapper receiptMapper;

  public ReceiptShortInfo saveReceipt(String request) throws JsonProcessingException {
    log.info("ReceiptFacade:: saveReceipt request = {} ", request);
    var receipt = receiptService.saveReceipt(request);
    internalReportService.addReceiptToReport(receiptMapper.toExpenseRequest(receipt));
    return receiptMapper.toReceiptShortInfo(receipt);
  }

}
