package com.tsola2002.phoneBook.entity

import javax.persistence.*

@Entity
@Table(name = "Contacts")
data class Contact (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int?,
    var name: String,
    var phoneNumber: Int,
    var address: String
)