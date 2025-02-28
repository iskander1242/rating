package by.iskander.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Comment;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Рейтинги
 */
@Getter
@Setter
@Entity
@Table(name = "ratings")
@Comment("Рейтинги")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(nullable = true)
    private BigDecimal salary;

    @Column(nullable = true)
    private BigDecimal productionVolume;

    @Column(nullable = true)
    private BigDecimal countOfEmployers;

    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    @JsonView({View.UserControllerView.class})
    private User user;
}
