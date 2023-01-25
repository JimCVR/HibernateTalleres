package actividadHibernate.modelo

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

class GestorModelo private constructor() {
    companion object {
        private var instance: GestorModelo? = null

        fun getInstance(): GestorModelo {

            if (instance == null) {
                instance = GestorModelo()
            }

            return instance!!
        }

    }

    @Volatile
    private var emf: EntityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaTaller")
    var manager: EntityManager ?= null
    fun connect(): EntityManager {
        if (manager == null || manager!!.isOpen) {
            manager = emf.createEntityManager()
            println("___/Conexion realizada correctamente")
        } else {
            println("___/Ya existe una conexion\\___")
        }
        return manager!!
    }

    fun disconect() {
        if (manager != null) {
            manager!!.close()
        }
    }
}