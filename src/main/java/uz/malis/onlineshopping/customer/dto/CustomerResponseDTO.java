package uz.malis.onlineshopping.customer.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.user.UserEntity;
import uz.malis.onlineshopping.user.dto.UserResponseDto;

@Getter
@Setter
public class CustomerResponseDTO {

      private UserResponseDto user;

      @Schema(title = "name")
      private String name;

      @Schema(title = "address")
      private String address;

      @Schema(title = "contact")
      private String contact;

      @OneToOne
      @JoinColumn(name = "user ID", referencedColumnName = "id")
      @Schema(title = "user ID")
      private UserEntity userEntity;
}
