package com.tsola2002.phoneBook.controller

import com.tsola2002.phoneBook.dto.ContactDTO
import com.tsola2002.phoneBook.entity.Contact
import com.tsola2002.phoneBook.repository.ContactRepository
import com.tsola2002.phoneBook.service.ContactService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/contacts")
class ContactController(val contactService: ContactService, val contactRepository: ContactRepository) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun addContact(@RequestBody contactDTO: ContactDTO){
        return contactService.addContact(contactDTO)
    }

    @GetMapping
    fun retrieveAllContacts() : List<ContactDTO> = contactService.retrieveAllContacts()


    @GetMapping("/{contact_id}")
    fun retrieveContactById(@PathVariable contact_id: Int): Contact {
        return contactRepository.findById(contact_id).orElseThrow()
    }


    @PutMapping("/{contact_id}")
    fun updateCourse(@RequestBody contactDTO: ContactDTO,
                    @PathVariable("contact_id") contactId: Int)
    = contactService.updateContact(contactId, contactDTO)


    @DeleteMapping("/{contact_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCourse(@PathVariable("contact_id") contactId: Int)
    = contactService.deleteContact(contactId)



}