package ru.fotoochkarik.checkcollector.service;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.fotoochkarik.checkcollector.data.dto.request.RequestInfo;

@Slf4j
@Service
public class FeignService {

  @Value("${app.proverkacheka.token}")
  private String token;

  public RequestInfo createRequestInfo(String qrraw) {
    RequestInfo requestInfo = new RequestInfo();
    requestInfo.setRequest(qrraw);
    requestInfo.setQr("3");
    requestInfo.setToken(token);
    return requestInfo;
  }


  @PostConstruct
  public void print() {
    log.error("TOKEN {} ", token);
  }

}
