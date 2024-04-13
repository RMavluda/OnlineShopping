package uz.malis.onlineshopping.customers.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.users.UserEntity;

@Getter
@Setter
public class CustomersResponseDTO {

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
