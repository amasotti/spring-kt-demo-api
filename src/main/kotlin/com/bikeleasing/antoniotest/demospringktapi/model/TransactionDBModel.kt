/*
File: TransactionDBModel
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/
package com.bikeleasing.antoniotest.demospringktapi.model


import jakarta.persistence.*
import java.util.*

@Entity
class TransactionDBModel(
    val accountIdentifier: String,
    val amount: Double,
    val currency: String,
    val description: String,
) {
    @Id
    @GeneratedValue()
    var id: UUID? = null
        private set

    var date: Date = Date()
}