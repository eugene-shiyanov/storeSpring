package store.service;

import store.domain.User;

import java.util.List;

public interface UserService {
    User getById(Integer id);
    List<User> getAll();
    User saveOrUpdate(User user);
    void remove(User user);
}
