package uz.malis.onlineshopping.productorder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import uz.malis.onlineshopping.orders.OrdersEntity;
import uz.malis.onlineshopping.products.ProductsEntity;

@Entity
@Data
@Table(name="product_order")
public class ProductOrderEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "product_id")
  private Long productId;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "create_date")
  private LocalDate createDate;

  @ManyToOne
  @JoinColumn(name = "orders_id")
  private OrdersEntity ordersEntity;

  @ManyToOne
  @JoinColumn(name = "products_id")
  private ProductsEntity productsEntity;

}
