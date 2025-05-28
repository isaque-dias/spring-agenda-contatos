package com.demo.spring_agenda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    private String email;

    private String phoneNumber;

    @NotNull
    private String address;
}
