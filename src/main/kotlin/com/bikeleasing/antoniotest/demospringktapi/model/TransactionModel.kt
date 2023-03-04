/*
File: TransactionModel
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.model

import java.util.*

data class TransactionModel(
    val targetAccount: String,
    val amount: Double,
    val currency: String,
    val sender: String,
    val description: String,
    ) {
    var date: Date = Date()
}

fun TransactionModel.convertToDBModel() = TransactionDBModel(
        accountIdentifier = this.targetAccount,
        amount = this.amount,
        currency = this.currency,
        description = this.description
    )