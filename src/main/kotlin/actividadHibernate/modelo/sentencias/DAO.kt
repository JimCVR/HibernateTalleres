package actividadHibernate.modelo.sentencias

import actividadHibernate.modelo.GestorModelo
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Direccion
import actividadHibernate.modelo.clases.Pedido
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.vista.Vista
import jakarta.persistence.EntityExistsException
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import java.sql.SQLException

private val vista: Vista = Vista()
//private var emf: EntityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaTaller")
//var connection: EntityManager = emf.createEntityManager()

var gestor: GestorModelo = GestorModelo.getInstance()
var connection : EntityManager = gestor.connect()
//CLIENTES
fun onSelectAllCliente(): List<Cliente> {
    val listaClientes = connection.createQuery("FROM Cliente", Cliente::class.java).resultList as List<Cliente>
    listaClientes.forEach {
        println(it.nombre)
    }
    return listaClientes
}

fun onSelectIdCliente(dni: Long): Cliente {

    connection.transaction.begin()
    val cliente = connection.find(Cliente::class.java, dni)
    println(cliente.nombre)
    connection.transaction.commit()
    return cliente
}


fun onInsertCliente(cliente: Cliente) {
    try {
        connection.transaction.begin()
        connection.persist(cliente)
        connection.transaction.commit()

    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onUpdateCliente(cliente: Cliente) {
    try {
        connection.transaction.begin()
        val clientToUpdate: Cliente = connection.find(Cliente::class.java, cliente.dni)
        connection.merge(cliente)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onDeleteCliente(dni: Long) {
    try {
        connection.transaction.begin()
        val cliente: Cliente = connection.find(Cliente::class.java, dni)
        connection.remove(cliente)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

///DIRECCIONES
fun onSelectAllDireccion(): List<Direccion> {
    val listaDirecciones = connection.createQuery("FROM Direccion", Direccion::class.java).resultList as List<Direccion>
    listaDirecciones.forEach {
        println(it.calle)
    }
    return listaDirecciones
}


fun onSelectIdDireccion(id: Long): Direccion {

    connection.transaction.begin()
    val direccion = connection.find(Direccion::class.java, id)
    println(direccion.calle)
    connection.transaction.commit()
    return direccion
}


fun onInsertDireccion(direccion: Direccion) {
    try {
        connection.transaction.begin()
        connection.persist(direccion)
        connection.transaction.commit()

    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onUpdateDireccion(direccion: Direccion) {
    try {
        connection.transaction.begin()
        //val clientToUpdate:Direccion =  connection.find(Direccion::class.java, direccion.id)
        connection.merge(direccion)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onDeleteDireccion(id: Long) {
    try {
        connection.transaction.begin()
        val direccion: Direccion = connection.find(Direccion::class.java, id)
        connection.remove(direccion)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

//PEDIDO
fun onSelectAllPedido(): List<Pedido> {
    val listaPedidos = connection.createQuery("FROM Pedido", Pedido::class.java).resultList as List<Pedido>
    listaPedidos.forEach {
        println(it.descripcion)
    }
    return listaPedidos
}

fun onSelectAllPedidoCliente(cliente: Cliente): List<Pedido> {

    val listaPedidos =
        connection.createQuery(
            "FROM Pedido where cliente.dni = ${cliente.dni}",
            Pedido::class.java
        ).resultList as List<Pedido>
    listaPedidos.forEach {
        println(it.descripcion)
    }
    return listaPedidos
}

fun onSelectPedidosNoAsignados(): List<Pedido> {
    val listaPedidos =
        connection.createQuery(
            "FROM Pedido where taller is null",
            Pedido::class.java
        ).resultList as List<Pedido>
    listaPedidos.forEach {
        println(it.descripcion)
    }
    return listaPedidos
}

fun onSelectPedidosAsignados(): List<Pedido> {
    val listaPedidos =
        connection.createQuery(
            "FROM Pedido where taller.pedidos is not null",
            Pedido::class.java
        ).resultList as List<Pedido>
    listaPedidos.forEach {
        println(it.descripcion)
    }
    return listaPedidos
}

fun onSelectAllPedidoTaller(taller: Taller): List<Pedido> {
    val listaPedidos =
        connection.createQuery(
            "FROM Pedido where taller.cif = ${taller.cif}",
            Pedido::class.java
        ).resultList as List<Pedido>
    listaPedidos.forEach {
        println(it.cliente?.nombre)
    }
    return listaPedidos
}

fun onSelectIdPedido(id: Long): Pedido {
    connection.transaction.begin()
    val pedido = connection.find(Pedido::class.java, id)
    println(pedido.descripcion)
    connection.transaction.commit()
    return pedido
}


fun onInsertPedido(pedido: Pedido) {
    try {
        connection.transaction.begin()
        connection.persist(pedido)
        connection.transaction.commit()

    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onUpdatePedido(pedido: Pedido) {
    try {
        connection.transaction.begin()
        //val clientToUpdate:Cliente =  connection.find(Cliente::class.java, pedido.id)
        connection.merge(pedido)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onDeletePedido(id: Long) {
    try {
        connection.transaction.begin()
        val pedido: Pedido = connection.find(Pedido::class.java, id)
        connection.remove(pedido)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

//TALLERES
fun onSelectAllTaller(): List<Taller> {
    val listaClientes = connection.createQuery("FROM Taller", Taller::class.java).resultList as List<Taller>
    listaClientes.forEach {
        println(it)
    }
    return listaClientes
}


fun onSelectCifTaller(cif: Long): Taller {

    connection.transaction.begin()
    val taller = connection.find(Taller::class.java, cif)
    println(taller)
    connection.transaction.commit()
    return taller
}


fun onInsertTaller(taller: Taller) {
    connection.transaction.begin()
    try {
        connection.persist(taller)
        connection.transaction.commit()
    } catch (e: EntityExistsException) {
        connection.transaction.rollback()
    }
}

fun onUpdateTaller(taller: Taller) {
    try {
        connection.transaction.begin()
        //val clientToUpdate:Cliente =  connection.find(Cliente::class.java, taller.cif)
        connection.merge(taller)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onDeleteTaller(cif: String) {
    try {
        connection.transaction.begin()
        val taller: Taller = connection.find(Taller::class.java, cif)
        connection.remove(taller)
        connection.transaction.commit()
    } catch (s: SQLException) {
        connection.transaction.rollback()
    }
}

fun onSelectTalleresClientes(cliente: Cliente): List<Taller> {

    val listaTalleres =
        connection.createQuery(
            "FROM Taller where cliente.dni = ${cliente.dni}",
            Taller::class.java
        ).resultList as List<Taller>
    listaTalleres.forEach {
        println(it.nombre)
    }
    return listaTalleres

}