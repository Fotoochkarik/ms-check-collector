package ru.fotoochkarik.checkcollector.data.dto.request;

import java.time.Month;
import ru.fotoochkarik.checkcollector.data.dto.enums.ExpenseType;

public record ExpenseResponse(ExpenseType type, double sum, Double totalSum, Month month, Integer year) {

}
