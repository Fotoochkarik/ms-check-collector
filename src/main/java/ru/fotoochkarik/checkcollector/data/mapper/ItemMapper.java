package ru.fotoochkarik.checkcollector.data.mapper;

import static java.util.Objects.nonNull;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import ru.fotoochkarik.checkcollector.data.dto.response.ItemInfo;
import ru.fotoochkarik.checkcollector.data.model.Item;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface ItemMapper {

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "nds", expression = "java(this.convert(itemInfo.nds()))")
  @Mapping(target = "sum", expression = "java(this.convert(itemInfo.sum()))")
  @Mapping(target = "price", expression = "java(this.convert(itemInfo.price()))")
  @Mapping(target = "ndsSum", expression = "java(this.convert(itemInfo.ndsSum()))")
  Item toItem(ItemInfo itemInfo);

  List<Item> toItemList(List<ItemInfo> itemInfoList);

  default Double convert(Long date) {
    return nonNull(date) ? (double) date / 100 : null;
  }

}
