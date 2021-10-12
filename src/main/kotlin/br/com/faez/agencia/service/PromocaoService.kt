package br.com.faez.agencia.service

import org.springframework.stereotype.Service

interface PromocaoService {

    fun getByid(id: Long)

    fun getAll()
}