package uz.malis.onlineshopping.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity
@Table(name="products")
public class ProductsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "price")
  private Long price;

  @Column(name = "description")
  private String description;

  @Column(name = "photo_path")
  private String photoPath;
}
