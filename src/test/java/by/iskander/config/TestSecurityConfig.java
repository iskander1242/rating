package by.iskander.config;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Profile("test") // Только для профиля "test"
public class TestSecurityConfig {

    @Bean
    public SecurityFilterChain testSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Явное отключение CSRF
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll() // Разрешить все запросы
                );
        return http.build();
    }

    @Bean
    public TestRestTemplate restTemplate() {
        return new TestRestTemplate();
    }
}

