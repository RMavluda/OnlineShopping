package uz.malis.onlineshopping.customers;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import uz.malis.onlineshopping.users.UserEntity;

@Data
@Entity
@ToString
@RequiredArgsConstructor
@Table(name="customers")
public class CustomersEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name = "name")
      private String name;

      @Column(name = "address")
      private String address;

      @Column(name = "contact")
      private String contact;

      @Column(name = "user_id")
      private Long userId;

      @OneToOne
      @JoinColumn(name = "user_id")
      private UserEntity userEntity;
}
