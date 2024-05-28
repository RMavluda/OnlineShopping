package uz.malis.onlineshopping.order;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;
import uz.malis.onlineshopping.customer.CustomerEntity;
import uz.malis.onlineshopping.orderdetail.OrderDetailsEntity;

@Data
@Entity
@Table(name="orders")
public class OrdersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "id")
  private CustomerEntity customerId;

  @Column(name = "order_date")
  private LocalDate orderDate;

  @Column(name = "status")
  private OrderStatus status;

  @Column(name = "price")
  private Long price;

  @OneToOne
  @JoinColumn(name = "order_details_id")
  private OrderDetailsEntity orderDetailsEntity;

  @ManyToOne
  @JoinColumn(name = "customera_id")
  private CustomerEntity customersEntity;
}
