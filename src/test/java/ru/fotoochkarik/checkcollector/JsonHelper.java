package ru.fotoochkarik.checkcollector;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class JsonHelper {

  @Autowired
  private ObjectMapper objectMapper;

  public String asJsonString(final Object obj) {
    try {
      return objectMapper.writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public <T> T getDataFromJson(String jsonPath, Class<T> dataClass) throws IOException {
    return objectMapper.readValue(new ClassPathResource(jsonPath, this.getClass().getClassLoader()).getInputStream(), dataClass);
  }

  public <T> T asObject(final String jsonString, Class<T> returnType) throws JsonProcessingException {
    return objectMapper.readValue(jsonString, returnType);
  }

}
