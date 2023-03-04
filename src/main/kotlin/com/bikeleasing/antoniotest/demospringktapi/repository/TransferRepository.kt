package com.bikeleasing.antoniotest.demospringktapi.repository


import java.util.*
import com.bikeleasing.antoniotest.demospringktapi.model.TransactionDBModel
import org.springframework.data.repository.CrudRepository

interface TransferRepository: CrudRepository<TransactionDBModel, UUID>