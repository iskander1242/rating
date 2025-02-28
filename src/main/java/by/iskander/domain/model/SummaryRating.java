package by.iskander.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class SummaryRating {
    private Double avgSalary;
    private BigDecimal sumProductionVolume;
    private BigDecimal avgCountOfEmployers;

    public SummaryRating(Double avgSalary, BigDecimal sumProductionVolume, BigDecimal avgCountOfEmployers) {
        this.avgSalary = avgSalary;
        this.sumProductionVolume = sumProductionVolume;
        this.avgCountOfEmployers = avgCountOfEmployers;
    }
}
