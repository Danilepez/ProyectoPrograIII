import androidx.room.*

@Dao
interface ListaDao {
    @Insert
    suspend fun insertarLista(lista: Lista)

    @Query("SELECT * FROM listas")
    suspend fun obtenerListas(): List<Lista>
}
