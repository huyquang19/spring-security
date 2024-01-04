package com.example.shopee_security.service;

import com.example.shopee_security.model.User;
import com.example.shopee_security.repository.UserRepository;
import com.example.shopee_security.view.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> users = userRepository.findUsersByUsername(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(users.get());
    }

    public UserDetails loadUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            throw new UsernameNotFoundException(userId.toString());
        }
        return new CustomUserDetails(user.get());
    }

    public Boolean createUser(User user) {

        userRepository.save(user);
        return true;
    }
}
