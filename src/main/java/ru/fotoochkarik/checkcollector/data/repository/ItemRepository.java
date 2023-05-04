package ru.fotoochkarik.checkcollector.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fotoochkarik.checkcollector.data.model.Item;

public interface ItemRepository extends JpaRepository<Item, UUID> {

}