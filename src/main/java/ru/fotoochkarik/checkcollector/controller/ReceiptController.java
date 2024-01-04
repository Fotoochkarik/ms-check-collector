package ru.fotoochkarik.checkcollector.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fotoochkarik.checkcollector.component.ReceiptFacade;
import ru.fotoochkarik.checkcollector.service.ReceiptService;
import ru.fotoochkarik.generated.v1.api.PublicApi;
import ru.fotoochkarik.generated.v1.dto.CreateReceiptRequest;
import ru.fotoochkarik.generated.v1.dto.ReceiptShortInfo;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@RestController
@RequiredArgsConstructor
public class ReceiptController implements PublicApi {

  private final ReceiptService receiptService;
  private final ReceiptFacade receiptFacade;

  @GetMapping("/json")
  public String getJson(@RequestParam(name = "qrraw") String qrraw) {
    log.info("request {}", qrraw);
    return receiptService.getJson(qrraw);
  }

  @Override
  public ResponseEntity<ReceiptShortInfo> createReceipt(CreateReceiptRequest createReceiptRequest) throws Exception {
    log.info("ReceiptController:: save request qrraw = {} ", createReceiptRequest.getCreateRequest());
    return ResponseEntity.ok(receiptFacade.saveReceipt(createReceiptRequest.getCreateRequest()));
  }

}
