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
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/transfer")
class TransferController(private val repository: TransferRepository) {

    @PostMapping("/create")
    fun createTransfer(@RequestBody transfer: TransactionModel) {
        println( "Transfer created" )
        repository.save(transfer.convertToDBModel())
    }

    @GetMapping("/list")
    fun listTransfers(): List<OverviewTransactionModel> {
        val service = TransferService(repository)
        println( "Transfer listed" )
        return service.listTransfers()
    }
}