package by.iskander.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SummaryRatingDto {
    private Double avgSalary;
    private BigDecimal sumProductionVolume;
    private BigDecimal avgCountOfEmployers;

    public SummaryRatingDto(Double avgSalary, BigDecimal sumProductionVolume, BigDecimal avgCountOfEmployers) {
        this.avgSalary = avgSalary;
        this.sumProductionVolume = sumProductionVolume;
        this.avgCountOfEmployers = avgCountOfEmployers;
    }
}
