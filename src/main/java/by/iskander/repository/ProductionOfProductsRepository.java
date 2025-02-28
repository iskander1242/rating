package by.iskander.repository;

import by.iskander.TypeOfPeriod;
import by.iskander.domain.model.Period;
import by.iskander.domain.model.ProductionOfProducts;
import by.iskander.domain.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductionOfProductsRepository extends JpaRepository<ProductionOfProducts, Integer> {
    List<ProductionOfProducts> getByPeriod_Type(TypeOfPeriod typeOfPeriod);
}