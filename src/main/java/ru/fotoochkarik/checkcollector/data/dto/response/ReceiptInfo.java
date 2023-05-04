package ru.fotoochkarik.checkcollector.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ReceiptInfo(Integer code,
                          @JsonProperty(value = "data")
                          DataInfo dataInfo) {

}
