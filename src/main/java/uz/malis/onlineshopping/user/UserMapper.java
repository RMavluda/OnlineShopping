package uz.malis.onlineshopping.user;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserResponseDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
  UserEntity toEntity(UserRequestDto userRequestDto);

  UserResponseDto toResponseDto(UserEntity entity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void update(@MappingTarget UserEntity entity, UserUpdateDto requestDto);

}
