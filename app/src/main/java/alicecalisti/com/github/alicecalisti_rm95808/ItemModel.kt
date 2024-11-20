package alicecalisti.com.github.alicecalisti_rm95808

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,

    )