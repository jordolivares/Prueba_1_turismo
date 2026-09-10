class Alojamiento(
    id : Int,
    nombre_cliente : String,
    cantidad: Int,
    val valor_reserva : Int,
    val cantidad_p_reserva : Int,
    val tipo_alojamiento : Tipo_Alojamiento
) : Reserva(id, nombre_cliente, cantidad) {
}