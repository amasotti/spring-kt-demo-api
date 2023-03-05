/*
File: BaseReponse
Author: Antonio Masotti <masotti@bikeleasing.de>
Date: 05.03.23
*/

package com.bikeleasing.antoniotest.demospringktapi.utils

import org.springframework.http.HttpStatus

open class BaseReponse<T>(val status: HttpStatus, val message: String, val data: T? = null) {

    class CreateTransferResponse<T>(message: String, data: T? = null) :
        BaseReponse<T>(HttpStatus.CREATED, message, data)

    class ListTransferResponse<T>(message: String, data: T? = null) :
        BaseReponse<T>(HttpStatus.OK, message, data)

}