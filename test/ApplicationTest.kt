package com.winning

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.server.testing.*
//import kotlinx.coroutines.io.*
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
//    @Test
//    fun testRoot() {
//        withTestApplication({ module(testing = true) }) {
//            handleRequest(HttpMethod.Get, "/").apply {
//                assertEquals(HttpStatusCode.OK, response.status())
//                assertEquals("HELLO WORLD!", response.content)
//            }
//        }
//    }
//
//    @Test
//    fun testClientMock() {
//        runBlocking {
//            val client = HttpClient(MockEngine) {
//                engine {
//                    addHandler { request ->
//                        when (request.url.fullPath) {
//                            "/" -> respond(
//                                ByteReadChannel(byteArrayOf(1, 2, 3)),
//                                headers = headersOf("X-MyHeader", "MyValue")
//                            )
//                            else -> respond("Not Found ${request.url.encodedPath}", HttpStatusCode.NotFound)
//                        }
//                    }
//                }
//                expectSuccess = false
//            }
//            assertEquals(byteArrayOf(1, 2, 3).toList(), client.get<ByteArray>("/").toList())
//            assertEquals("MyValue", client.call("/").response.headers["X-MyHeader"])
//            assertEquals("Not Found other/path", client.get<String>("/other/path"))
//        }
//    }
}
