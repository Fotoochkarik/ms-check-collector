package ru.fotoochkarik.checkcollector.data.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProductCode {

  KMK("kmk"),
  EAN13("ean13");

  private final String value;
}
