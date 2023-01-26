package actividadHibernate.controlador

import actividadHibernate.modelo.GestorModelo
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import actividadHibernate.vista.Vista
import java.sql.SQLException

class AppController(var vista:Vista) {
    fun onStart(){
        vista.menuPrincipal()
    }

    fun onExit() {
        vista.salir()
    }

}