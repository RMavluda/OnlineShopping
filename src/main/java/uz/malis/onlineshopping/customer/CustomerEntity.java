package uz.malis.onlineshopping.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import uz.malis.onlineshopping.user.UserEntity;

@Getter
@Setter
@Entity
@ToString
@RequiredArgsConstructor
@Table(name="customers")
public class CustomerEntity {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      @Column(name = "name")
      private String name;

      @Column(name = "address")
      private String address;

      @Column(name = "contact")
      private String contact;

      @OneToOne
      @JoinColumn(name = "user_id")
      private UserEntity userEntity;
}
