sealed class Tipo_Alojamiento(
    val nombre : String,
    val detalle : String
) {
    object Habitacion : Tipo_Alojamiento("Habitacion", "Habitacíon para 1 o más persona")
    object Cabaña :  Tipo_Alojamiento("Cabaña", "Casa cerca de un lago")
    object Departamento : Tipo_Alojamiento("Departamento", "Edificio frente a la playa")
}