package store.repository;

import store.domain.User;

import java.util.List;

public interface UserRepository {
    User getById(Integer id);
    List<User> getAll();
    User saveOrUpdate(User user);
    void remove(User user);
}
