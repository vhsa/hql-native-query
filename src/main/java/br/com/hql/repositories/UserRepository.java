package br.com.hql.repositories;

import br.com.hql.dto.UserDTO;
import br.com.hql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // list all
    @Query(value = "select * from hql.usuario", nativeQuery = true)
    List<User> listAllUsers ();

    List<User> findByNameContaining(String name);

//    @Query(value = "select u from User u where u.name like %:name%")
    @Query(value = "select * from hql.usuario u where u.name like %:name%", nativeQuery = true)
    List<User> findByUserName(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "insert into hql.usuario (name, password) values (:name, :password)", nativeQuery = true)
    void create(@Param("name") String name, @Param("password") String password);

    @Query(value = "select * from hql.usuario where id = :id", nativeQuery = true)
    User findUserById(Integer id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hql.usuario WHERE id = :id", nativeQuery = true)
    void deleteUser(@Param("id") Integer id);

    @Transactional
    @Modifying
    @Query(value = " UPDATE hql.usuario SET password = :pass WHERE id = :id", nativeQuery = true)
    void updatePassword(@Param("id") Integer id, @Param("pass") String pass);
}
