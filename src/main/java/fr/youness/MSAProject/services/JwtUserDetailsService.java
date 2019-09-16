package fr.youness.MSAProject.services;

import java.util.ArrayList;

import fr.youness.MSAProject.dao.UserDao;
import fr.youness.MSAProject.models.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        fr.youness.MSAProject.models.User _user = userDao.findByUsername(username);
        if(_user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(_user.getUsername(), _user.getPassword(), new ArrayList<>());
    }

    public fr.youness.MSAProject.models.User save(UserDto user) {
        fr.youness.MSAProject.models.User newUser = new fr.youness.MSAProject.models.User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.save(newUser);
        return newUser;
    }
}