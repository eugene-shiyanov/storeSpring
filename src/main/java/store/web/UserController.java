package store.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.domain.User;
import store.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<User> users() {
        return userService.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody User addUser(@RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(path = "/{userid}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable("userid") Integer userID) {
        return userService.getById(userID);
    }

    @RequestMapping(path = "/{userid}", method = RequestMethod.PUT)
    public @ResponseBody User editUser(@PathVariable("userid") Integer userID, @RequestBody User user) {
        return userService.saveOrUpdate(user);
    }

    @RequestMapping(path = "/{userid}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> removeUser(@PathVariable("userid") Integer userID) {
        User user = userService.getById(userID);

        if (user == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        userService.remove(user);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
