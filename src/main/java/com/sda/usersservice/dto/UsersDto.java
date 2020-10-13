package com.sda.usersservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor(staticName = "of")
@Builder
public class UsersDto {

    private String firstName;
    private String lastName;
}
