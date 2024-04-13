package uz.malis.onlineshopping.orders;

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
import uz.malis.onlineshopping.customers.CustomersEntity;
import uz.malis.onlineshopping.orderdetails.OrderDetailsEntity;

@Data
@Entity
@Table(name="orders")
public class OrdersEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "customer_id")
  private CustomersEntity customerId;

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
  private CustomersEntity customersEntity;
}
