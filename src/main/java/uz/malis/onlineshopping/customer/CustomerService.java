package uz.malis.onlineshopping.customer;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;

@Service
public interface CustomerService {

  List<CustomerResponseDTO> getCustomers(CustomerFilterParams filterParams, Pageable pageable);

  List<CustomerResponseDTO> getById(Long id);

  public void save(CustomerRequestDTO requestDTO);

  public void delete(Long id);

  public void update(Long id, CustomerUpdateDTO updateDTO);
}
