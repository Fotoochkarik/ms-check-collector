package ru.fotoochkarik.checkcollector.data.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Table(schema = "receipt", name = "meta_data")
public class Metadata extends BaseEntity {

  private Long externalId;
  private String ofdId;
  private String address;
  private String subtype;
  @UpdateTimestamp
  private LocalDateTime receiveDate;

}