package oye.demo.springboot.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import oye.demo.springboot.user.model.User;
import oye.demo.springboot.user.service.UserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsersPage(ModelMap modelMap) {
        modelMap.addAttribute("userList", userService.list());
        return "user";
    }

    @GetMapping(value = "/add")
    public String addUserPage(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "userAdd";
    }

    @PostMapping
    public String addUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/user";
    }


}
