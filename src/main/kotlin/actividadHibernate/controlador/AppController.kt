package actividadHibernate.controlador

import actividadHibernate.main
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
                4 -> viewWorkshopsAssociated(currentClient)
                5 -> mainMenu()

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
                5 -> mainMenu()
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


    fun loginCliente(dni: Long?, password: String?): Cliente? {
        if (dni != null) {
            var cliente = onSelectIdCliente(dni)
            if (cliente?.contraseña.equals(password) && cliente?.dni == dni) {
                cliente.toString()
                return cliente
            }
        }
        mainMenu()
        return null
    }

    fun loginTaller(cif: Long?, password: String?): Taller? {
        if (cif != null) {
            var taller = onSelectCifTaller(cif)
            if (taller?.contraseña.equals(password) && taller?.cif == cif) {
                return taller
            }
        }
        mainMenu()
        return null
    }

    fun newOrder(customer: Cliente) {
        var newOrder = Pedido(cliente = customer,descripcion = vista.returnDescription())

        try {
            onInsertPedido(newOrder)
            sessionMenuCliente(customer)
        } catch (e: SQLException) {
            vista.error()
            sessionMenuCliente(customer)
        }

    }

    fun viewAllCustomerOrders(customer: Cliente) {
        try {
            onSelectAllPedidoCliente(customer)
            sessionMenuCliente(customer)
        } catch (e: SQLException) {
            vista.error()
            sessionMenuCliente(customer)
        }
    }

    fun viewAllWorkshopsOrders(workshop: Taller) {
        try {
            onSelectAllPedidoTaller(workshop)
            sessionMenuTaller(workshop)
        } catch (e: SQLException) {
            vista.error()
            sessionMenuTaller(workshop)
        }
    }

    fun viewWorkshopsAssociated(customer: Cliente) {
        try {
            onSelectTalleresClientes(customer)
            sessionMenuCliente(customer)
        } catch (e: SQLException) {
            vista.error()
            sessionMenuCliente(customer)
        }
    }

    fun viewClientsAssociated(workshop: Taller) {
        try {
            onSelectAllPedidoTaller(workshop)
            sessionMenuTaller(workshop)
        } catch (e: SQLException) {
            vista.error()
            sessionMenuTaller(workshop)
        }
    }

    fun viewNoOrdersAssociated() {
        try {
            onSelectPedidosNoAsignados()
            mainMenu()
        } catch (e: SQLException) {
            vista.error()
            mainMenu()
        }

    }

}



