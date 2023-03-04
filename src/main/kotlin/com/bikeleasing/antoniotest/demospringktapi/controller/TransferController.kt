/*
File: TransferController
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.controller

import com.bikeleasing.antoniotest.demospringktapi.model.OverviewTransactionModel
import com.bikeleasing.antoniotest.demospringktapi.model.TransactionModel
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/transfer")
class TransferController {

    @PostMapping("/create")
    fun createTransfer(@RequestBody transfer: TransactionModel) {
        println( "Transfer created" )
        TODO("Not yet implemented")
    }

    @GetMapping("/list")
    fun listTransfers(): List<OverviewTransactionModel> {
        println( "Transfers listed" )
        return listOf()
    }
}