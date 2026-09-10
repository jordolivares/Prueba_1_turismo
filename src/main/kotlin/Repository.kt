class Repository {
    private val lista_reserva = mutableListOf<Alojamiento>()

    fun validarId(id: Int) : Result<Int> {
        return if (id > 0) {
            Result.success(id)
        } else {
            Result.failure(Exception("Id tiene que ser mayor que 0"))
        }
    }

    fun validarNombre(nombre: String) : Result<String> {
        return if (nombre.isNotBlank()) {
            Result.success(nombre)
        } else {
            Result.failure(Exception("El nombre del cliente no puede estar vacio"))
        }
    }

    fun validarCantNoche(cantidad: Int) : Result<Int> {
        return if (cantidad > 0) {
            Result.success(cantidad)
        } else {
            Result.failure(Exception("La cantidad de noches debe ser mayor que 0"))
        }
    }

    fun validarValorNoche(valor_reserva: Int) : Result<Int> {
        return if (valor_reserva > 0) {
            Result.success(valor_reserva)
        } else {
            Result.failure(Exception("El valor por noche debe ser mayor que 0"))
        }
    }

    fun validarCantiPersona(cantidad_p_reserva: Int) : Result<Int> {
        return if (cantidad_p_reserva > 0) {
            Result.success(cantidad_p_reserva)
        } else {
            Result.failure(Exception("La cantidad de personas debe ser mayor que 0"))
        }
    }


    fun agregarRerserva(reserva : Alojamiento) {

        val idValido = validarId(reserva.id)
        val nombreValido = validarNombre(reserva.nombre_cliente)
        val cantidadNoche = validarCantNoche(reserva.cantidad)
        val valorNoche = validarValorNoche(reserva.valor_reserva)
        val cantidadPer =validarCantiPersona(reserva.cantidad_p_reserva)

        if (idValido.isSuccess && nombreValido.isSuccess && cantidadNoche.isSuccess && valorNoche.isSuccess && cantidadPer.isSuccess) {
            lista_reserva.add(reserva)
            println("Se registro reserva Correctamente")
        } else {

            idValido.onFailure {  e -> println(e.message)}
            nombreValido.onFailure { e -> println(e.message) }
            cantidadNoche.onFailure { e -> println(e.message) }
            valorNoche.onFailure { e -> println(e.message) }
            cantidadPer.onFailure { e -> println(e.message) }
        }

    }

    fun obtenerReserva() {
        println("\nLista de reserva")
        for (reserva in lista_reserva) {

            val total = reserva.valor_reserva * reserva.cantidad

            println("\nID RESERVA: ${reserva.id}")
            println("NOMBRE CLIENTE:  ${reserva.nombre_cliente}")
            println("CANTIDAD DE NOCHE:  ${reserva.cantidad}")
            println("VALOR NOCHE:  ${reserva.valor_reserva}")
            println("CANTIDAD PERSONAS: ${reserva.cantidad_p_reserva}")
            println("TIPO DE ALOJAMIENTO: ${reserva.tipo_alojamiento.nombre}" )
            println("VALOR RESERVA: ${total}")
            println("Descripción: ${reserva.tipo_alojamiento.detalle}")
        }
    }

    fun obtenerReservaMonto(valor: Int) {
        val reservasFiltradas = lista_reserva.filter { it.valor_reserva >= valor }
        println("\nLista de reserva")
        for (reserva in reservasFiltradas) {
            val total = reserva.valor_reserva * reserva.cantidad

            println("\nID RESERVA: ${reserva.id}")
            println("NOMBRE CLIENTE:  ${reserva.nombre_cliente}")
            println("CANTIDAD DE NOCHE:  ${reserva.cantidad}")
            println("VALOR NOCHE:  ${reserva.valor_reserva}")
            println("CANTIDAD PERSONAS: ${reserva.cantidad_p_reserva}")
            println("TIPO DE ALOJAMIENTO: ${reserva.tipo_alojamiento.nombre}" )
            println("VALOR RESERVA: ${total}")
            println("Descripción: ${reserva.tipo_alojamiento.detalle}")
        }

    }

   

}