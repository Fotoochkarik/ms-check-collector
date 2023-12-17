package ru.fotoochkarik.checkcollector.data.mapper;

import static java.util.Objects.nonNull;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValueCheckStrategy;
import ru.fotoochkarik.checkcollector.data.model.Item;
import ru.fotoochkarik.generated.v1.dto.ItemInfo;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ItemMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "nds", source = "nds" , qualifiedByName = "convertToDouble")
  @Mapping(target = "sum", source = "sum" , qualifiedByName = "convertToDouble")
  @Mapping(target = "price", source = "price" , qualifiedByName = "convertToDouble")
  @Mapping(target = "ndsSum", source = "ndsSum" , qualifiedByName = "convertToDouble")
  Item toItem(ItemInfo itemInfo);

  List<Item> toItemList(List<ItemInfo> itemInfoList);

  @Named("convertToDouble")
  default Double convert(Long value) {
    return nonNull(value) ? (double) value / 100 : null;
  }

}
