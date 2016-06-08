package store.repository.impl;

import org.springframework.stereotype.Repository;
import store.domain.UserGroup;
import store.repository.UserGroupRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class UserGroupJpaRepositoryImpl implements UserGroupRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<UserGroup> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserGroup> cq = cb.createQuery(UserGroup.class);
        cq.from(UserGroup.class);
        TypedQuery<UserGroup> typedQuery = entityManager.createQuery(cq);
        return typedQuery.getResultList();
    }

    public UserGroup getById(Integer id) {
        return entityManager.find(UserGroup.class, id);
    }

    public UserGroup saveOrUpdate(UserGroup userGroup) {
        return entityManager.merge(userGroup);
    }

    public void remove(UserGroup userGroup) {
        entityManager.remove(userGroup);
    }
}
