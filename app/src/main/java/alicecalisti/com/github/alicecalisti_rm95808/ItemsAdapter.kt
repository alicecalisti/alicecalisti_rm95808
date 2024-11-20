package alicecalisti.com.github.alicecalisti_rm95808

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val onItemRemoved: (ItemModel) -> Unit) :
    RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {
    private var items = listOf<ItemModel>()

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val textViewTitle = view.findViewById<TextView>(R.id.textViewTitle)
        val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        fun bind(item: ItemModel) {
            textViewTitle.text = item.title
            textViewDescription.text = item.description

            button.setOnClickListener {
                onItemRemoved(item)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun updateItems(newItems: List<ItemModel>) {
        items = newItems
        notifyDataSetChanged()
    }
}