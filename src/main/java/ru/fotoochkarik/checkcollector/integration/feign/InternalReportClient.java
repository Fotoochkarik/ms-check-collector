package ru.fotoochkarik.checkcollector.integration.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import ru.fotoochkarik.checkcollector.data.dto.request.ExpenseRequest;
import ru.fotoochkarik.checkcollector.data.dto.request.ExpenseResponse;

@FeignClient(
    value = "internal-report",
    url = "${feign.report.host}"
)
public interface InternalReportClient {

  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, value = "/add")
  ExpenseResponse addReceiptInfo(ExpenseRequest expenseRequest);

}
