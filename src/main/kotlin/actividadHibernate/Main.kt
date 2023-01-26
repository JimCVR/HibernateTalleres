package actividadHibernate
import actividadHibernate.controlador.AppController
import actividadHibernate.modelo.ClienteDAO
import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Direccion
import actividadHibernate.modelo.clases.Pedido
import actividadHibernate.modelo.clases.Taller
import actividadHibernate.vista.Vista
import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

fun main() {
    //abrimos sesion
    /*val emf: EntityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaTaller")
    val manager: EntityManager = emf.createEntityManager()
    //CREAMOS DATOS


    var direccion1: Direccion =  Direccion("calle menor",22,"11100")
    var cliente1: Cliente = Cliente("Jaime", "jaime@gmail.com",direccion1)
    var taller1: Taller = Taller("1234534141","Taller San Francisco", Direccion("Turuleta",5,"11300"))
    var pedido1 : Pedido = Pedido(taller1,cliente1,"descripcion 1")

    cliente.talleres = mutableSetOf<Taller>()
    cliente.talleres!!.add(taller)
    cliente1.talleres = mutableSetOf()
    cliente1.talleres!!.add(taller1)
    //Iniciamos una transacción e insertamos

    manager.persist(direccion)
    manager.persist(cliente)
    manager.persist(taller)
    manager.persist(pedido)
    manager.persist(direccion1)
    manager.persist(cliente1)
    manager.persist(taller1)
    manager.persist(pedido1)
    manager.transaction.commit()
    //cerramos la sesion
    manager.close()*/

    var dao : ClienteDAO = ClienteDAO()
    var direccion: Direccion =  Direccion("calle mayor",26,"11100")
    var cliente: Cliente = Cliente("Atama", "atama@hotmail.com",direccion)
    var taller: Taller = Taller("12141","Taller San Vicente", Direccion("Bartolome",14,"11100"))
    var pedido : Pedido = Pedido(taller,cliente,"descripcion")

    var direccion1: Direccion =  Direccion("calle menor",22,"11100")
    var cliente1: Cliente = Cliente("Jaime", "jaime@gmail.com",direccion1)
    var taller1: Taller = Taller("1234534141","Taller San Francisco", Direccion("Turuleta",5,"11300"))
    var pedido1 : Pedido = Pedido(taller1,cliente1,"descripcion 1")
    dao.onInsert(cliente)
    dao.onInsert(cliente1)


    dao.onSelectAll()
}
