package actividadHibernate.modelo.sentencias

import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Taller
import jakarta.persistence.NoResultException
import jakarta.persistence.Persistence

private val entityManagerFactory = Persistence.createEntityManagerFactory("PersistenciaTaller")
private val entityManager = entityManagerFactory.createEntityManager()
private val transaction = entityManager.transaction

fun selectClienteByDNI(dni: String): Cliente? {
    val clienteQuery = entityManager.createQuery("from Cliente where dni = :id", Cliente::class.java)
    clienteQuery.setParameter("id", dni)
    return try {
        clienteQuery.singleResult
    } catch (e: NoResultException) {
        return null
    }
}

fun selectTallerByCIF(cif: String): Taller? {
    val tallerQuery = entityManager.createQuery("from Taller where id = :id", Taller::class.java)
    tallerQuery.setParameter("id", cif)
    return try {
        tallerQuery.singleResult
    } catch (e: NoResultException) {
        return null
    }
}

