package uz.malis.onlineshopping.user;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService service;
  @GetMapping
  public ResponseEntity<List<UserEntity>> findAll(){
    return ResponseEntity.ok(service.findAll());
  }

  @PostMapping
  public ResponseEntity<Void> createUser(UserRequestDto requestDto){
    service.save(requestDto);
    return ResponseEntity.ok().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> updateUser(@PathVariable Long id, UserUpdateDto updateDto){
    service.update(id, updateDto);
    return ResponseEntity.ok().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.ok().build();
  }

}
