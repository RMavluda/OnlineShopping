package uz.malis.onlineshopping.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

  @Schema(title = "name")
  private String name;

  @Schema(title = "username")
  private String username;

  @Schema(title = "password")
  private String password;

}
