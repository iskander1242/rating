package by.iskander;

import by.iskander.domain.model.Role;
import by.iskander.domain.model.Status;
import by.iskander.domain.model.User;
import by.iskander.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Test
//    public void testSignUp() throws Exception {
//        String signUpRequest = """
//                {
//                    "username": "testuser",
//                    "password": "password123",
//                    "email": "testuser@example.com"
//                }
//                """;
//
//        mockMvc.perform(post("/auth/sign-up")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(signUpRequest))
//                .andExpect(status().isOk()) // Ожидаем статус 200 OK
//                .andExpect(jsonPath("$.token").exists()); // Проверяем, что токен присутствует в ответе
//    }
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
//    public void testSignIn() throws Exception {
//        prepareUserForSignIn();
//
//        String signInRequest = """
//                {
//                    "username": "testuser",
//                    "password": "password123"
//                }
//                """;
//
//        mockMvc.perform(post("/auth/sign-in")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(signInRequest))
//                .andExpect(status().isOk()) // Ожидаем статус 200 OK
//                .andExpect(jsonPath("$.token").exists()); // Проверяем, что токен присутствует в ответе
//    }
}

