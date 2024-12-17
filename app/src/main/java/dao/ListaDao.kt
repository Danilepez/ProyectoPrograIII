import androidx.room.*
import com.example.aaa.dataclasses.Lista

@Dao
interface ListaDao {
    @Insert
    suspend fun insertarLista(lista: Lista)

    @Query("SELECT * FROM listas")
    suspend fun obtenerListas(): List<Lista>
}
