package ru.fotoochkarik.checkcollector.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

public record BodyReceiptInfo(float code,
                              List<ItemInfo> items,
                              float nds10,
                              float nds18,
                              float nds0,
                              float ndsNo,
                              String fnsUrl,
                              LocalDateTime dateTime,
                              @JsonProperty("metadata")
                              MetadataInfo metadata,
                              float totalSum,
                              float creditSum,
                              float prepaidSum,
                              String retailPlace,
                              float cashTotalSum,
                              float provisionSum,
                              @JsonProperty("ecashTotalSum")
                              float eCashTotalSum,
                              float operationType,
                              float appliedTaxationType) {

}