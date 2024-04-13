package uz.malis.onlineshopping.orderdetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import uz.malis.onlineshopping.orders.OrdersEntity;

@Data
@Entity
@Table(name="order_details")
public class OrderDetailsEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "order_id")
  private Long orderId;

  @Column(name = "shipping_type")
  private String shippingType;

  @Column(name = "create_date")
  private LocalDate createDate;

  @OneToOne
  @JoinColumn(name = "orders_id")
  private OrdersEntity ordersEntity;
}
