package com.learning.recyclerviewfundamentals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerViewAdapter(
    private val fruitList: List<Fruit>,
    private val clickListener: (Fruit) -> Unit      // This style of kotlin to receiving the function
) : RecyclerView.Adapter<MyViewHolder>() {
// this adapter need the type , that should be View Holder class type
// so we need to create a view holder class so let it be

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item, parent, false)
        return MyViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // use to display data on list item, since we have returned 5 or what ever the size...
        val fruit = fruitList[position]
        holder.bind(fruit, clickListener)            // This style io kotlin to sending the function
    }

    override fun getItemCount(): Int {
        return fruitList.size
    }

}

class MyViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    fun bind(fruit: Fruit, clickListener: (Fruit) -> Unit) {                 // This style of kotlin to receiving the function
        val myTextView = view.findViewById<TextView>(R.id.tvName)
        myTextView.text = fruit.name

        view.setOnClickListener {
            clickListener(fruit)
        }
    }


}