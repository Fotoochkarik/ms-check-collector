package ru.fotoochkarik.checkcollector.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.fotoochkarik.checkcollector.data.dto.request.RequestInfo;

@Slf4j
@Service
public class ExternalReceiptService {

  @Value("${feign.proverkacheka.token}")
  private String token;

  public RequestInfo createRequestInfo(String qrraw) {
    return new RequestInfo(qrraw, "3", token);
  }


  @PostConstruct
  public void print() {
    log.error("TOKEN {} ", token);
  }

}
