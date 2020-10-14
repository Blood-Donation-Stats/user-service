package com.sda.usersservice.controller;

import com.sda.usersservice.domain.Users;
import com.sda.usersservice.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping
    public Page<Users> getUsers(Pageable pageable) {
        return usersService.findAll(pageable);
    }

    @GetMapping("/{id}")
    public Users getUsersById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Users updateUserById(@PathVariable Long id, @RequestBody Users user) {
        return usersService.updateById(id, user);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Users createUser(@RequestBody Users user) {
        return usersService.create(user);
    }

    @DeleteMapping("/{id}")
    public Users deleteUserById(@PathVariable Long id) {
        return usersService.delete(id);
    }

}
