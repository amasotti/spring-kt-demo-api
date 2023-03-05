/*
File: TransferService
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.service

import com.bikeleasing.antoniotest.demospringktapi.model.OverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.model.convertToOverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.repository.TransferRepository
import java.util.*

class TransferService(private val repository: TransferRepository) {
    fun listTransfers(): List<OverviewTransactionModel> {
        val transactionDBCollection = repository.findAll()
        return transactionDBCollection.map { it.convertToOverviewTransactionModel() }
    }

    fun getOneTransfer(id: UUID?): OverviewTransactionModel {

        if (id == null) {
            throw Exception("ID is null")
        }

        val transactionDB = repository.findById(id)
        return transactionDB.get().convertToOverviewTransactionModel()
    }

    fun getOneTransferByDescription(description: String?): OverviewTransactionModel {

        if (description == null) {
            throw Exception("Description is null")
        }

        val transactionDB = repository.findAll().filter { it.description == description }
        return transactionDB[0].convertToOverviewTransactionModel()
    }



}