package alicecalisti.com.github.alicecalisti_rm95808

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ItemsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Eco Dicas"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemsAdapter = ItemsAdapter { item ->
            viewModel.removeItem(item)
        }
        recyclerView.adapter = itemsAdapter

        val button = findViewById<Button>(R.id.button)
        val editTextTitle = findViewById<EditText>(R.id.editTextTitle)
        val editTextDescription = findViewById<EditText>(R.id.editTextDescription)

        button.setOnClickListener {
            if (editTextTitle.text.isEmpty()) {
                editTextTitle.error = "Preencha um valor"
                return@setOnClickListener
            }
            if (editTextDescription.text.isEmpty()) {
                editTextDescription.error = "Preencha um valor"
                return@setOnClickListener
            }
            val x = ItemModel(
                title = editTextTitle.text.toString(),
                description = editTextDescription.text.toString())
            viewModel.addItem(x)
            editTextTitle.text.clear()
            editTextDescription.text.clear()
        }
        val viewModelFactory = ItemsViewModelFactory(application)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ItemsViewModel::class.java)
        viewModel.itemsLiveData.observe(this) { items ->
            itemsAdapter.updateItems(items)
        }
    }
}

