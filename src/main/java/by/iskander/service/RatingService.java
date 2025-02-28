package by.iskander.service;

import by.iskander.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import by.iskander.domain.dto.RatingDto;
import by.iskander.domain.dto.SummaryRatingDto;
import by.iskander.domain.model.Rating;
import by.iskander.repository.RatingRepository;
import by.iskander.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class RatingService {
    private final RatingRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final UserService userService;

    public List<Rating> getAll() {
        return repository.findAll();
    }

    public Rating getById(UUID id) {
        return repository.getById(id);
    }

    public Rating add(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        User user = userRepository.getReferenceById(ratingDto.getUser().getId());
        userService.updateEstimatedDateTimeForUser(null,user.getId());
        rating.setUser(user);
        return repository.save(rating);
    }

    public Rating update(RatingDto ratingDto) {
        Rating rating = modelMapper.map(ratingDto, Rating.class);
        User user = userRepository.getReferenceById(ratingDto.getUser().getId());
        userService.updateEstimatedDateTimeForUser(null,user.getId());
        rating.setUser(user);
        return repository.save(rating);
    }

    public SummaryRatingDto getSummaryRating() {
        return  modelMapper.map(repository.findSummaryRating(), SummaryRatingDto.class);
    }


    public void testLOg() {
       log.trace("TRACE");
    }

}
