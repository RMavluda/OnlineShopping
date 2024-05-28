package uz.malis.onlineshopping.customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import uz.malis.onlineshopping.user.UserEntity;

@Data
@Entity
@Table(name="customers")
public class CustomerEntity {

  private static final String GENERATOR_NAME = "customers_gen";
  private static final String SEQUENCE_NAME = "customers_seq";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = GENERATOR_NAME)
  @SequenceGenerator(name = GENERATOR_NAME, sequenceName = SEQUENCE_NAME, allocationSize = 1)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "address", nullable = false)
  private String address;

  @Column(name = "contact", nullable = false)
  private String contact;

  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity userEntity;
}
