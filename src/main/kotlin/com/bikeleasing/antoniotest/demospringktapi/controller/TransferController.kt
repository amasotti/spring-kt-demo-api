/*
File: TransferController
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 04.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/transfer")
class TransferController {

    @PostMapping("/create")
    fun createTransfer() {
        println( "Transfer created" )
    }

    @GetMapping("/list")
    fun listTransfers() {
        println( "Transfers listed" )
    }
}