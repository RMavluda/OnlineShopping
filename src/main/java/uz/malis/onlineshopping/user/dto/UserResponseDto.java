package uz.malis.onlineshopping.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.customer.CustomerEntity;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;

@Getter
@Setter
public class UserResponseDto {

  private CustomerResponseDTO customer;

  @Schema(title = "name")
  private String name;

  @Schema(title = "username")
  private String username;

  @Schema(title = "password")
  private String password;

  @OneToOne
  @JoinColumn(name = "id", referencedColumnName = "user ID")
  @Schema(title = "id")
  private CustomerEntity CustomerEntity;

}
