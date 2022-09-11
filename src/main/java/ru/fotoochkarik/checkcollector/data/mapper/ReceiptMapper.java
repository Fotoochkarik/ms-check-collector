package ru.fotoochkarik.checkcollector.data.mapper;

import static java.util.Objects.nonNull;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.fotoochkarik.checkcollector.data.dto.response.BodyReceiptInfo;
import ru.fotoochkarik.checkcollector.data.model.Receipt;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", uses = ItemMapper.class)
public interface ReceiptMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "metadata.id", ignore = true)
  @Mapping(target = "metadata.externalId", source = "metadata.id")
  @Mapping(target = "totalSum", expression = "java(this.convert(bodyReceiptInfo.totalSum()))")
  @Mapping(target = "creditSum", expression = "java(this.convert(bodyReceiptInfo.creditSum()))")
  @Mapping(target = "prepaidSum", expression = "java(this.convert(bodyReceiptInfo.prepaidSum()))")
  @Mapping(target = "cashTotalSum", expression = "java(this.convert(bodyReceiptInfo.cashTotalSum()))")
  @Mapping(target = "provisionSum", expression = "java(this.convert(bodyReceiptInfo.provisionSum()))")
  Receipt toReceipt(BodyReceiptInfo bodyReceiptInfo);

  @Mapping(target = "metadata.id", source = "metadata.externalId")
  BodyReceiptInfo toBodyReceiptInfo(Receipt receipt);

  default Double convert(Float date) {
    return nonNull(date) ? (double) date / 100 : null;
  }
}
