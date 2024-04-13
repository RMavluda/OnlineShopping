package uz.malis.onlineshopping.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import uz.malis.onlineshopping.customers.CustomersEntity;

@Data
@Entity
@Table(name="users")
public class UserEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "password")
  private String password;

  @OneToOne
  @JoinColumn(name = "customers_id")
  private CustomersEntity customersEntity;
}
