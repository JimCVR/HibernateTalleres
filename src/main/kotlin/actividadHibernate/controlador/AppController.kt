package actividadHibernate.controlador

import actividadHibernate.modelo.GestorModelo
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import actividadHibernate.vista.Vista
import java.sql.SQLException

class AppController() {

    private val vista: Vista = Vista()
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
}