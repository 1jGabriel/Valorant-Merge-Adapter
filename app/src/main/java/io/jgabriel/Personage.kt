package io.jgabriel

data class Personage(
    val id: Int = 0,
    val name: String = "",
    val avatar: String = "",
    val description: String = "",
    val spells: List<Spell> = emptyList()
)