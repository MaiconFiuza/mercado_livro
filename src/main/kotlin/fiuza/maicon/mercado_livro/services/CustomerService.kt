package fiuza.maicon.mercado_livro.services

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import fiuza.maicon.mercado_livro.domain.dto.CustomerPatchDto
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService {

    private val customers = mutableListOf<Customer>()

    fun getAll(name: String?): List<Customer> {
        name?.let{
            var filteredCustomers = customers.filter { it.name.contains(name) }
            return filteredCustomers
        }

        return customers
    }

    fun find(id: String): Customer {
       return customers.filter { it -> it.id == id }.first()
    }

    fun create(customer: CustomerDto): Customer {
        val id = if (customers.isEmpty()) {
            "1"
        } else {
            customers.last().id.toInt() + 1
        }.toString()

        val newCustomer =  Customer(
            id = id,
            name = customer.name,
            email = customer.email
        )

        customers.add(newCustomer)
        return newCustomer
    }

    fun update(id: String, customer: CustomerDto) {
        customers.filter { it.id == id }.first().let {
            it.name = customer.name
            it.email= customer.email
        }
    }

    fun onlyUpdate(id: String, customer: CustomerPatchDto) {
        customers.filter { it.id == id}.first().let {
            it.name = customer.name
        }
    }

    fun delete(id: String) {
        customers.removeIf { it.id == id }
    }
}