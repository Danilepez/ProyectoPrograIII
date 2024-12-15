import androidx.room.*

@Dao
interface ProductoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducto(producto: Producto)

    @Query("SELECT * FROM productos")
    suspend fun getAllProductos(): List<Producto>

    @Delete
    suspend fun deleteProducto(producto: Producto)

    @Update
    suspend fun updateProducto(producto: Producto)
}
