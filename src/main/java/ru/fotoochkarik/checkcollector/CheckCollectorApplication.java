package ru.fotoochkarik.checkcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CheckCollectorApplication {

  public static void main(String[] args) {
    SpringApplication.run(CheckCollectorApplication.class, args);
  }

}
