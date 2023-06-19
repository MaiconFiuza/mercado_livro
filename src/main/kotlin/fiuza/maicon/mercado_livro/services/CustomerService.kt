package fiuza.maicon.mercado_livro.services

import fiuza.maicon.mercado_livro.domain.Customer
import fiuza.maicon.mercado_livro.domain.dto.CustomerDto
import fiuza.maicon.mercado_livro.domain.dto.CustomerPatchDto
import fiuza.maicon.mercado_livro.repository.CustomerRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getAll(name: String?): List<Customer> {
        return customerRepository.findAll()
    }

    fun find(id: Int): Customer {
       return customerRepository.findById(id).orElseThrow()
    }

    fun create(customer: Customer): Customer {
        return customerRepository.save(customer)
    }

    fun update(id: Int, customer: Customer) {
        if (!customerRepository.existsById(id)) {
            throw Exception("Deu ruim na atualização do usuário")
        }
        customerRepository.save(customer)
    }

    //fun onlyUpdate(id: Int, customer: CustomerPatchDto) {
        //customers.filter { it.id == id}.first().let {
            //it.name = customer.name
            //      }
  //  }

    fun delete(id: Int) {
       if(!customerRepository.existsById(id)) {
           throw Exception();
       }
        customerRepository.deleteById(id)
    }
}