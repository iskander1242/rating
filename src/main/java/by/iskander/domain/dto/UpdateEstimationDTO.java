package by.iskander.domain.dto;

import by.iskander.domain.model.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

/**
 * UpdateEstimationDTO
 */
@Getter
@Setter
@Comment("UpdateEstimationDTO")
@Data
@NoArgsConstructor
public class UpdateEstimationDTO {
    private Long userId;
    private LocalDate localDate;
}
