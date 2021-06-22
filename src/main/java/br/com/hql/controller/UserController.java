package br.com.hql.controller;

import br.com.hql.dto.UserDTO;
import br.com.hql.entities.User;
import br.com.hql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAllUsers () {
        return userService.listAllUser();
    }

    @GetMapping("/find")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findByUserNameContains (@RequestParam String name) {
        return userService.findByUserNameContains(name);
    }

    @GetMapping("/find/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByUserNameContains (@PathVariable Integer id) {
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser (@RequestBody User user) {
        userService.create(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser (@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUserPassword (@PathVariable Integer id, @RequestBody UserDTO user) {
        userService.updateUserPassword(id, user);
    }

}
