package br.com.hql.service;

import br.com.hql.dto.UserDTO;
import br.com.hql.entities.User;
import br.com.hql.exception.UserNotFoundException;
import br.com.hql.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // list all user
    public List<UserDTO> listAllUser() {
        List<User> users = userRepository.listAllUsers();

        List<UserDTO> list = new ArrayList<>();

        for (User u : users) {
            UserDTO userDTO = new UserDTO(u.getId(), u.getName(), u.getPassword());
            list.add(userDTO);
        }

        return list;
    }

    public List<User> findByUserNameContains (String name) {
        List<User> users = userRepository.findByUserName(name);

        return users;
    }

    public void create (User user) {
        userRepository.create(user.getName(), user.getPassword());
    }

    public UserDTO findUserById(Integer id) {
        User user = userRepository.findUserById(id);

        if ( user != null )
            return UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .password(user.getPassword())
                    .build();

        throw new UserNotFoundException("User not found");
    }

    public void deleteUser ( Integer id ) {
        this.findUserById(id);

        userRepository.deleteUser(id);
    }

    public void updateUserPassword(Integer id, UserDTO user) {
        this.findUserById(id);

        userRepository.updatePassword(id, user.getPassword());
    }
}
