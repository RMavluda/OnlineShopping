package uz.malis.onlineshopping.customer;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;
import uz.malis.onlineshopping.user.UserMapper;
import uz.malis.onlineshopping.user.dto.UserRequestDto;

@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository repository;
  private final CustomerMapper mapper;
  private final UserMapper userMapper;

  @Override
  public List<CustomerResponseDTO> getCustomers(
      CustomerFilterParams filterParams,
      Pageable pageable) {
    return mapper.toResponseDto(repository.findAll());
  }

  @Override
  public List<CustomerResponseDTO> getById(Long id) {
    return mapper.toResponseDto(repository.findByIdAndDeletedAtIsNull(id));
  }

  @Override
  public void save(CustomerRequestDTO requestDTO) {
    var entity = mapper.toEntity(requestDTO);
    entity.setUserEntity(userMapper.toEntity(new UserRequestDto(
        requestDTO.getName(),
        requestDTO.getUsername(),
        requestDTO.getPassword())));
    repository.save(entity);
  }

  @Override
  public void delete(Long id) {
    repository.deleteById(id);
  }

  @Override
  public void update(Long id, CustomerUpdateDTO updateDTO) {
    var entity = repository.findById(id).get();
    mapper.update(entity, updateDTO);
    repository.save(entity);
  }
}
