package oye.demo.springboot.user.service;

import oye.demo.springboot.user.model.User;

import java.util.List;

public interface UserService {
    User oneById(Long id);

    Integer add(User user);

    Integer update(User user);

    Integer delete(Long id);

    List<User> list();
}
