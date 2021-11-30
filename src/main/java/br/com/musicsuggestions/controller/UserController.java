package br.com.musicsuggestions.controller;

import br.com.musicsuggestions.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

  List<User>ArrayUser = new ArrayList<>();

  @GetMapping("/{id}")
  public Optional<User> getUserById(@PathVariable("id") Long id) {
   Optional<User> userFind = ArrayUser.stream().filter(user -> user.getId() == id).findFirst();

    return userFind;
  }

  @PostMapping("/")
  public User createUser(@RequestBody User newUser) {
    ArrayUser.add(newUser);
    return newUser;
  }

  @GetMapping("/list")
  public List<User> getAllUsers() {
    return ArrayUser;
  }
}
