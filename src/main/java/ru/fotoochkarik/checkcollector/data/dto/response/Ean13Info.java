package ru.fotoochkarik.checkcollector.data.dto.response;

public record Ean13Info(String rawProductCode,
                        float productIdType,
                        String gtin,
                        String sernum) {

}