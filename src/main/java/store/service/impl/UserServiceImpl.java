package store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.domain.User;
import store.repository.UserRepository;
import store.service.UserService;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    public User getById(Integer id) {
        return userRepository.getById(id);
    }

    public List<User> getAll() {
        return userRepository.getAll();
    }

    public User saveOrUpdate(User user) {
        return userRepository.saveOrUpdate(user);
    }

    public void remove(User user) {
        userRepository.remove(user);
    }
}
