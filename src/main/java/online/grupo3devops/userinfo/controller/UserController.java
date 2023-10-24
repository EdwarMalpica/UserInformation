package online.grupo3devops.userinfo.controller;

import online.grupo3devops.userinfo.dto.UserDTO;
import online.grupo3devops.userinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<UserDTO>> fetchAllUsers(){
        List<UserDTO> allUsers = userService.findAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
    @PostMapping("/addUser")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        UserDTO userAdded = userService.addUserInBD(userDTO);
        return new ResponseEntity<>(userAdded, HttpStatus.CREATED);
    }
    @GetMapping("/fetchById/{userId}")
    public ResponseEntity<UserDTO> findUserById(@PathVariable Long userId){
        return userService.fetchUserById(userId);
    }
}
