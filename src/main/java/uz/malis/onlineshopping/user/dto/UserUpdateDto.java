package uz.malis.onlineshopping.user.dto;

import jakarta.validation.constraints.Size;

public class UserUpdateDto {

  @Size(max = 50)
  private String name;
  @Size(max = 50)
  private String username;
  @Size(max = 50)
  private String password;

}
