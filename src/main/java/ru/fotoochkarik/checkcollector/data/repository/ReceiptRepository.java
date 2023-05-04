package ru.fotoochkarik.checkcollector.data.repository;

import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fotoochkarik.checkcollector.data.model.Receipt;

public interface ReceiptRepository extends JpaRepository<Receipt, UUID> {

  boolean existsByDateTimeAndTotalSum(LocalDateTime dateTime, double totalSum);

}