package ru.fotoochkarik.checkcollector.data.dto.request;

import java.time.LocalDate;
import ru.fotoochkarik.checkcollector.data.dto.enums.ExpenseType;

public record ExpenseRequest(ExpenseType type, Double sum, LocalDate payDate) {

}
