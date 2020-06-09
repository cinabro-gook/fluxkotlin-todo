package com.cinabro.fluxkotlin.todo.domain

import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository : JpaRepository<Todo, Long> {

}