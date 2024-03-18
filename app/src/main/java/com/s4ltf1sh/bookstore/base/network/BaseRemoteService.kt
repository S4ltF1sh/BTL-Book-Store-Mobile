package com.s4ltf1sh.bookstore.base.network

import com.s4ltf1sh.bookstore.common.constants.Strings
import retrofit2.Response

open class BaseRemoteService : BaseService() {
    companion object {
        const val DEFAULT_ERROR_RESPONSE_MESSAGE = "Response without body"
    }

    protected suspend fun <T : Any> callApi(call: suspend () -> Response<T>): NetworkResult<T> {
        val response: Response<T>
        try {
            response = call.invoke()
        } catch (t: Throwable) {
            return NetworkResult.Error(parseNetworkErrorException(t))
        }

        return if (response.isSuccessful) {
            if (response.body() == null) {
                NetworkResult.Error(
                    BaseNetworkException(
                        responseMessage = DEFAULT_ERROR_RESPONSE_MESSAGE,
                        responseCode = 200
                    )
                )
            } else {
                NetworkResult.Success(response.body()!!)
            }
        } else {
            val errorBody = response.errorBody()?.string() ?: Strings.EMPTY
            NetworkResult.Error(parseError(response.message(), response.code(), errorBody))
        }
    }

}