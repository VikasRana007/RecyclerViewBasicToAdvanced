package com.learning.recyclerviewfundamentals

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private val fruitList = listOf(
        Fruit("Mango", "Joe"),
        Fruit("Apple", "Jack"),
        Fruit("Banana", "Harry"),
        Fruit("Grapes", "Tom"),
        Fruit("Lemon", "Alex"),
        Fruit("Pear", "John"),
        Fruit("Orange", "Robert")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val doNothing : (Int) -> Int = { value -> value }
        val add : (Int, Int) -> Int = { a, b -> a + b }
        val result = add(3,3)

        val recyclerView = findViewById<RecyclerView>(R.id.myRecyclerView)
        recyclerView.setBackgroundColor(Color.YELLOW)
        // here we need to pass the context to tell the layout
        // manager which layout will be the container
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyRecyclerViewAdapter(fruitList) { selectedItem ->       // This style of kotlin to sending the function
            listItemClicked(selectedItem)
        }
    }

    private fun listItemClicked(fruit: Fruit) {
        Toast.makeText(
            this@MainActivity, "Supplier is : ${fruit.supplier}", Toast.LENGTH_LONG
        ).show()
    }


}
