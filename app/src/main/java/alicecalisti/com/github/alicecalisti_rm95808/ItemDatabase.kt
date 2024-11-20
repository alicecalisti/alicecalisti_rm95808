package alicecalisti.com.github.alicecalisti_rm95808

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ItemModel::class], version = 1)
abstract class ItemDatabase : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}