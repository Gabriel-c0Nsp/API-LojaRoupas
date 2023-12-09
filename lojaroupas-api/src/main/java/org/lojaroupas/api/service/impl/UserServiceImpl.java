package org.lojaroupas.api.service.impl;

import org.lojaroupas.api.domain.model.User;
import org.lojaroupas.api.domain.repository.UserRepository;
import org.lojaroupas.api.dto.UserRegistrationDto;
import org.lojaroupas.api.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User register(UserRegistrationDto registrationDto) {
    User user = new User(registrationDto.getName(), registrationDto.getPhoneNumber(), registrationDto.getEmail(),
        registrationDto.getPassword());
    return userRepository.save(user);
  }
}
