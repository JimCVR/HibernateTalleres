package actividadHibernate.modelo.sentencias

import actividadHibernate.modelo.GestorModelo
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.vista.Vista
import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityManager
import jakarta.persistence.NoResultException
import jakarta.persistence.Persistence
import java.sql.SQLException

private val vista: Vista = Vista()
var gestor: GestorModelo = GestorModelo.getInstance()
var connection : EntityManager = gestor.connect()

fun onSelectAllCliente():List<Cliente> {
        val listaClientes = connection.createQuery("FROM Cliente",Cliente::class.java).resultList as List<Cliente>
        listaClientes.forEach {
            println(it)
        }
        return listaClientes
}


fun onSelectId( id:String):Cliente{

        connection.transaction.begin()
        val cliente = connection.find(Cliente::class.java, id)
        println(cliente)
        connection.transaction.commit()
    return cliente
}


fun onInsert(cliente:Cliente) {
    try {
        connection.transaction.begin()
        connection.persist(cliente)
        connection.transaction.commit()

    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

    fun onUpdate(cliente:Cliente) {
        try {
            connection.transaction.begin()
            connection
            connection.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {

        }
    }

    fun onDelete(id: String) {
        try {
            connection.transaction.begin()
            val cliente: Cliente = connection.find(Cliente::class.java, id)
            connection.remove(cliente)
            connection.transaction.commit()
        } catch (s: SQLException) {
            connection.transaction.rollback()
        }
    }