package uz.malis.onlineshopping.customer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

  private final CustomerService service;

  @GetMapping
  public ResponseEntity<List<CustomerResponseDTO>> findAll() {
    return ResponseEntity.ok(service.findAll());
  }

  @PostMapping
  public ResponseEntity<Void> createCustomer(CustomerRequestDTO requestDTO) {
    service.save(requestDTO);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateCustomer(@PathVariable Long id, CustomerUpdateDTO updateDTO) {
    service.update(id, updateDTO);
    return ResponseEntity.ok().build();

  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    service.delete(id);
    return ResponseEntity.ok().build();
  }
}
