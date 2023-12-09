package org.lojaroupas.api.dto;

public class UserRegistrationDto {

  private String name;
  private Long phoneNumber;
  private String email;
  private String password;

  public UserRegistrationDto(String name, Long phoneNumber, String email, String password) {
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(Long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
