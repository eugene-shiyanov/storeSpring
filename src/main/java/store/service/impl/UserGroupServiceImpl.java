package store.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import store.domain.UserGroup;
import store.repository.UserGroupRepository;
import store.service.UserGroupService;

import java.util.List;

@Service
@Transactional(transactionManager = "jpaTxManager")
public class UserGroupServiceImpl implements UserGroupService {

    @Autowired
    @Qualifier("userGroupJpaRepositoryImpl")
    private UserGroupRepository userGroupRepository;

    public List<UserGroup> getAll() {
        return userGroupRepository.getAll();
    }

    public UserGroup getById(Integer id) {
        return userGroupRepository.getById(id);
    }

    public UserGroup saveOrUpdate(UserGroup userGroup) {
        return userGroupRepository.saveOrUpdate(userGroup);
    }

    public void remove(UserGroup userGroup) {
        userGroupRepository.remove(userGroup);
    }
}
