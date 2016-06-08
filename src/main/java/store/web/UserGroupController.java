package store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import store.domain.UserGroup;
import store.service.UserGroupService;

import java.util.List;

@Controller
@RequestMapping("/userGroups")
public class UserGroupController {
    @Autowired
    private UserGroupService userGroupService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<UserGroup> getUserGroups() {
        return userGroupService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public UserGroup saveUserGroup(@RequestBody UserGroup userGroup) {
        return userGroupService.saveOrUpdate(userGroup);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public UserGroup getUserGroup(@PathVariable Integer id) {
        return userGroupService.getById(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public UserGroup updateUserGroup(@PathVariable Integer id, @RequestBody UserGroup userGroup) {
        return userGroupService.saveOrUpdate(userGroup);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeUserGroup(@PathVariable Integer id) {
        UserGroup userGroup = userGroupService.getById(id);

        if (userGroup == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        userGroupService.remove(userGroup);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
