package com.demo.spring_agenda.controller;

import com.demo.spring_agenda.dto.ContactRequestDTO;
import com.demo.spring_agenda.dto.ContactResponseDTO;
import com.demo.spring_agenda.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contacts")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService){
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(@RequestBody @Valid ContactRequestDTO dto){
        ContactResponseDTO response = contactService.saveContact(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getById(Long id){
        ContactResponseDTO response = contactService.getContactById(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> findAll(){
        return ResponseEntity.ok(contactService.findAllContacts());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(Long id){
        contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll(){
        contactService.deleteAllContacts();
        return ResponseEntity.noContent().build();
    }
}
