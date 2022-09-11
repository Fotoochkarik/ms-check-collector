package ru.fotoochkarik.checkcollector.data.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataInfo(String html,
                       @JsonProperty("json")
                       BodyReceiptInfo bodyReceiptInfo) {

}