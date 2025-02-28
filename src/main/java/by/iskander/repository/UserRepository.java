package by.iskander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import by.iskander.domain.model.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);

    @Modifying
    @Query("update User u set u.estimatedDate = :date where u.id = :user")
    void updateEstimatedDateTimeForUser(LocalDate date, Long user);

    @Query("select u from User u where u.estimatedDate <= :estimatedDate")
    List<User> getUserByWhereEstimationExpired(LocalDate estimatedDate);
}