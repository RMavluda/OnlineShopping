package uz.malis.onlineshopping.customer;

import java.util.List;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.malis.onlineshopping.customer.dto.CustomerRequestDTO;
import uz.malis.onlineshopping.customer.dto.CustomerResponseDTO;
import uz.malis.onlineshopping.customer.dto.CustomerUpdateDTO;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

  CustomerEntity toEntity(CustomerRequestDTO requestDTO);

  CustomerResponseDTO toResponseDto(CustomerEntity entity);

  List<CustomerResponseDTO> toResponseDto(List<CustomerEntity> entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void update(@MappingTarget CustomerEntity entity, CustomerUpdateDTO requestDto);


}
