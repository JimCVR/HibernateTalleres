package actividadHibernate.vista

import actividadHibernate.controlador.AppController
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.modelo.sentencias.insertTaller
import actividadHibernate.modelo.sentencias.selectClienteByDNI
import actividadHibernate.modelo.sentencias.selectTallerByCIF
import java.util.*

class Vista{

    fun returnMainMenuOption(): Int{
        try {
            println("****Bienvenido****")
            println("****Introduzca una opcion****")
            println("1. Iniciar sesión (Cliente)")
            println("2. Iniciar sesión (Taller)")
            println("0. Salir")
            //Si se introduce algo que no sea un int saltara el mensaje de la excepcion y se vuelve a llamar al metodo
        } catch (e: InputMismatchException) {
            System.err.println(e.message)
            mainMenu()
        }
    }




}