package uz.malis.onlineshopping.customers.dto;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.users.UserEntity;

@Getter
@Setter
public class CustomersRequestDTO {

    @NotBlank
    @Size(max = 50)
    private String name;

    @NotBlank
    @Size(max = 100)
    private String address;

    @NotBlank
    @Size(max = 50)
    private String contact;

    @OneToOne
    @NotNull
    private UserEntity userEntity;
}
