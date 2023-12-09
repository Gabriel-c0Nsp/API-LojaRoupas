package org.lojaroupas.api.service;

import org.lojaroupas.api.domain.model.User;

public interface UserService {

  User register(User userToRegister);
}
