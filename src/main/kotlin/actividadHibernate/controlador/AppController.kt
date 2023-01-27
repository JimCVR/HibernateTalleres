package actividadHibernate.controlador

import actividadHibernate.modelo.GestorModelo
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Direccion
import actividadHibernate.modelo.clases.Pedido
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.modelo.sentencias.*
import actividadHibernate.vista.Vista
import java.sql.SQLException

class AppController(vista: Vista) {
    private var vista = Vista()
    private var connection = GestorModelo.getInstance()

    fun onSelectId(myTable: Any, id: String) {
        try {
            connection.manager!!.transaction.begin()
            val record = connection.manager!!.find(myTable::class.java, id)
            println(record)
            connection.manager!!.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }

    fun mainMenu() {
        var option = vista.returnMainMenuOption()
        while (option != 0)
            when (option) {

                1 -> loginCliente(vista.returnDni(), vista.returnPassword())?.let { sessionMenuCliente(it) }
                2 -> loginTaller(vista.returnDni(), vista.returnPassword())?.let { sessionMenuTaller(it) }
                3 -> registerNewCustomer()
                4 -> registerNewWorkshop()

                0 -> vista.exitApp()

                else -> vista.invalidOption()
            }

    }

    //Creación del menú del cliente donde podemos realizar las diferentes funcionalidades del programa
    fun sessionMenuCliente(currentClient: Cliente) {
        var option = vista.returnCustomerMenuOption()
        while (option != 0)
            when (option) {

                1 -> registerNewCustomer()
                2 -> newOrder(currentClient)
                3 -> viewAllCustomerOrders(currentClient)
                4 -> viewOrdersAssociated(currentClient)
                0 -> vista.exitApp()

                else -> vista.invalidOption()
            }
    }

    //Creación del menú del taller donde podemos realizar las diferentes funcionalidades del programa
    fun sessionMenuTaller(currentWorkshop: Taller) {
        var option = vista.returnWorkshopMenuOption()

        while (option != 0) {
            when (option) {
                1 -> registerNewWorkshop()
                2 -> viewNoOrdersAssociated()
                3 -> viewAllWorkshopsOrders(currentWorkshop)
                4 -> viewClientsAssociated(currentWorkshop)
                0 -> vista.returnMainMenuOption()
                else -> vista.invalidOption()
            }
        }
    }

    fun crearDireccion(): Direccion {
        var direccion: Direccion = Direccion(vista.returnStreet(), vista.returnNumber(), vista.returnPostalCode())
        return direccion
    }

    //Este metodo no tiene sentido llamarlo en el menu de talleres, ya que para acceder previamente al menu hay que tener un taller creado
    fun registerNewWorkshop() {
        var taller: Taller = Taller(vista.returnCif(), vista.returnPassword(), vista.returnName(), crearDireccion())
        onInsertTaller(taller)
        mainMenu()
    }

    fun registerNewCustomer() {
        var customer: Cliente =
            Cliente(vista.returnName(), vista.returnPassword(), vista.returnEmail(), crearDireccion())
        onInsertCliente(customer)
        mainMenu()
    }


    fun loginCliente(dni: String?, password: String?): Cliente? {
        if (dni != null) {
            var cliente = onSelectIdCliente(dni)
            if (cliente?.contraseña.equals(password) && cliente?.dni.equals(dni)) {
                return cliente
            }
        }
        mainMenu()
        return null
    }

    fun loginTaller(cif: String?, password: String?): Taller? {
        if (cif != null) {
            var taller = onSelectCifTaller(cif)
            if (taller?.contraseña.equals(password) && taller?.cif.equals(cif)) {
                return taller
            }
        }
        return null
    }

    fun newOrder(customer: Cliente) {
        var newOrder = Pedido(descripcion = vista.returnDescription(), cliente = customer)
        onInsertPedido(newOrder)
        sessionMenuCliente(customer)
    }

    fun viewAllCustomerOrders(customer: Cliente) {
        onSelectAllPedidoCliente(customer)
        sessionMenuCliente(customer)
    }

    fun viewAllWorkshopsOrders(workshop: Taller) {
        onSelectAllPedidoTaller(workshop)
        sessionMenuTaller(workshop)
    }

    fun viewOrdersAssociated(customer: Cliente) {
        onSelectAllPedidoCliente(customer)
        sessionMenuCliente(customer)
    }

    fun viewClientsAssociated(workshop: Taller) {
        onSelectAllPedidoTaller(workshop)
        sessionMenuTaller(workshop)
    }

    fun viewNoOrdersAssociated() {
        onSelectPedidosNoAsignados()
    }

}

