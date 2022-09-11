package ru.fotoochkarik.checkcollector.data.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author v.schelkunov
 * @version 1.0
 * @since 1.0.0
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(schema = "receipt", name = "item")
public class Item extends BaseEntity {

  private Double nds;
  private Double sum;
  private String name;
  private Double price;
  private Double ndsSum;
  private Long quantity;
  private Integer paymentType;
  private Integer productType;
  private String propertiesItem;
  private Integer itemsQuantityMeasure;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "receipt_id")
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Receipt receipt;

}
