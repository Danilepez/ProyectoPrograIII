import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "listas")
data class Lista(
    @PrimaryKey(autoGenerate = true) val id: Int = 0, // ID único para cada lista
    val nombre: String, // Nombre de la lista
    val cantidadProductos: Int // Cantidad de productos en la lista
)
