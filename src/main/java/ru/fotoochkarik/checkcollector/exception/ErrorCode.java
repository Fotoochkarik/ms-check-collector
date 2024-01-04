package ru.fotoochkarik.checkcollector.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

  FCC_1("FCC-0001"),
  FCC_2("FCC-0002");

  ErrorCode(String value) {
  }

  @Getter
  String value;

}
