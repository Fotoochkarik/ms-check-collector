package ru.fotoochkarik.checkcollector.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.fotoochkarik.checkcollector.data.model.ReceiptTemp;

public interface ReceiptTempRepository extends JpaRepository<ReceiptTemp, Long> {

  boolean existsByRequest(String request);

}
