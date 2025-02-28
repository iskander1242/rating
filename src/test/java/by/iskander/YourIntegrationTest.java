package by.iskander;

import by.iskander.controller.UserController;
import by.iskander.domain.dto.UserDto;
import by.iskander.domain.model.Role;
import by.iskander.domain.model.Status;
import by.iskander.domain.model.User;
import by.iskander.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(classes = {
        RatingApplication.class
})
@AutoConfigureMockMvc
public class YourIntegrationTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private UserController userController;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    static final String URL = "http://localhost:8099/api/v1/user/all";
//
//    @Autowired
//    TestRestTemplate restTemplate;
//
//    @BeforeEach
//    public void setup() {
//        userRepository.deleteAll();
//    }
//
//    // Метод подготовки пользователя
//    private void prepareUserForSignIn() {
//        userRepository.deleteAll();
//
//        // Создаем пользователя для теста входа
//        User user = User.builder()
//                .username("testuser")
//                .password(passwordEncoder.encode("password123"))
//                .email("testuser@example.com")
//                .role(Role.ROLE_USER)
//                .status(Status.ACTIVE)
//                .build();
//        userRepository.save(user);
//    }
//
//    @Test
//    public void integrationTest() throws Exception {
//        prepareUserForSignIn();
//
//        ResponseEntity<Iterable<UserDto>> departmentsResponse = restTemplate
//                .exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<Iterable<UserDto>>() {
//                });
//        assertThat(departmentsResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
////        assertThat(departmentsResponse.getBody().getFirst().getId()).isNotNull();
//
//    }
}

