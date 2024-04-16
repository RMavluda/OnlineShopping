package uz.malis.onlineshopping.user;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.malis.onlineshopping.user.dto.UserRequestDto;
import uz.malis.onlineshopping.user.dto.UserUpdateDto;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository repository;
  private final UserMapper mapper;

  public List<UserEntity> findAll(){
    return repository.findAll();
  }

  public void save(UserRequestDto requestDto){
      UserEntity userEntity = mapper.toEntity(requestDto);
      repository.save(userEntity);
  }
  public Optional<UserEntity> findById(Long id){
    return repository.findById(id);
  }

  public void delete(Long id){
    repository.deleteById(id);
  }

  public void update(Long id, UserUpdateDto updateDto){
    var entity = repository.findById(id).get();
    mapper.update(entity, updateDto);
    repository.save(entity);
  }
}
