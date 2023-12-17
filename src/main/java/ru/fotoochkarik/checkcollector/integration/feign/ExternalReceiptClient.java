package ru.fotoochkarik.checkcollector.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fotoochkarik.checkcollector.data.dto.request.RequestInfo;
import ru.fotoochkarik.generated.v1.dto.ReceiptInfo;

@FeignClient(
    value = "proverka-cheka",
    url = "${feign.proverkacheka.host}"
)
public interface ExternalReceiptClient {

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  ReceiptInfo getReceiptInfo(RequestInfo post);

  @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  String getJsonChek(RequestInfo post);

}
