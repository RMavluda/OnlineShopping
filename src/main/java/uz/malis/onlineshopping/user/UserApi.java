package uz.malis.onlineshopping.user;

import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

public interface UserApi {

  @GetMapping
  ResponseEntity<List<UserEntity>> findAll();

  @GetMapping("/{id}")
  ResponseEntity<Optional<UserEntity>> findByid(Long id);

  @PostMapping
  ResponseEntity<Void> createUser(UserRequestDto requestDto);

  @PatchMapping("/{id}")
  ResponseEntity<Void> updateUser(@PathVariable Long id, UserUpdateDto updateDto);

  @DeleteMapping("/{id}")
  ResponseEntity<Void> deleteUser(@PathVariable Long id);
}
