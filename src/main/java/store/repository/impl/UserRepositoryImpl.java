package store.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import store.domain.User;
import store.repository.UserRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public User getById(Integer id) {
        return getCurrentSession().get(User.class, id);
    }

    public List<User> getAll() {
        return getCurrentSession().createCriteria(User.class).list();
    }

    public User saveOrUpdate(User user) {
        getCurrentSession().saveOrUpdate(user);
        return user;
    }

    public void remove(User user) {
        getCurrentSession().delete(user);
    }
}
