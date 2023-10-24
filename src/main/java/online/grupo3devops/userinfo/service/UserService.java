package online.grupo3devops.userinfo.service;

import online.grupo3devops.userinfo.dto.UserDTO;
import online.grupo3devops.userinfo.entity.User;
import online.grupo3devops.userinfo.mapper.UserMapper;
import online.grupo3devops.userinfo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public List<UserDTO> findAllUsers(){
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper.INSTANCE::mapUserToUserDTO).collect(Collectors.toList());
    }
    public UserDTO addUserInBD(UserDTO userDTO){
        User saveUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
        return UserMapper.INSTANCE.mapUserToUserDTO(saveUser);
    }

    public ResponseEntity<UserDTO> fetchUserById(Long userId){
        Optional<User> user = userRepo.findById(userId);
        if(user.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(user.get()), HttpStatus.OK);
    }
}
