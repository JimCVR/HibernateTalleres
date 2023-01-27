package actividadHibernate

import actividadHibernate.controlador.AppController
import actividadHibernate.vista.Vista

fun main() {
    var vista: Vista = Vista()
    var controller : AppController = AppController(vista)
    controller.mainMenu()
}
