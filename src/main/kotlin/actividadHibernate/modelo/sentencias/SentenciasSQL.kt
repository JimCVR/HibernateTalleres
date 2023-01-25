package actividadHibernate.modelo.sentencias

object SentenciasSQL {

    //Sentencias productos
    val selectAllProducto:String = "SELECT * FROM producto"
    val selectProductoId:String = "SELECT * FROM producto WHERE id=?"
    val selectProdDisponible:String = "SELECT * FROM producto WHERE existencias>0"
    val selectProdNoDisponible:String = "SELECT * FROM producto WHERE existencias=0"
    val insertProduct:String = "INSERT INTO producto VALUES(?,?,?,?,?,?)"
    val updateCantProd:String = "UPDATE producto SET existencias=? WHERE id=?"
    val updatePriceProd:String = "UPDATE producto SET precio=? WHERE id=?"
    val deleteProductoId:String = "DELETE FROM producto WHERE id=?"
    val deleteProductoTipo:String = "DELETE FROM producto WHERE tipo=?"

    //Sentencias Proveedores
    val selectAllProveedor:String = "SELECT * FROM proveedor"
    val selectProveedorId:String = "SELECT * FROM proveedor WHERE id=?"
    val insertProveedor:String = "INSERT INTO proveedor VALUES(?,?,?,?)"
    val updateDirProveedor:String = "UPDATE proveedor SET direccion=? WHERE id=?"
    val updateTelProveedor:String = "UPDATE proveedor SET telefono=? WHERE id=?"
    val deleteProveedorId:String = "DELETE FROM proveedor WHERE id=?"

}