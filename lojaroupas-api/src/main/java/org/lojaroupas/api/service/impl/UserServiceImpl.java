package org.lojaroupas.api.service.impl;

import org.lojaroupas.api.domain.model.User;
import org.lojaroupas.api.domain.repository.UserRepository;
import org.lojaroupas.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User register(User userToRegister) {
    User user = new User(userToRegister.getName(), userToRegister.getPhoneNumber(), userToRegister.getEmail(), userToRegister.getPassword());

    return userRepository.save(user);
  }
}
