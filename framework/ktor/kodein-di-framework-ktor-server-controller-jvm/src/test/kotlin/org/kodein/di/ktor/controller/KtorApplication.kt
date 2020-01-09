package org.kodein.di.ktor.controller

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.routing.*
import org.kodein.di.generic.*
import org.kodein.di.ktor.*

const val AUTHOR = "Romain Boisselle"
const val VERSION = "1.0.0"

fun Application.installDI() = di {
          bind<ApplicationController>() with singleton { ApplicationController(instance()) }
          constant("author") with AUTHOR
          constant("version") with VERSION
        }

fun Application.diAbsControllerSuccess() {
    install(DefaultHeaders)
    installDI()
    install(DIControllerFeature)
}

fun Application.diAbsControllerFailure() {
    install(DefaultHeaders)
    install(DIControllerFeature)
    installDI()
}

fun Application.diControllerImplSuccess() {
    install(DefaultHeaders)
    installDI()
    install(DIControllerFeature)
}

fun Application.dicontrollerImplFailure() {
    install(DefaultHeaders)
    install(DIControllerFeature)
    installDI()
}

fun Application.diControllerSuccess() {
    install(DefaultHeaders)
    installDI()
    routing {

        controller { DIControllerImpl(instance()) }

        route("/first") {
            controller { DIControllerImpl(instance()) }

            route("/second") {
                controller { ApplicationController(instance()) }

                route("/third") {
                    controller { ApplicationController(instance()) }
                }
            }
        }

        controller("/protected") { DIControllerImpl(instance()) }
    }
}