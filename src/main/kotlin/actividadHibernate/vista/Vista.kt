package actividadHibernate.vista

import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.modelo.sentencias.selectClienteByDNI
import actividadHibernate.modelo.sentencias.selectTallerByCIF
import java.util.*

class Vista {
    fun loginCliente(dni: String?, password: String?): Cliente? {
        if (dni != null) {
            var cliente= selectClienteByDNI(dni)
            if (cliente?.contraseña.equals(password)&&cliente?.dni.equals(dni)){
                return cliente
            }
        }
        return null
    }

    fun loginTaller(cif: String?, password: String?):Taller? {
        if (cif != null) {
            var taller= selectTallerByCIF(cif)
            if (taller?.contraseña.equals(password)&&taller?.cif.equals(cif)){
                return taller
            }
        }
        return null
    }

    fun mainMenu() {
        try {
            println("****Bienvenido****")
            println("****Introduzca una opcion****")
            println("1. Iniciar sesión (Cliente)")
            println("2. Iniciar sesión (Taller)")
            println("0. Salir")
            var option = readln().toInt()

            when (option) {
                1 -> {
                    println("Introduzca un dni")
                    var dni= readln()
                    println("Introduzca la contraseña")
                    var password= readln()
                    loginCliente(dni, password)?.let { sessionMenuCliente(it) }
                }

                2 -> {
                    println("Introduzca un cif")
                    var cif= readln()
                    println("Introduzca la contraseña")
                    var password= readln()
                    loginTaller(cif, password)?.let { sessionMenuTaller(it) }
                }

                0 -> {
                    println("Saliendo...")
                    System.exit(200)
                }
            }
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            mainMenu()
        }
    }


    //Creación del menú del cliente donde podemos realizar las diferentes funcionalidades del programa
    fun sessionMenuCliente(currentClient: Cliente) {
        var currentClient: Cliente = currentClient
        var option = 1
        try {
            while (option != 0) {
                println("1. Dar de alta a un cliente")
                println("2. Realizar un pedido")
                println("3. Ver pedidos realizados")
                println("4. Ver talleres asociados")
                println("0. Atrás")
                println("Escribe una de las opciones:")
                option = readln().toInt()
                when (option) {
                    1 ->
                    2 ->
                    3 ->
                    4 ->

                    0 -> mainMenu()
                    else -> println("Opción no existente")
                }
            }
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            sessionMenuCliente(currentClient)
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
                    1 ->
                    2 ->
                    3 ->
                    4 ->

                    0 -> mainMenu()
                    else -> println("Opción no existente")
                }
            }
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            sessionMenuTaller(currentTalleres)
        }
    }
}