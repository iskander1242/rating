package by.iskander.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_seq")
    @SequenceGenerator(name = "user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = true)
    private String password;

    @JsonIgnore
    @Column(name = "email", unique = true, nullable = true)
    private String email;

    @JsonIgnore
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = true)
    private Role role;

    @JsonIgnore
    @Column(name = "first_name")
    private String firstName;

    @JsonIgnore
    @Column(name = "last_name")
    private String lastName;

    @Column(name = "industry")
    private String industry;

    @JsonIgnore
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isEnabled() {
        return true;
    }

//    @OneToMany(cascade = CascadeType.MERGE, mappedBy = "user")
//    private List<Rating> ratings;

    @Column(name = "estimated_date_time", nullable = true)
    private LocalDate estimatedDate;
}

