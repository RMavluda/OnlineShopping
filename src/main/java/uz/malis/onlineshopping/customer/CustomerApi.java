package uz.malis.onlineshopping.customer;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;

@RequestMapping("/v1/customers")
public interface CustomerApi {


  @GetMapping
  ResponseEntity<List<CustomerEntity>> findAll(
      CustomerFilterParams filterParams,
      Pageable pageable
  );

  @GetMapping("/{id}")
  ResponseEntity<CustomerResponseDTO> getCustomerById(
      @PathVariable Long id);

  @PostMapping
  ResponseEntity<Void> createCustomer(
      @Valid @RequestBody CustomerRequestDTO requestDTO
  );

  @PatchMapping("/{id}")
  ResponseEntity<Void> updateCustomer(
      @PathVariable Long id,
      @Valid @RequestBody CustomerUpdateDTO updateDTO
  );

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteCustomer(
      @PathVariable Long id
  );
}
