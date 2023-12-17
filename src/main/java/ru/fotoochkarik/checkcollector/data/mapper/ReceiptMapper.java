package ru.fotoochkarik.checkcollector.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.fotoochkarik.checkcollector.data.model.Receipt;
import ru.fotoochkarik.generated.v1.dto.BodyReceiptInfo;
import ru.fotoochkarik.generated.v1.dto.ExpenseRequest;
import ru.fotoochkarik.generated.v1.dto.ReceiptShortInfo;

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
  @Mapping(target = "totalSum", source = "totalSum", qualifiedByName = "convertToDouble")
  @Mapping(target = "creditSum", source = "creditSum", qualifiedByName = "convertToDouble")
  @Mapping(target = "prepaidSum", source = "prepaidSum", qualifiedByName = "convertToDouble")
  @Mapping(target = "cashTotalSum", source = "cashTotalSum", qualifiedByName = "convertToDouble")
  @Mapping(target = "provisionSum", source = "provisionSum", qualifiedByName = "convertToDouble")
  Receipt toReceipt(BodyReceiptInfo bodyReceiptInfo);

  ReceiptShortInfo toReceiptShortInfo(Receipt receipt);

  @Mapping(target = "sum", source = "totalSum")
  @Mapping(target = "payDate", source = "metadata.receiveDate")
  @Mapping(target = "type", constant = "EVERYDAY")
  ExpenseRequest toExpenseRequest(Receipt receipt);

}
