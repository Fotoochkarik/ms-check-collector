package ru.fotoochkarik.checkcollector.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.fotoochkarik.checkcollector.data.dto.request.ExpenseRequest;
import ru.fotoochkarik.checkcollector.data.dto.request.ExpenseResponse;
import ru.fotoochkarik.checkcollector.integration.feign.InternalReportClient;

@RequiredArgsConstructor
@Service
public class InternalReportService {

  private final InternalReportClient internalReportClient;

  public ExpenseResponse addReceiptToReport(ExpenseRequest expenseRequest) {
    return internalReportClient.addReceiptInfo(expenseRequest);
  }

}
