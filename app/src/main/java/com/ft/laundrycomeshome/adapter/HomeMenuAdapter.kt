package com.ft.laundrycomeshome.adapter

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
import com.ft.laundrycomeshome.R
import com.ft.laundrycomeshome.model.HomeMenu

class HomeMenuAdapter(
    private val context: Activity
) : RecyclerView.Adapter<HomeMenuAdapter.CategoricalViewHolder>() {

    private val homeMenuList = ArrayList<HomeMenu>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoricalViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.items_home_menu, parent, false)
        return CategoricalViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoricalViewHolder, position: Int) {
        val model = homeMenuList[position]
        if (position % 2 == 0) {
            holder.rlContainer.setBackgroundColor(
                ContextCompat.getColor(
                    context,
                    R.color.light_blue
                )
            )
            holder.ivIc.setImageResource(model.icon)
            holder.tvMenutitle.text = model.name
            holder.tvMenutitle.setTextColor(ContextCompat.getColor(context, R.color.dark_blue))
            holder.ivRightArrowBtn.backgroundTintList = ContextCompat.getColorStateList(context,R.color.dark_blue)
            holder.ivRightArrowBtn.imageTintList = ContextCompat.getColorStateList(context, R.color.light_blue)
        } else {
            holder.rlContainer.setBackgroundColor(ContextCompat.getColor(context,R.color.dark_blue))
            holder.ivIc.setImageResource(model.icon)
            holder.tvMenutitle.text = model.name
            holder.tvMenutitle.setTextColor(ContextCompat.getColor(context, R.color.light_blue))
            holder.ivRightArrowBtn.backgroundTintList = ContextCompat.getColorStateList(context, R.color.light_blue)
            holder.ivRightArrowBtn.imageTintList = ContextCompat.getColorStateList(context, R.color.dark_blue)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(arrayList: ArrayList<HomeMenu>) {
        homeMenuList.clear()
        homeMenuList.addAll(arrayList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return homeMenuList.size
    }

    class CategoricalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var rlContainer: RelativeLayout = itemView.findViewById(R.id.rl_container)
        var ivIc: ImageView = itemView.findViewById(R.id.iv_ic)
        var tvMenutitle: TextView = itemView.findViewById(R.id.tv_title)
        val ivRightArrowBtn: ImageView = itemView.findViewById(R.id.iv_right_arrow_btn)
    }
}