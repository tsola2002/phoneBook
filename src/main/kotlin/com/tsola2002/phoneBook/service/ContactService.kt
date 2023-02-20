package com.tsola2002.phoneBook.service

import com.tsola2002.phoneBook.dto.ContactDTO
import com.tsola2002.phoneBook.entity.Contact
import com.tsola2002.phoneBook.repository.ContactRepository
import mu.KLogging
import org.springframework.stereotype.Service

@Service
class ContactService(val contactRepository: ContactRepository) {

    // inject logging object to log insert method
    companion object: KLogging()

    fun addContact(contactDTO: ContactDTO){

        val contactEntity =  contactDTO.let {
            Contact(null, it.name, it.phoneNumber, it.address)
        }

        contactRepository.save(contactEntity)

        logger.info { "Saved contact is : $contactEntity" }

        contactEntity.let {
            ContactDTO(it.id, it.name, it.phoneNumber, it.address)
        }

    }

    fun retrieveAllContacts(): List<ContactDTO> {

        return contactRepository.findAll()
                .map {
                    ContactDTO(it.id, it.name, it.phoneNumber, it.address)
                }

    }


}