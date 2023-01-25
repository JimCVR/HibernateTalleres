package colegio
import actividadHibernate.modelo.clases.Direccion
import jakarta.persistence.*



@Entity
@Table(name = "alumnos")
class Alumno(
    @Id
    @Column(name = "dni")
    var dni: String,

    @Column(name = "nombre")
    var nombre: String,

    @Column(name = "edad")
    var edad: Int,

    @Column(name = "ciudad")
    var ciudad: String,

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name= "id_direccion")
    var direccion: Direccion,

    @ManyToOne(cascade = [CascadeType.PERSIST])
    @JoinColumn(name="dni_tutor")
    var tutor: Tutor?=null,

    @ManyToMany(cascade = [CascadeType.ALL])
    @JoinTable(
        name = "alumn_asign",
        joinColumns = [JoinColumn(name = "dni_alumno")],
        inverseJoinColumns = [JoinColumn(name="id_asignatura")])
    var asignaturas: Set<Asignatura>?=null

) {
}