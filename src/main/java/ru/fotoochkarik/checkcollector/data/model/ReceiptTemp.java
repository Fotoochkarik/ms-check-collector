package ru.fotoochkarik.checkcollector.data.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(schema = "receipt", name = "receipt_temp")
public class ReceiptTemp {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "data")
  private String data;

  @Column(name = "created")
  private LocalDateTime created;

  @Column(name = "request", unique = true)
  private String request;

}
