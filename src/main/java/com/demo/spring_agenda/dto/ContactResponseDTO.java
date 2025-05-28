package com.demo.spring_agenda.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
}
