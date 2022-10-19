package com.ft.laundrycomeshome

import android.annotation.SuppressLint
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(
    private val context: Activity
) : RecyclerView.Adapter<ItemsAdapter.CategoricalViewHolder>() {

    private val categoryList = ArrayList<ItemModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoricalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.rv_items, parent, false)
        return CategoricalViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoricalViewHolder, position: Int) {
        val model = categoryList[position]
        if(position % 2 == 0)
        {
            holder.rl_container.setBackgroundColor(ContextCompat.getColor(context, R.color.light_blue))
            holder.iv_ic.setImageResource(model.icon)
            holder.tv_title.text = model.name
            holder.tv_title.setTextColor(ContextCompat.getColor(context, R.color.dark_blue))
            holder.iv_right_arrow_btn.backgroundTintList = ContextCompat.getColorStateList(context, R.color.dark_blue)
            holder.iv_right_arrow_btn.imageTintList = ContextCompat.getColorStateList(context, R.color.light_blue)
        }
        else
        {
            holder.rl_container.setBackgroundColor(ContextCompat.getColor(context, R.color.dark_blue))
            holder.iv_ic.setImageResource(model.icon)
            holder.tv_title.text = model.name
            holder.tv_title.setTextColor(ContextCompat.getColor(context, R.color.light_blue))
            holder.iv_right_arrow_btn.backgroundTintList = ContextCompat.getColorStateList(context, R.color.light_blue)
            holder.iv_right_arrow_btn.imageTintList = ContextCompat.getColorStateList(context, R.color.dark_blue)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(arrayList: ArrayList<ItemModel>) {
        categoryList.clear()
        categoryList.addAll(arrayList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class CategoricalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rl_container: RelativeLayout = itemView.findViewById(R.id.rl_container)
        var iv_ic: ImageView = itemView.findViewById(R.id.iv_ic)
        var tv_title: TextView = itemView.findViewById(R.id.tv_title)
        val iv_right_arrow_btn: ImageView = itemView.findViewById(R.id.iv_right_arrow_btn)
    }
}