/*
File: OverviewTransactionModel
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.model

import java.util.*
data class OverviewTransactionModel(
    val id : String,
    val targetAccount: String,
    val amount: String,
    val description: String,
    val sender: String,
    val date: Date
)

fun TransactionDBModel.convertToOverviewTransactionModel() = OverviewTransactionModel(
        targetAccount = this.accountIdentifier,
        amount = this.amount.toString() + " " + this.currency,
        description = this.description,
        date = this.date,
        id = this.id.toString(),
        sender = "unknown"
    )