package org.lojaroupas.api.controller;

import org.lojaroupas.api.dto.UserRegistrationDto;
import org.lojaroupas.api.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lojaroupas/user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto registrationDto) {
    userService.register(registrationDto);
    return "redirect:/lojaroupas?success";
  }

}
