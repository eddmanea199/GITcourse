package sda.remote.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import sda.remote.springboot.model.User;
import sda.remote.springboot.model.UserDto;


public interface UserService extends UserDetailsService {
    User save(UserDto userDto);
}
