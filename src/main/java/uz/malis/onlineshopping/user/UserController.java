package uz.malis.onlineshopping.user;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements UserApi{

  private final UserService service;

  @Override
  public ResponseEntity<List<UserEntity>> findAll(){
    return ResponseEntity.ok(service.findAll());
  }

  @Override
  public ResponseEntity<Optional<UserEntity>> findByid(Long id){
    return ResponseEntity.ok(service.findById(id));
  }
  @Override
  public ResponseEntity<Void> createUser(UserRequestDto requestDto){
    service.save(requestDto);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> updateUser(@PathVariable Long id, UserUpdateDto updateDto){
    service.update(id, updateDto);
    return ResponseEntity.ok().build();
  }

  @Override
  public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    service.delete(id);
    return ResponseEntity.ok().build();
  }

}
