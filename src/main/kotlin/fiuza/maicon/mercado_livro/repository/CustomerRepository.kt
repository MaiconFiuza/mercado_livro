package fiuza.maicon.mercado_livro.repository

import fiuza.maicon.mercado_livro.domain.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Int> {
        fun findByNameContaining(name: String): List<Customer>

        fun findByNameStartsWith(name: String): List<Customer>
}