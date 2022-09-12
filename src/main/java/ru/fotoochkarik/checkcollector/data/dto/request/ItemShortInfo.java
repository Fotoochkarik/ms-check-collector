package ru.fotoochkarik.checkcollector.data.dto.request;

public record ItemShortInfo(String name,
                            Long quantity,
                            Long price,
                            Long sum) {

}