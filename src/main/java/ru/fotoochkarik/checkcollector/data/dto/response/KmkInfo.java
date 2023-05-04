package ru.fotoochkarik.checkcollector.data.dto.response;

public record KmkInfo(String rawProductCode,
                      float productIdType,
                      String gtin,
                      String sernum) {

}