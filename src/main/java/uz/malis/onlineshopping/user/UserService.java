package uz.malis.onlineshopping.user;

import java.util.List;
import java.util.Optional;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

public interface UserService {

  List<UserEntity> findAll();

  void save(UserRequestDto requestDto);

  Optional<UserEntity> findById(Long id);

  void delete(Long id);

  void update(Long id, UserUpdateDto updateDto);
}
