package io.dewe.assignment.security;

import io.dewe.assignment.model.Role;
import io.dewe.assignment.model.User;
import io.dewe.assignment.util.SecurityUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserPrincipal implements UserDetails {

    private Long id;
    private String username;
    transient private String    password; //don;t show on serializied places
    transient private User user; //user for only login operation, NOT JWT
    private Set<GrantedAuthority>   authorities;

    public static UserPrincipal createSuperUser()
    {
        Set<GrantedAuthority> authorities = Collections.singleton(SecurityUtils.convertToAuthority(Role.SYSTEM_MANAGER.name()));
        return  UserPrincipal.builder()
                .id(-1L)
                .username("system-adminstrator")
                .authorities(authorities)
                .build();
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
}
