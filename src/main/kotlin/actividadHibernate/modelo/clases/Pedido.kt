package actividadHibernate.modelo.clases
import jakarta.persistence.*

@Entity
@Table(name ="pedidos")
class Pedido(

    @ManyToOne
    @JoinColumn(name = "cif_taller")
    var taller: Taller?=null,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "dni_cliente")
    var cliente: Cliente?=null,

    @Column(name="descripcion")
    var descripcion:String,

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long?=null
){
    override fun toString(): String {
        return "Pedido(taller=$taller, cliente=$cliente, descripcion='$descripcion', id=$id)"
    }
}