package uz.malis.onlineshopping.customers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomersController {

  private final CustomerService customerService;
  @Autowired
  public CustomersController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/customers")
  public String findAll(Model model){
    List<CustomersEntity> customersEntities = customerService.findAll();
    model.addAttribute("customers", customersEntities);
    return "customers-list";
  }

  @GetMapping("/customers-create")
  public String createCustomerForm(CustomersEntity customersEntity){
    return "/customers-create";
  }

  @PostMapping("/customers-create")
  public String createCustomers(CustomersEntity customersEntity){
      customerService.saveCustomers(customersEntity);
      return "redirect:/customers";
  }

  @GetMapping("/customer-delete/{id}")
  public String deleteCustomer(@PathVariable("id") Long id){
    customerService.delete(id);
    return "redirect:/customers";
  }

  @GetMapping("/customer-update/{id}")
  public String updateCustomerForm(@PathVariable("id") Long id, Model model){
      Optional<CustomersEntity> customersEntity =customerService.findById(id);
      model.addAttribute("customer", customersEntity);
      return "/customer-update";
  }

  @PostMapping("/user-update")
  public String updateCustomer(CustomersEntity customersEntity){
  customerService.saveCustomers(customersEntity);
  return "redirect:/customers";
  }
}