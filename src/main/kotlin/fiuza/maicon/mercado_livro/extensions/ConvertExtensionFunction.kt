package fiuza.maicon.mercado_livro.extensions

import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import fiuza.maicon.mercado_livro.domain.Customer

fun CustomerDto.toCustomerModel(): Customer {
    return Customer(name = this.name, email = this.email)
}