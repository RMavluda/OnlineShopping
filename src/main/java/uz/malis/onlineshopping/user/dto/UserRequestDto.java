package uz.malis.onlineshopping.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.user.UserEntity;

@Setter
@Getter
@AllArgsConstructor
public class UserRequestDto extends UserEntity {
  @NotBlank
  @Size(max = 50)
  private String name;

  @NotBlank
  @Size(max = 50)
  private String username;

  @NotBlank
  @Size(max = 50)
  private String password;

}
