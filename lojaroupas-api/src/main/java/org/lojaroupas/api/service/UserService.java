package org.lojaroupas.api.service;

import org.lojaroupas.api.domain.model.User;
import org.lojaroupas.api.dto.UserRegistrationDto;

public interface UserService {

  User register(UserRegistrationDto registrationDto);
}
