package com.sda.usersservice.service;

import com.sda.usersservice.domain.Users;
import com.sda.usersservice.exception.InvalidUpdateException;
import com.sda.usersservice.exception.UsersNotFound;
import com.sda.usersservice.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository usersRepository;

    public Users create(Users users) {
        return usersRepository.save(users);
    }

    public Page<Users> findAll(Pageable pageable) {
        return usersRepository.findAll(pageable);
    }

    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFound(String.format("User with %d not found.", id)));
    }

    public Users delete(Long id) {
        Users user = findById(id);
        usersRepository.deleteById(id);

        return user;
    }

    public Users updateById(Long id, Users user) {
        if (!id.equals(user.getId())) {
            throw new InvalidUpdateException("User id not match!");
        }

        if (!usersRepository.existsById(id)) {
            throw new UsersNotFound(String.format("User with %d not found.", id));
        }

        return usersRepository.save(user);
    }

}
