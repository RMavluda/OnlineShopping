package uz.malis.onlineshopping.customer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;
import uz.malis.onlineshopping.user.UserMapper;
import uz.malis.onlineshopping.user.dto.UserRequestDto;

@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepository repository;
  private final CustomerMapper mapper;
  private final UserMapper userMapper;

  public List<CustomerResponseDTO> findAll(){
    return mapper.toResponseDto(repository.findAll());
  }
  public void save(CustomerRequestDTO requestDTO){

    var entity = mapper.toEntity(requestDTO);
    entity.setUserEntity(userMapper.toEntity(new UserRequestDto(
        requestDTO.getName(),
        requestDTO.getUsername(),
        requestDTO.getPassword())));
    repository.save(entity);
  }
//  public Optional<CustomerRequestDTO> findById(Long id){
//    return repository.findById(id);
//  }
  public void delete(Long id){
    repository.deleteById(id);
  }

  public void update(Long id, CustomerUpdateDTO updateDTO) {
    var entity = repository.findById(id).get();
    mapper.update(entity, updateDTO);
    repository.save(entity);

  }
}
