package store.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import store.domain.UserGroup;
import store.repository.UserGroupRepository;

import java.util.List;

@Repository
public class UserGroupRepositoryImpl implements UserGroupRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public List<UserGroup> getAll() {
        return getCurrentSession().createCriteria(UserGroup.class).list();
    }

    public UserGroup getById(Integer id) {
        return getCurrentSession().get(UserGroup.class, id);
    }

    public UserGroup saveOrUpdate(UserGroup userGroup) {
        getCurrentSession().saveOrUpdate(userGroup);
        return userGroup;
    }

    public void remove(UserGroup userGroup) {
        getCurrentSession().delete(userGroup);
    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
