package by.iskander;

import by.iskander.domain.model.Role;
import by.iskander.domain.model.Status;
import by.iskander.domain.model.User;
import by.iskander.repository.UserRepository;
import by.iskander.service.RatingService;
import com.google.common.collect.ArrayListMultimap;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Optional;

import static java.awt.SystemColor.text;

@Slf4j
@SpringBootApplication
@AllArgsConstructor
public class RatingApplication {

    private final UserRepository userRepository;
    private final RatingService ratingService;
    private final GitInfo gitInfo;
    private final PropertySourcesPlaceholderConfigurer placeholderConfigurer;

    public static void main(String[] args) {
        SpringApplication.run(RatingApplication.class, args);
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("ApplicationReadyEvent");

        User admin = User.builder().id(1L)
                .email("admin@admin.com")
                .role(Role.ROLE_ADMIN)
                .username("admin")
                .lastName("admin")
                .firstName("admin")
                .password("$2a$12$fIJTP4TghDJwPZxmUneqReZpfXcf8MnGdrnuC.0VQYg6bpAzgBRGG")
                .status(Status.ACTIVE)
                .build();


        log.debug("This is a debug message");
        log.trace("This is a debug message");
        log.info("This is an info message");
        log.warn("This is a warn message");
        log.error("This is an error message");
        ratingService.testLOg();

        if (userRepository.count() == 0) {
            userRepository.save(admin);
        }

        Optional<User> admin1 = userRepository.findByUsername("admin");

        log.info(gitInfo.getCommitId());
        log.info(gitInfo.getCommitMessage());
        log.info(gitInfo.getBranch());

        String key = "a-key";
        ArrayListMultimap<@Nullable String, @Nullable String> map = ArrayListMultimap.create();

        map.put(key, "firstValue");
        map.put(key, "secondValue");

        log.info("" + map.size());
        log.info("" + map.get("a-key"));
        log.info(String.valueOf(Integer.valueOf("001")));
//        int  partitionindex = 0;
//        if (partitionindex <= 0){
//            throw new IllegalArgumentException ("partitionindex should be greater than 0");
//        }
//        QuadConsumer<Integer,Integer,Integer,Integer> quadConsumer =
//        (value0, value1,value2, value3) -> {
//            int i = value0 + value1;
//        };
    }

    @FunctionalInterface
    public interface QuadConsumer<T, U, V, W> {
        void accept(T t, U u, V v, W w);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propsConfig
                = new PropertySourcesPlaceholderConfigurer();
        propsConfig.setLocation(new ClassPathResource("git.properties"));
        propsConfig.setIgnoreResourceNotFound(true);
        propsConfig.setIgnoreUnresolvablePlaceholders(true);
        return propsConfig;
    }
}