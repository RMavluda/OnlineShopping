package uz.malis.onlineshopping.customer.dto;

import jakarta.validation.constraints.Size;

public class CustomerUpdateDTO {

  private String name;

  @Size(max = 100)
  private String address;

  @Size(max = 50)
  private String contact;

  private Long userId;
}
