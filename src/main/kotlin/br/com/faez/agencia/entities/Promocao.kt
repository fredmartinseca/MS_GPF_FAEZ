package br.com.faez.agencia.entities

data class Promocao(
    val id: Long,
    val descricao: String,
    val local: String,
    val isAllInclusive: Boolean,
    val preco: Double
)