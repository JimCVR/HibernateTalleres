package actividadHibernate.vista

import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Taller
import java.util.*


class Vista {

    fun returnMainMenuOption(): Int {
        try {
            println("****Bienvenido****")
            println("****Introduzca una opcion****")
            println("1. Iniciar sesión (Cliente)")
            println("2. Iniciar sesión (Taller)")
            println("3. Dar de alta a un cliente")
            println("4. Dar de alta a un taller")

            println("0. Salir")
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            returnMainMenuOption()
        }
        return readln().toInt()
    }

    fun returnWorkshopMenuOption(): Int {
        try {
            println("Escribe una de las opciones:")
            println("1. Dar de alta a un taller")
            println("2. Consultar pedidos existentes")
            println("3. Ver pedidos asociados")
            println("4. Ver clientes asociados")
            println("5. Atrás")

        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            returnWorkshopMenuOption()
        }
        return readln().toInt()
    }

    fun returnCustomerMenuOption(): Int {
        try {
            println("Escribe una de las opciones:")
            println("1. Dar de alta a un cliente")
            println("2. Realizar un pedido")
            println("3. Ver pedidos realizados")
            println("4. Ver talleres asociados")
            println("5. Atrás")
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            returnCustomerMenuOption()
        }
        return readln().toInt()
    }

    fun returnDni(): Long {
        println("Introduzca su dni:")
        return readln().toLong()
    }

    fun returnName () : String{
        println("Introduzca el nombre:")
        return readln()
    }

    fun returnEmail () : String{
        println("Introduzca el email:")
        return readln()
    }
    fun returnStreet() : String{
        println("Introduzca la calle:")
        return readln()
    }

    fun returnNumber() : Int{
        println("Introduzca el numero:")
        return readln().toInt()
    }

    fun returnPostalCode() : String{
        println("Introduzca el codigo postal:")
        return readln()
    }
    fun returnCif(): Long {
        println("Introduzca el cif:")
        return readln().toLong()
    }
    fun returnPassword(): String {
        println("Introduzca su contraseña:")
        return readln()
    }

    fun invalidOption(){
        println("Opción no existente")
    }

    fun error(){
        println("Ha ocurrido un error inesperado.Prueba de nuevo")
    }
    fun exitApp() {
        println("Saliendo...")
    }




    fun returnDescription(): String {
        println("Introduzca su descripcion:")
        return readln()
    }
}



