package ru.fotoochkarik.checkcollector.data.dto.response;

public record ItemInfo(Long nds,
                       Long sum,
                       String name,
                       Long price,
                       Long ndsSum,
                       Long quantity,
                       Integer paymentType,
                       Integer productType,
                       String propertiesItem,
                       Integer itemsQuantityMeasure,
                       ProductCodeNewInfo productCodeNew,
                       float labelCodeProcesMode,
                       float checkingProdInformationResult) {

}
