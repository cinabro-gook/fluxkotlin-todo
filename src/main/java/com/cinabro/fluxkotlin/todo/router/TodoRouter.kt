package com.cinabro.fluxkotlin.todo.router

import com.cinabro.fluxkotlin.todo.handler.TodoHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RequestPredicates
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.router

@Configuration
open class TodoRouter(private val handler: TodoHandler) {
    @Bean
    open fun routerFunction() = RouterFunctions.nest(
            RequestPredicates.path("/todos"),
            router {
                listOf(
                        GET("/", handler::getAll),
                        GET("/{id}", handler::getById),
                        POST("/", handler::save),
                        PUT("/{id}/done", handler::done),
                        DELETE("/{id}", handler::delete)
                )
            }
    )
}