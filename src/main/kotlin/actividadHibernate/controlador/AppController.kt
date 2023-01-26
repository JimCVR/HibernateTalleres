package actividadHibernate.controlador

import actividadHibernate.modelo.GestorModelo
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Direccion
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.modelo.sentencias.insertTaller
import actividadHibernate.modelo.sentencias.selectClienteByDNI
import actividadHibernate.modelo.sentencias.selectTallerByCIF
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import actividadHibernate.vista.Vista
import java.sql.SQLException

class AppController(vista: Vista) {
    private var vista = Vista()
    private var connection = GestorModelo.getInstance()
    fun onSelectId(myTable: Any, id:String){
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

    //Creación del menú del cliente donde podemos realizar las diferentes funcionalidades del programa
    fun sessionMenuCliente(currentClient: Cliente) {
        var currentClient: Cliente = currentClient
        var option = vista.returnCustomerMenuOption(currentClient)
        when (option) {
            1 ->
                2

            ->
                3

            ->
                4

            ->

                0

            -> vista.returnMainMenuOption()
            else -> println("Opción no existente")
        }
    }

    //Creación del menú del taller donde podemos realizar las diferentes funcionalidades del programa
    fun sessionMenuTaller(currentTalleres: Taller) {
        var currentTalleres: Taller = currentTalleres
        var option = readln().toInt()
        try {
            while (option != 0) {
                println("1. Dar de alta a un taller")
                println("2. Consultar pedidos existentes")
                println("3. Ver pedidos asociados")
                println("4. Ver clientes asociados")
                println("0. Atrás")
                println("Escribe una de las opciones:")
                when (option) {
                    1 -> altaTaller(currentTalleres)
                    2 ->
                        3

                    ->
                        4

                    ->

                        0

                    -> vista.returnMainMenuOption()
                    else -> println("Opción no existente")
                }
            }
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            sessionMenuTaller(currentTalleres)
        }
    }


    fun loginCliente(dni: String?, password: String?): Cliente? {
        if (dni != null) {
            var cliente = selectClienteByDNI(dni)
            if (cliente?.contraseña.equals(password) && cliente?.dni.equals(dni)) {
                return cliente
            }
        }
        return null
    }

    fun loginTaller(cif: String?, password: String?): Taller? {
        if (cif != null) {
            var taller = selectTallerByCIF(cif)
            if (taller?.contraseña.equals(password) && taller?.cif.equals(cif)) {
                return taller
            }
        }
        return null
    }

    fun resultMainMenu() {
        var option = vista.returnMainMenuOption()
        when (option) {
            1 -> {
                println("Introduzca un dni")
                var dni = readln()
                println("Introduzca la contraseña")
                var password = readln()
                loginCliente(dni, password)?.let { sessionMenuCliente(it) }
            }

            2 -> {
                println("Introduzca un cif")
                var cif = readln()
                println("Introduzca la contraseña")
                var password = readln()
                loginTaller(cif, password)?.let { sessionMenuTaller(it) }
            }

            0 -> {
                println("Saliendo...")
                System.exit(200)
            }
        }

        fun crearDireccion(): Direccion {
            println("Introduzca una calle:")
            var calle = readln()
            println("Introduzca un número:")
            var numero = readln().toInt()
            println("Introduzca un código postal:")
            var cp = readln()
            var direccion: Direccion = Direccion(calle, numero, cp)
            return direccion
        }

        fun altaTaller(currentTalleres: Taller) {
            println("Introduzca un cif:")
            var cif = readln()
            println("Introduzca una contraseña:")
            var contraseña = readln()
            println("Introduzca un nombre:")
            var nombre = readln()
            var direccion = crearDireccion()
            var taller: Taller = Taller(cif, contraseña, nombre, direccion)
            insertTaller(taller)
            if (insertTaller(taller) == true) {
                println("El taller se ha dado de alta correctamente")
            } else {
                println("El taller no se ha podido dar de alta correctamente")
            }
        }


    }
}