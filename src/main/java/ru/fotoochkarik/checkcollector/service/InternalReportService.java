package ru.fotoochkarik.checkcollector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fotoochkarik.checkcollector.integration.feign.InternalReportClient;
import ru.fotoochkarik.generated.v1.dto.ExpenseRequest;
import ru.fotoochkarik.generated.v1.dto.ExpenseResponse;

@RequiredArgsConstructor
@Service
public class InternalReportService {

  private final InternalReportClient internalReportClient;

  public ExpenseResponse addReceiptToReport(ExpenseRequest expenseRequest) {
    return internalReportClient.addReceiptInfo(expenseRequest);
  }

}
