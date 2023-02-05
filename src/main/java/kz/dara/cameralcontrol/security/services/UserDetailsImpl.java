package kz.dara.cameralcontrol.security.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kz.dara.cameralcontrol.model.User;
import kz.dara.cameralcontrol.util.UserHelper;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private final Long id;

    private final String username;

    private final String email;

    private final String firstName;

    private final String surname;

    private final String middleName;

    private final Boolean active;

    @JsonIgnore
    private String password;

    private final Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl(Long userId, String username, String firstName, String lastName,
                           String middleName, String emailAddress, Boolean active, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = userId;
        this.username = username;
        this.email = emailAddress;
        this.surname = lastName;
        this.middleName = middleName;
        this.firstName = firstName;
        this.active = active;
        this.authorities = authorities;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {
       List<GrantedAuthority> authorities = UserHelper.getRoles(user).stream()
               .map(SimpleGrantedAuthority::new)
               .collect(Collectors.toList());

        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getEmailAddress(),
                true,
                user.getPassword(),
                authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}
