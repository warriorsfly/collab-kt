package com.winning

import com.fasterxml.jackson.databind.SerializationFeature
import com.winning.com.winning.schema.Applica
import com.winning.com.winning.schema.Applicas
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.auth.Authentication
import io.ktor.features.*
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.cio.websocket.Frame
import io.ktor.http.cio.websocket.pingPeriod
import io.ktor.http.cio.websocket.readText
import io.ktor.http.cio.websocket.timeout
import io.ktor.http.content.resources
import io.ktor.http.content.static
import io.ktor.jackson.jackson
import io.ktor.response.respond
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.websocket.WebSockets
import io.ktor.websocket.webSocket
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.Duration

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    Database.connect(
        url = "jdbc:sqlserver://172.17.17.93;DatabaseName = TFS_PT_STORE",
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver",
        user = "sa",
        password = "root"
    )
    transaction {
        addLogger(StdOutSqlLogger)
        SchemaUtils.create(Applicas)
    }

    install(Compression) {
        gzip {
            priority = 1.0
        }
        deflate {
            priority = 10.0
            minimumSize(1024) // condition
        }
    }

    install(AutoHeadResponse)

    install(ConditionalHeaders)

    install(CORS) {
        method(HttpMethod.Options)
        method(HttpMethod.Put)
        method(HttpMethod.Delete)
        method(HttpMethod.Patch)
        header(HttpHeaders.Authorization)
        header("Allen Walker")
        allowCredentials = true
        if(testing) {
            anyHost()
        }
    }

    install(DataConversion)

    install(WebSockets) {
        pingPeriod = Duration.ofSeconds(15)
        timeout = Duration.ofSeconds(15)
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    install(Authentication) {
    }

    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.INDENT_OUTPUT)
        }
    }

//    val client = HttpClient() {
//    }

    routing {
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }

        // Static feature. Try to access `/static/ktor_logo.svg`
        static("/static") {
            resources("static")
        }

        webSocket("/ws/echo") {
            send(Frame.Text("Hi from server"))
            while (true) {
                val frame = incoming.receive()
                if (frame is Frame.Text) {
                    send(Frame.Text("Client said: " + frame.readText()))
                }
            }
        }

        get("/json/jackson") {
            call.respond(mapOf("hello" to "world"))
        }

        get("/applications"){

            var apps = transaction {
                Applicas.selectAll()
                    .map {
                        Applica(
                            it[Applicas.id],
                            it[Applicas.name],
                            it[Applicas.type],
                            it[Applicas.mode],
                            it[Applicas.url],
                            it[Applicas.sql],
                            it[Applicas.dyrc],
                            it[Applicas.timeout],
                            it[Applicas.sjfhmb],
                            it[Applicas.execution],
                            it[Applicas.djbb],
                            it[Applicas.jlzt],
                            it[Applicas.urlfun],
                            it[Applicas.dyrcfun],
                            it[Applicas.xxsx]
                        )
                    }
                    .toList()
            }
            call.respond(apps)
        }
    }
}

