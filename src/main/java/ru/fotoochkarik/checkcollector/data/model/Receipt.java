package ru.fotoochkarik.checkcollector.data.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, exclude = {"items"})
@Table(schema = "receipt", name = "receipt")
public class Receipt extends BaseEntity {

  private double nds10;
  private double nds18;
  private double nds0;
  @Column(name = "ndsno")
  private double ndsNo;
  private LocalDateTime dateTime;
  private double totalSum;
  private double creditSum;
  private double prepaidSum;
  private double cashTotalSum;
  private double provisionSum;
  @Column(name = "e_cash_total_sum")
  private double eCashTotalSum;
  private float operationType;
  private String retailPlaceAddress;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "receipt")
  private List<Item> items = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  private Metadata metadata;

}