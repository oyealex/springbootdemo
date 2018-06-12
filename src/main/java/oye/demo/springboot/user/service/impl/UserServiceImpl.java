package oye.demo.springboot.user.service.impl;

import org.springframework.stereotype.Service;
import oye.demo.springboot.user.model.User;
import oye.demo.springboot.user.service.UserService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private Map<Long, User> userDb = new HashMap<Long, User>();

    public User oneById(Long id) {
        return userDb.get(id);
    }

    public Integer add(User user) {
        user.setId(userDb.size() + 1L);
        userDb.put(user.getId(), user);
        return 1;
    }

    public Integer update(User user) {
        if (userDb.keySet().contains(user.getId())) {
            userDb.put(user.getId(), user);
            return 1;
        } else {
            return 0;
        }
    }

    public Integer delete(Long id) {
        userDb.remove(id);
        return 1;
    }

    public List<User> list() {
        return new ArrayList<User>(userDb.values());
    }
}
