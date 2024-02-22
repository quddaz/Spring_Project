package hellojpa.domain.ValueType;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.time.LocalDateTime;

@Embeddable
@Data
public class Period {
  private LocalDateTime startDate;
  private LocalDateTime endDate;
}
