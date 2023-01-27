package actividadHibernate.modelo.clases
import jakarta.persistence.*

@Entity
@Table(name = "clientes")
class Cliente (

    @Column(name = "nombre")
    var nombre: String,

    @Column(name = "contraseña")
    var contraseña: String,

    @Column(name = "email")
    var email: String,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "id_direccion")
    var direccion: Direccion,

    @OneToMany(mappedBy = "cliente", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var pedidos:MutableSet<Pedido>?=null,


    @ManyToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinTable(
        name = "cliente_taller",
        joinColumns = [JoinColumn (name = "id_cliente")],
        inverseJoinColumns = [JoinColumn (name = "id_taller")]
    )
    var talleres: MutableSet<Taller>?=null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var dni: String? = null

){
    override fun toString(): String {
        return "Cliente(nombre='$nombre', contraseña='$contraseña', email='$email', direccion=$direccion, pedidos=$pedidos, talleres=$talleres, dni=$dni)"
    }
}