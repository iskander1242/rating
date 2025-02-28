package by.iskander.domain.model;

import by.iskander.TypeOfPeriod;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link Period}
 */
public record PeriodDto(TypeOfPeriod type, Integer numberOfPeriod, LocalDate startDate,
                        LocalDate endDate) implements Serializable {
}