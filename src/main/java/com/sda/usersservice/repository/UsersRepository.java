package com.sda.usersservice.repository;

import com.sda.usersservice.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
