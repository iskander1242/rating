package by.iskander.domain.model;

import by.iskander.TypeOfPeriod;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SuperBuilder
public class Period implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    private TypeOfPeriod type;
    private Integer numberOfPeriod;
    private LocalDate startDate = LocalDate.now();
    private LocalDate endDate = LocalDate.now();

    @OneToOne(mappedBy = "period")
    private ProductionOfProducts productionOfProducts;
}
