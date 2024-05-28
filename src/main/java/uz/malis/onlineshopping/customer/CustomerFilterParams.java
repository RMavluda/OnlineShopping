package uz.malis.onlineshopping.customer;

import lombok.Getter;
import lombok.Setter;
import uz.malis.onlineshopping.user.UserEntity;

@Setter
@Getter
public class CustomerFilterParams {

  private Long id;
  private String name;
  private String address;
  private String contact;
  private UserEntity userEntity;
}
