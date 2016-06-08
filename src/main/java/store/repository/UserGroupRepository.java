package store.repository;

import store.domain.UserGroup;

import java.util.List;

public interface UserGroupRepository {
    List<UserGroup> getAll();
    UserGroup getById(Integer id);
    UserGroup saveOrUpdate(UserGroup userGroup);
    void remove(UserGroup userGroup);
}
