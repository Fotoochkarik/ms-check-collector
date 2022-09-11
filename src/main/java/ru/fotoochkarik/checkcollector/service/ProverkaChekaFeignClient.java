package ru.fotoochkarik.checkcollector.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fotoochkarik.checkcollector.data.dto.request.RequestInfo;
import ru.fotoochkarik.checkcollector.data.dto.response.ReceiptInfo;

@FeignClient(
    value = "proverka-cheka",
    url = "https://proverkacheka.com/api/v1/check/get"
)
public interface ProverkaChekaFeignClient {

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  ReceiptInfo getReceiptInfo(RequestInfo post);

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  String getJsonChek(RequestInfo post);

}
