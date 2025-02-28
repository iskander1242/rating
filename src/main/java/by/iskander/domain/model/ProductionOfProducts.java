package by.iskander.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;

/**
 * Рейтинги
 */
@Getter
@Setter
@Entity
@Table(name = "production_of_products")
@Comment("Рейтинги")
@SuperBuilder
@NoArgsConstructor
public class ProductionOfProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = true)
    private BigDecimal salary;

    @Column(nullable = true)
    private BigDecimal productionVolume;

    @Column(nullable = true)
    private BigDecimal countOfEmployers;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "period_id", referencedColumnName = "id")
    private Period period;

}
