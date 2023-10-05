package com.vikas.simplesearchinrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vikas.simplesearchinrecyclerview.R
import com.vikas.simplesearchinrecyclerview.data.CourseRVModal

// on below line we are creating a course rv adapter class.
class CourseRVAdapter(
    // on below line we are passing variables as course list and context
    private var courseList: ArrayList<CourseRVModal>,
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {
        // this method is use to inflate the layout file
        // which we have created for our recycler view.
        // on below line we are inflating our layout file.
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.course_rv_item,
            parent, false
        )

        // at last we are returning our view holder
        // class with our item View File.
        return CourseViewHolder(itemView)
    }

    // method for filtering our recyclerview items.
    fun filterList(filterlist: ArrayList<CourseRVModal>) {
        // below line is to add our filtered
        // list in our course array list.
        courseList = filterlist
        // below line is to notify our adapter
        // as change in recycler view data.
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CourseRVAdapter.CourseViewHolder, position: Int) {
        // on below line we are setting data to our text view and our image view.
        holder.courseNameTV.text = courseList[position].courseName
        holder.courseIV.setImageResource(courseList[position].courseImg)
    }

    override fun getItemCount(): Int {
        // on below line we are returning
        // our size of our list
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
        val courseIV: ImageView = itemView.findViewById(R.id.idIVCourse)
    }
}