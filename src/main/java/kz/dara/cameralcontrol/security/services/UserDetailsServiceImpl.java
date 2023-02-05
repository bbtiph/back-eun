package kz.dara.cameralcontrol.security.services;

import kz.dara.cameralcontrol.model.User;
import kz.dara.cameralcontrol.repository.LocalUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final LocalUserRepository localUserRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = localUserRepository.findUserByUsername(username);
        if (user != null)
            return UserDetailsImpl.build(user);
        return null;
    }
}
