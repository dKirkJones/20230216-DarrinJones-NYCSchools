package com.djmakes.nycschools.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.djmakes.nycschools.R
import com.djmakes.nycschools.data.School

class SchoolListAdapter(
    var schoolList: List<School.SchoolInfo> = emptyList(),
    val listener: OnItemClickListener
) : RecyclerView.Adapter<SchoolListAdapter.SchoolItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return SchoolItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SchoolItemViewHolder, position: Int) {
        holder.schoolName.text = schoolList[position].schoolName
        holder.schoolNeighborhood.text = schoolList[position].neighborhood
        holder.schoolAddress.text = schoolList[position].address
        holder.itemView.setOnClickListener {
            listener.onItemClick(schoolList[position])
        }
    }
    override fun getItemCount(): Int {
        return schoolList.size
    }

    inner class SchoolItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var schoolName: TextView
        var schoolNeighborhood: TextView
        var schoolAddress: TextView

        init {
            schoolName = itemView.findViewById(R.id.txt_school_name)
            schoolNeighborhood = itemView.findViewById(R.id.txt_school_neighborhood)
            schoolAddress = itemView.findViewById(R.id.txt_school_address)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: School.SchoolInfo)
    }
}
