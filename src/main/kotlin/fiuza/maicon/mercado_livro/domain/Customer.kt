package fiuza.maicon.mercado_livro.domain

import org.springframework.data.annotation.Id

data class Customer(
    @Id
    val id: String,
    val name: String,
    val email: String
)
