package org.marcosdantas.trabalhouninter.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;
import lombok.Data;
import org.marcosdantas.trabalhouninter.util.LocalDateTimeEpochDeserializer;

@Entity
@Data
public class TaskEntity {
  @GeneratedValue
  @Id
  @Schema(hidden = true)
  private Long id;
 private String taskName;
 private String taskResponsible;

  @JsonDeserialize(using = LocalDateTimeEpochDeserializer.class)
  @Schema(type = "integer", format = "int64", description = "Timestamp em milissegundos ou segundos desde o epoch")
  private LocalDateTime deliveryDate;
}
