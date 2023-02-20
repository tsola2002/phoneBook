package com.tsola2002.phoneBook.repository

import com.tsola2002.phoneBook.entity.Contact
import org.springframework.data.repository.CrudRepository

interface ContactRepository : CrudRepository<Contact, Int> {
}