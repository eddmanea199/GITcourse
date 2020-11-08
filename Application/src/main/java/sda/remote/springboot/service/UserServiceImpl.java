package sda.remote.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sda.remote.springboot.model.User;
import sda.remote.springboot.model.UserDto;
import sda.remote.springboot.repository.UserRepository;

import java.util.Collections;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User save(UserDto userDto) {
        User user = new User();

        user.setEmail(userDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));

        userRepository.save(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        return userRepository.findByEmail(s)
                             .map(user -> new org.springframework.security.core.userdetails.User(user.getEmail(),
                                     user.getPassword(),
                                     Collections.singletonList(new SimpleGrantedAuthority(user.getRole()))))
                             .orElseThrow(() -> new UsernameNotFoundException("Invalid Email or Password"));
    }

}
