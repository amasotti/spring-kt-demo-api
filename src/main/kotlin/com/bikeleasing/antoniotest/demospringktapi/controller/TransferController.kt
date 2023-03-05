/*
File: TransferController
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.controller

import com.bikeleasing.antoniotest.demospringktapi.model.OverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.model.TransactionModel
import com.bikeleasing.antoniotest.demospringktapi.model.convertToDBModel
import com.bikeleasing.antoniotest.demospringktapi.repository.TransferRepository
import com.bikeleasing.antoniotest.demospringktapi.service.TransferService
import com.bikeleasing.antoniotest.demospringktapi.utils.BaseReponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/transfer")
class TransferController(private val repository: TransferRepository) {

    val service = TransferService(repository)

    @PostMapping("/create")
    fun createTransfer(@RequestBody transfer: TransactionModel): BaseReponse<Any> {
        println( "Transfer created" )
        try {
            val payload = transfer.convertToDBModel()
            repository.save(payload)
            return BaseReponse.CreateTransferResponse("Transfer created", payload)
        } catch (e: Exception) {
            error(e.message ?: "Error while creating transfer")
        }
    }

    @GetMapping("/list")
    fun listTransfers(): List<OverviewTransactionModel> {
        val service = TransferService(repository)
        println( "Transfer listed" )
        return service.listTransfers()
    }
}