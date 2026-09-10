fun main() {
    val r = Repository()

    val reserva1 = Alojamiento(
        1, "Jordan", 1, 10000, 2, Tipo_Alojamiento.Habitacion)

    val reserva2 = Alojamiento(
        2, "Camilo", 2, 40000, 2, Tipo_Alojamiento.Cabaña
    )

    val reserva3 = Alojamiento(
        3, "Mati", 5, 50000, 5, Tipo_Alojamiento.Departamento
    )

    val reserva4 = Alojamiento(
        4, "", 2, 10000, 2, Tipo_Alojamiento.Habitacion
    )



    r.agregarRerserva(reserva1)
    r.agregarRerserva(reserva2)
    r.agregarRerserva(reserva3)
    r.agregarRerserva(reserva4)

    //r.obtenerReserva()

    r.obtenerReservaMonto(50000)
}