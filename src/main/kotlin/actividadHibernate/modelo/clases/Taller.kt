package actividadHibernate.modelo.clases
import jakarta.persistence.*

@Entity
@Table(name = "talleres")
class Taller (
    @Id
    @Column(name = "cif")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var cif: Long? = null,

    @Column(name = "contraseña")
    var contraseña: String,

    @Column
    var nombre: String,

    @OneToOne (cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_direccion")
    var direccion: Direccion,

    @OneToMany(mappedBy = "taller", cascade = [CascadeType.ALL],fetch = FetchType.LAZY)
    var pedidos:MutableSet<Pedido>?= null,

    @ManyToMany(mappedBy = "talleres",cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var clientes: MutableSet<Cliente>?=null,
){
}