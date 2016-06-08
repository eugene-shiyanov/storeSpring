package store.service;

import store.domain.UserGroup;

import java.util.List;

public interface UserGroupService {
    List<UserGroup> getAll();
    UserGroup getById(Integer id);
    UserGroup saveOrUpdate(UserGroup userGroup);
    void remove(UserGroup userGroup);
}
