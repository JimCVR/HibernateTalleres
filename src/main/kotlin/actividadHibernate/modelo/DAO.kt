package actividadHibernate.modelo

import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.vista.Vista
import jakarta.persistence.EntityManager
import java.sql.SQLException

class ClienteDAO() {
    private val vista: Vista = Vista()
    var gestor: GestorModelo = GestorModelo.getInstance()
    var connection : EntityManager = gestor.connect()


    fun onSelectAll() {
        try {
            val listaClientes = connection.createQuery("FROM Cliente",Cliente::class.java).resultList as List<Cliente>
            listaClientes.forEach {
                println(it)
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }

fun onSelectId(id:String){
        try {
            connection.transaction.begin()
            val record = connection.find(Cliente::class.java, id)
            println(record)
            connection.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }


    fun onInsert(cliente: Cliente) {
        try {
            connection.transaction.begin()
            connection.persist(cliente)
            connection.transaction.commit()
        } catch (s: SQLException) {
            connection.transaction.rollback()
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
        }
    }


    fun onUpdate(id:String){
        var nLineas:Int=0
        try {
            connection.transaction.begin()
            connection.persist(id)
            connection.transaction.commit()
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
}

class DireccionDAO {
    private val vista: Vista = Vista()
    var gestor: GestorModelo = GestorModelo.getInstance()
    var connection : EntityManager = gestor.connect()

    fun onSelectAll() {
        try {
            val listaClientes = connection.createQuery("FROM Cliente",Cliente::class.java).resultList as List<Cliente>
            listaClientes.forEach {
                println(it)
            }
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }


    fun onSelectId(myTable: Any, id:String){
        try {
            connection.transaction.begin()
            val record = connection.find(myTable::class.java, id)
            println(record)
            connection.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }


    fun onInsert(myTable:Any) {
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
        } catch (s: SQLException) {
            connection.transaction.rollback()
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
        }
    }


    fun onUpdate(myTable:Any, id:String){
        var nLineas:Int=0
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
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


}

class PedidoDAO {
    private val vista: Vista = Vista()
    var gestor: GestorModelo = GestorModelo.getInstance()
    var connection : EntityManager = gestor.connect()




    fun onSelectId(myTable: Any, id:String){
        try {
            connection.transaction.begin()
            val record = connection.find(myTable::class.java, id)
            println(record)
            connection.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }


    fun onInsert(myTable:Any) {
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
        } catch (s: SQLException) {
            connection.transaction.rollback()
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
        }
    }


    fun onUpdate(myTable:Any, id:String){
        var nLineas:Int=0
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
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


}

class TallerDAO {
    private val vista: Vista = Vista()
    var gestor: GestorModelo = GestorModelo.getInstance()
    var connection : EntityManager = gestor.connect()





    fun onSelectId(myTable: Any, id:String){
        try {
            connection.transaction.begin()
            val record = connection.find(myTable::class.java, id)
            println(record)
            connection.transaction.commit()
        } catch (s: SQLException) {
            s.printStackTrace()
        } finally {
        }
    }


    fun onInsert(myTable:Any) {
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
        } catch (s: SQLException) {
            connection.transaction.rollback()
            s.printStackTrace()
        } finally {
            vista.insertRealizado()
        }
    }


    fun onUpdate(myTable:Any, id:String){
        var nLineas:Int=0
        try {
            connection.transaction.begin()
            connection.persist(myTable)
            connection.transaction.commit()
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


}