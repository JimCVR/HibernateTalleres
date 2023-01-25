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


    fun onInsert(myTable:Any) {
        try {
            connection.manager!!.transaction.begin()
            connection.manager!!.persist(myTable)
            connection.manager!!.transaction.commit()
        } catch (s: SQLException) {
            connection.manager!!.transaction.rollback()
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
        }
    }


    fun onUpdate(myTable:Any, id:String){
        var nLineas:Int=0
        try {
            connection.manager!!.transaction.begin()
            connection.manager!!.persist(myTable)
            connection.manager!!.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.updateRealizado(nLineas)
        }
    }


    fun onDelete(id:String){
        var nLineas:Int=0

        try {

        } catch (s: SQLException) {
            s.printStackTrace()
        }finally {
            vista.deleteRealizado(nLineas)
        }
    }


    fun onStart(){
        connection.connect()
        vista.menuPrincipal()
    }

    fun onExit() {
        connection.disconect()
        vista.salir()
    }

}