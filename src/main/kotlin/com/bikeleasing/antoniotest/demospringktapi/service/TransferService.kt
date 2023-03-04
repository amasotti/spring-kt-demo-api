/*
File: TransferService
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.service

import com.bikeleasing.antoniotest.demospringktapi.model.OverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.model.convertToOverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.repository.TransferRepository

class TransferService(private val repository: TransferRepository) {
    fun listTransfers(): List<OverviewTransactionModel> {
        val transactionDBCollection = repository.findAll()
        return transactionDBCollection.map { it.convertToOverviewTransactionModel() }
    }



}