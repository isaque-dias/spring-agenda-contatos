package com.demo.spring_agenda.service;

import com.demo.spring_agenda.dto.ContactRequestDTO;
import com.demo.spring_agenda.dto.ContactResponseDTO;
import com.demo.spring_agenda.exception.ResourceNotFoundException;
import com.demo.spring_agenda.model.Contact;
import com.demo.spring_agenda.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    // Salvando o Contato no Banco de Dados
    public ContactResponseDTO saveContact(ContactRequestDTO dto){
        Contact contact = toEntity(dto);
        Contact contactSaved = contactRepository.save(contact);
        return toResponseDTO(contactSaved);
    }

    // Buscando Contato no Banco através do ID
    public ContactResponseDTO getContactById(Long id){
        Contact contact =  contactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Contact not found with id: " + id));
        return toResponseDTO(contact);
    }

    // Listando todos os Contatos salvos
    public List<ContactResponseDTO> findAllContacts(){
        return contactRepository.findAll()
                .stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());
    }

    // Deletando um Contato através do ID
    public void deleteContactById(Long id){
        if(!contactRepository.existsById(id)){
            throw new ResourceNotFoundException("Contact not found with id: " + id);
        }
        contactRepository.deleteById(id);
    }

    // Deletando todos os contatos salvos
    public void deleteAllContacts(){
        contactRepository.deleteAll();
    }

    // Convertendo DTO de Entrada para Entidade (Contact)
    private Contact toEntity(ContactRequestDTO dto){
        return Contact.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .address(dto.getAddress())
                .build();
    }

    // Convertendo Entidade (Contact) para DTO de saída
    private ContactResponseDTO toResponseDTO(Contact contact){
        return ContactResponseDTO.builder()
                .id(contact.getId())
                .name(contact.getName())
                .email(contact.getEmail())
                .phoneNumber(contact.getPhoneNumber())
                .address(contact.getAddress())
                .build();
    }
}
