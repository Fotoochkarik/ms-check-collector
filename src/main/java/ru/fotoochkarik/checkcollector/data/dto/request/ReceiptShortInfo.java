package ru.fotoochkarik.checkcollector.data.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import ru.fotoochkarik.checkcollector.data.model.Item;

public record ReceiptShortInfo(LocalDateTime dateTime,
                               float totalSum,
                               List<ItemShortInfo> items) {

}
