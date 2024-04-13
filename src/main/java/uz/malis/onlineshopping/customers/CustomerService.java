package uz.malis.onlineshopping.customers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  private final CustomersRepository customersRepository;
  @Autowired
  public CustomerService(CustomersRepository customersRepository) {
    this.customersRepository = customersRepository;
  }
  public List<CustomersEntity> findAll(){
    return customersRepository.findAll();
  }
  public void saveCustomers(CustomersEntity customersEntity){
    customersRepository.save(customersEntity);
  }
  public Optional<CustomersEntity> findById(Long id){
    return customersRepository.findById(id);
  }
  public void delete(Long id){
    customersRepository.deleteById(id);
  }
}
