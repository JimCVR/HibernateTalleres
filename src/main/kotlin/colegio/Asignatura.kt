package colegio
import jakarta.persistence.*

@Entity
@Table(name= "asignaturas")
class Asignatura(

    @Id
    @Column(name = "id")
    var id: Int,

    @Column(name = "titulo")
    var titulo: String,

    @ManyToMany(mappedBy = "asignaturas", cascade = [CascadeType.ALL])
    var alumnos: Set<Alumno>?=null


) {
}