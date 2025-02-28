package by.iskander.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * RatingDto
 */
@Getter
@Setter
@Comment("Рейтинги")
public class RatingDto {
    private UUID id;
    private BigDecimal salary;
    private BigDecimal productionVolume;
    private BigDecimal countOfEmployers;
    private UserDto user;
}
