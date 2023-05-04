package ru.fotoochkarik.checkcollector.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.fotoochkarik.checkcollector.component.ReceiptFacade;
import ru.fotoochkarik.checkcollector.data.dto.request.ReceiptShortInfo;
import ru.fotoochkarik.checkcollector.data.dto.request.SaveRequest;
import ru.fotoochkarik.checkcollector.service.ReceiptService;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/receipt")
public class ReceiptController {

  private final ReceiptService receiptService;
  private final ReceiptFacade receiptFacade;

  @GetMapping("/json")
  public String getJson(@RequestParam(name = "qrraw") String qrraw) {
    log.info("request {}", qrraw);
    return receiptService.getJson(qrraw);
  }

  @PostMapping
  public ResponseEntity<ReceiptShortInfo> save(@RequestBody SaveRequest saveRequest) throws JsonProcessingException {
    log.info("ReceiptController:: save request qrraw = {} ", saveRequest.qrraw());
    return ResponseEntity.ok(receiptFacade.saveReceipt(saveRequest.qrraw()));
  }

}
