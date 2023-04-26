package fiuza.maicon.mercado_livro.domain.dto

data class CustomerDto(
    val name: String,
    val email: String
)

data class CustomerPatchDto(
    val name: String
)