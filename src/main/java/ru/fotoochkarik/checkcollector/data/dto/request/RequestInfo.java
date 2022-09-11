package ru.fotoochkarik.checkcollector.data.dto.request;

import feign.form.FormProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author v.schelkunov
 * @version 1.0.0
 * @since 1.0.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestInfo {

  @FormProperty(value = "qrraw")
  private String request;
  private String qr;
  private String token;

}
