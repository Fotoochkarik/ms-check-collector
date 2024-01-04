package ru.fotoochkarik.checkcollector.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.fotoochkarik.checkcollector.BaseTest;
import ru.fotoochkarik.checkcollector.data.repository.ReceiptRepository;
import ru.fotoochkarik.checkcollector.data.repository.ReceiptTempRepository;
import ru.fotoochkarik.checkcollector.integration.feign.ExternalReceiptClient;
import ru.fotoochkarik.checkcollector.integration.feign.InternalReportClient;
import ru.fotoochkarik.generated.v1.dto.CreateReceiptRequest;
import ru.fotoochkarik.generated.v1.dto.ExpenseResponse;
import ru.fotoochkarik.generated.v1.dto.ReceiptInfo;
import ru.fotoochkarik.generated.v1.dto.ReceiptShortInfo;

@AutoConfigureMockMvc
class ReceiptControllerTest extends BaseTest {

  @Autowired
  private MockMvc mockMvc;
  @Autowired
  private ReceiptTempRepository receiptTempRepository;
  @Autowired
  private ReceiptRepository receiptRepository;

  @MockBean
  private ExternalReceiptClient externalReceiptClient;
  @MockBean
  private InternalReportClient internalReportClient;

  @Test
  void createReceipt() throws Exception {
    var request = new CreateReceiptRequest().createRequest("t=20220530T2019&s=472.00&fn=9960440300581089&i=57051&fp=936536390&n=1");
    ReceiptInfo receiptInfo = Instancio.create(ReceiptInfo.class);
    when(externalReceiptClient.getReceiptInfo(any())).thenReturn(receiptInfo);
    ExpenseResponse expenseResponse = Instancio.create(ExpenseResponse.class);
    when(internalReportClient.addReceiptInfo(any())).thenReturn(expenseResponse);

    assertEquals(0, receiptTempRepository.count());
    assertEquals(0, receiptRepository.count());

    var result = mockMvc.perform(post("/api/latest/receipt/")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(jsonHelper.asJsonString(request)))
        .andDo(print())
        .andExpect(status().isOk())
        .andReturn();

    ReceiptShortInfo receiptShortInfo = jsonHelper.asObject(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ReceiptShortInfo.class);
    assertEquals(receiptInfo.getData().getJson().getDateTime(), receiptShortInfo.getDateTime());
    assertEquals(1, receiptTempRepository.count());
    assertTrue(receiptTempRepository.existsByRequest(request.getCreateRequest()));
    assertEquals(1, receiptRepository.count());
  }

  @Test
  void createReceiptExternalReceiptClientNotAvailable() throws Exception {
    var request = new CreateReceiptRequest().createRequest("t=20220530T2019&s=472.00&fn=9960440300581089&i=57051&fp=936536390&n=1");
    when(externalReceiptClient.getReceiptInfo(any())).thenThrow(RuntimeException.class);
    ExpenseResponse expenseResponse = Instancio.create(ExpenseResponse.class);
    when(internalReportClient.addReceiptInfo(any())).thenReturn(expenseResponse);

    mockMvc.perform(post("/api/latest/receipt/")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(jsonHelper.asJsonString(request)))
        .andDo(print())
        .andExpect(status().isInternalServerError());
  }

  @Test
  void createReceiptBadRequest() throws Exception {
    var request = new CreateReceiptRequest()
        .createRequest("x=20220530T2019&s=472.00&fn=9960440300581089&i=57051&fp=936536390&n=1");

    var result = mockMvc.perform(post("/api/latest/receipt/")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(jsonHelper.asJsonString(request)))
        .andDo(print())
        .andExpect(status().isBadRequest())
        .andReturn();

    String message = Objects.requireNonNull(result.getResolvedException()).getMessage();
    assertEquals(String.format("The request = %s does not meet the requirements", request.getCreateRequest()), message);
  }

}