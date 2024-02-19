data class Libro(val titulo: String, val autor: String, val añoPublicacion: Int)
data class Revista(val titulo: String, val issue: Int, val año: Int)
data class DVD(val titulo: String, val director: String, val año: Int)

sealed class Usuario {
    abstract val id: String
    abstract val nombre: String
}

open class Estudiante(override val id: String, override val nombre: String, val carrera: String) : Usuario()
open class Profesor(override val id: String, override val nombre: String, val departamento: String) : Usuario()
open class Visitante(override val id: String, override val nombre: String) : Usuario()

fun tomarPrestado(usuario: Usuario, libro: Libro): String {
    return when (usuario) {
        is Estudiante -> "El estudiante ${usuario.nombre} ${if (libro.titulo.contains("Matemáticas")) "puede" else "no puede"} tomar prestado el libro ${libro.titulo}."
        is Profesor -> "El profesor ${usuario.nombre} ${if (libro.titulo.equals("Historia Universal")) "puede" else "no puede"} tomar prestado el libro ${libro.titulo} por más tiempo."
        is Visitante -> "El visitante ${usuario.nombre} no puede tomar prestado ningún libro."
    }
}

fun main() {
    val libro1 = Libro("Libro de Matemáticas", "Juan Pérez", 2020)
    val libro2 = Libro("Historia Universal", "Ana Gómez", 2015)
    val libro3 = Libro("El Señor de los Anillos", "JRR Tolkien", 1954)

    val estudiante = Estudiante("1001", "Carlos", "Ingeniería Informática")
    val profesor = Profesor("2001", "Manuel", "Historia")
    val visitante = Visitante("3001", "Javier")

    println(tomarPrestado(estudiante, libro1))
    println(tomarPrestado(profesor, libro2))
    println(tomarPrestado(visitante, libro3))
}
