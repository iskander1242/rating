package by.iskander.repository;

import by.iskander.domain.model.Rating;
import by.iskander.domain.model.SummaryRating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {
    Rating getById(UUID id);

    @Query("SELECT new by.iskander.domain.model.SummaryRating(AVG(e.salary), SUM(e.productionVolume), SUM(e.countOfEmployers)) FROM Rating e")
    SummaryRating findSummaryRating();
}