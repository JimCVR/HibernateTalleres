package actividadHibernate.vista

import actividadHibernate.modelo.clases.Cliente
import actividadHibernate.modelo.clases.Direccion
import actividadHibernate.controlador.AppController

class Vista {
    fun menuPrincipal(){
        println("Bienvenido, elija una opción:" +
                "\n1.Gestionar proveedores"+
                "\n2.Gestionar productos" +
                "\n0.Salir")
        println("******************************")
        try{
            when(readln().toInt()){
                1 -> menuProveedor()
                2 -> menuProducto()
                0 -> salir()
                else -> {
                    println("Opción incorrecta, introduzca otra:")
                    menuPrincipal()
                }
            }
        }catch (n :NumberFormatException){
            println("Opción incorrecta, introduzca otra:")
            menuPrincipal()
        }


    }
    private fun menuProveedor(){

        println("AREA DE CLIENTES" +
                "\nElige una opción:" +
                "\n1.Mostrar clientes " +
                "\n2.Mostrar información de un cliente." +
                "\n3.Añadir nuevo proveedor."+
                "\n4.Actualizar datos de un proveedor (telefono o dirección)." +
                "\n5.Borrar un proveedor."+
                "\n0.Atras.")
        println("******************************")

        try {
            when (readln().toInt()) {
                1 -> {
                    AppController().onSelectId(Cliente("Jaime", "jaime@gmail.com", Direccion("hola",10,"101")),"1234")
                    menuProveedor()
                }

                2 -> {
                    println("Id del proveedor:")
                    val id: String = readln()
                    //AppController().onSelectId(id)
                    menuProveedor()
                }

                3 -> {
                    println("Id:")
                    val id: String = readln()
                    println("Nombre:")
                    val nombre: String = readln()
                    println("Dirección:")
                    val direccion: String = readln()
                    println("Teléfono:")
                    val telefono: Int = readln().toInt()

                    //AppController().onInsertProveedor()
                    menuProveedor()
                }

                4 -> {
                    println("¿Actualizar teléfono(1) o dirección(2)?")
                    try {
                        when (readln().toInt()) {

                            1 -> {
                                println("Id del proveedor:")
                                val id: String = readln()
                                println("Nuevo teléfono:")
                                val telefono: Int = readln().toInt()
                               // AppController().onUpdateTelProveedor(id, telefono)
                                menuProveedor()
                            }

                            2 -> {
                                println("Id del proveedor:")
                                val id: String = readln()
                                println("Nueva dirección:")
                                val direccion: String = readln()
                             //   AppController().onUpdateDirProveedor(id, direccion)
                                menuProveedor()
                            }

                            else -> {
                                println("Opción no válida, volviendo al area de proveedores...")
                                menuProveedor()
                            }
                        }
                    }catch (n :NumberFormatException){
                        println("Opción no válida, volviendo al area de proveedores...")
                        menuProveedor()
                    }
                }
                5 -> {
                    println("Id del proveedor:")
                    val id: String = readln()
                  //  AppController().onDeleteProveedor(id)
                    menuProveedor()
                }

                0 -> menuPrincipal()

                else -> {
                    menuProveedor()
                }
            }
        }catch (n :NumberFormatException){
            println("Opción invalida, por favor intentelo de nuevo")
            menuProveedor()
        }
    }
    private fun menuProducto(){

        println("INVENTARIO" +
                "\nElige una opcion" +
                "\n1.Mostrar lista de productos." +
                "\n2.Consultar producto por id." +
                "\n3.Consultar productos por disponibilidad"+
                "\n4.Insertar un nuevo producto." +
                "\n5.Actualizar existencias." +
                "\n6.Actualizar precio." +
                "\n7.Eliminar un producto."+
                "\n0.Atras.")
        println("******************************")
        when(readln().toInt()){
            1 -> {
              //  AppController().onSelect()
                menuProducto()
            }
            2 ->{
                println("Id del producto:")
                val id:String = readln()
              //  AppController().onSelect(,id)
                menuProducto()
            }
            3 ->{
                println("Productos disponibles:")
             //   AppController().onSelect()
                println("\nProductos fuera de stock:")
             //   AppController().onSelect()
                menuProducto()
            }
            4 ->{
                println("Id:")
                val id:String = readln()
                println("Nombre:")
                val nombre:String = readln()
                println("Existencias:")
                val existencias:Int = readln().toInt()
                println("Precio:")
                val precio:Double = readln().toDouble()
                println("Tipo:")
                val tipo:String = readln()
                println("Id del proveedor:")
                val idProv:String = readln()

              //  AppController().onInsert()
                menuProducto()
            }
            5 -> {
                println("Id:")
                val id:String = readln()
                println("Existencias:")
                val existencias:Int = readln().toInt()
              //  AppController().onUpdate(id,existencias)
                menuProducto()
            }
            6 -> {
                println("Id:")
                val id:String = readln()
                println("Nuevo precio:")
                val precio:Double = readln().toDouble()
              //  AppController().onUpdate(id,precio)
                menuProducto()
            }
            7 ->{
                println("¿Borrar productos por id(1) o por tipo(2)?")
                try {
                    when(readln().toInt()){
                        1->{
                            println("Id:")
                            val id:String = readln()
                            AppController().onDelete(id)
                            menuProducto()
                        }
                        2 -> {
                            println("Tipo:")
                            val tipo:String = readln()
                            AppController().onDelete("")
                            menuProducto()
                        }
                        else -> {
                            println("Opción no válida, volviendo al Inventario...")
                            menuProducto()
                        }
                    }
                }catch (n:NumberFormatException){
                    println("Opción no válida, volviendo al Inventario...")
                    menuProducto()
                }
            }
            0-> menuPrincipal()
        }
    }
fun mostrarProveedor(){
/*
     listaProveedor.forEach(){ proveedor: Proveedor ->
         println("Id: ${proveedor.id}")
         println("Nombre: ${proveedor.nombre}")
         println("Direccion: ${proveedor.direccion}")
         println("Telefono: ${proveedor.telefono}")
         println("******************************")
    }*/
}
fun mostrarProducto(){
   /* listaProducto.forEach() { producto: Producto ->
        println("Id: ${producto.id}")
        println("Nombre: ${producto.nombre}")
        println("Existencias: ${producto.existencias}")
        println("Precio: ${producto.precio}")
        println("Tipo: ${producto.tipo}")
        println("IdProveedor: ${producto.idProveedor}")
        println("******************************")
    }*/
}


    fun updateRealizado(lineas:Int){
        println("Update Realizado")
        println("Numero de lineas afectadas: $lineas")
        println("****************************")
    }
    fun insertRealizado(){
        println("Insert Realizado")
        println("****************************")
    }
    fun deleteRealizado(lineas:Int){
        println("Delete Realizado")
        println("Numero de lineas afectadas: $lineas")
        println("****************************")
    }


    fun basedeDatosCaida() {
        println("Error. Base de datos caida")
    }

    fun noProd() {
        println("No existen productos")
    }

    fun errorGeneral() {
        println("Error general")
    }

    fun salir() {
        println("Adios")
    }

}