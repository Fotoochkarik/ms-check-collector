package ru.fotoochkarik.checkcollector.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fotoochkarik.checkcollector.data.model.Metadata;

public interface MetadataRepository extends JpaRepository<Metadata, UUID> {

}