package fiuza.maicon.mercado_livro.domain

import jakarta.persistence.*

@Entity(name = "customer")
data class Customer(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null,

    @Column
    var name: String,

    @Column
    var email: String
)
