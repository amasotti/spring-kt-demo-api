package com.bikeleasing.antoniotest.demospringktapi.controller

import com.bikeleasing.antoniotest.demospringktapi.model.TransactionDBModel
import com.bikeleasing.antoniotest.demospringktapi.model.TransactionModel
import com.bikeleasing.antoniotest.demospringktapi.repository.TransferRepository
import com.bikeleasing.antoniotest.demospringktapi.service.TransferService
import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest
class TransferControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var transferRepository: TransferRepository

    @MockkBean
    private lateinit var transferService: TransferService


    @Test
    fun `should return 200 when get all transfers`() {
        val transaction = TransactionModel(
            targetAccount = "DE123456789",
            sender = "DE123456789",
            amount = 100.0,
            currency = "EUR",
            description = "Test"
        )

        every { transferRepository.save(any()) } returns mockk()
        every { transferRepository.findAll() } returns listOf(mockk())
        every { transferService.getOneTransferByDescription(any()) } returns mockk()

        val result = mockMvc.perform(
            post("/api/v1/transfer/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ObjectMapper().writeValueAsString(transaction))
                .accept(MediaType.APPLICATION_JSON)
        ).andDo(print())

        result.andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.status").value("CREATED"))
            .andExpect(jsonPath("\$.message").value("Transfer created"))
            .andExpect(jsonPath("\$.data").isNotEmpty)
        println("Result: ${result.andReturn().response.contentAsString}")
    }

        @Test
        fun `should return a bad request error if the request there's no body`() {
            mockMvc.perform(
                post("/api/v1/transfer/create")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON)
            )
                .andDo(print())
                .andExpect(status().is4xxClientError)
        }
    }