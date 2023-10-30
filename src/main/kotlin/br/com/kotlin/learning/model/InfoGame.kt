package br.com.kotlin.learning.model

data class InfoGame(val info: InfoApiShark) {
    override fun toString(): String {
        return info.toString()
    }
}