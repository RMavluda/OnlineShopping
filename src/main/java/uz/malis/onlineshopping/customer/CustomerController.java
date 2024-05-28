package uz.malis.onlineshopping.customer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController implements CustomerApi{

  private final CustomerService service;

  @Override
  public ResponseEntity<List<CustomerEntity>> findAll(CustomerFilterParams filterParams,
      Pageable pageable) {
    return null;
  }

  @GetMapping("/{id}")
  public ResponseEntity<CustomerResponseDTO> getCustomerById(Long id){
    return ResponseEntity.ok((CustomerResponseDTO) service.getById(id));
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
