package com.ft.laundrycomeshome

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ft.laundrycomeshome.R
import com.google.android.material.navigation.NavigationView

class HomeFragment : Fragment() {

    private lateinit var rv: RecyclerView
    private lateinit var adapter: ItemsAdapter
    private lateinit var itemList: ArrayList<ItemModel>
    private lateinit var iv_menu: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_home, container, false)


        val drawerMenu = view.findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = view.findViewById<NavigationView>(R.id.nav_view)

        rv = view.findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        itemList = ArrayList()
        adapter = ItemsAdapter(requireActivity())
        rv.adapter = adapter

        itemList.add(ItemModel(R.drawable.ic_order_item, "Orders"))
        itemList.add(ItemModel(R.drawable.ic_how_its_works, "How it works"))
        itemList.add(ItemModel(R.drawable.ic_about_us, "About us"))
        itemList.add(ItemModel(R.drawable.ic_contact_us, "Contact us"))

        adapter.update(itemList)

        iv_menu = view.findViewById(R.id.iv_menu)

        iv_menu.setOnClickListener {
            showToast("Menu Clicked")
            if (drawerMenu.isDrawerVisible(GravityCompat.START)){
                drawerMenu.closeDrawer(GravityCompat.START)
            }else{
                drawerMenu.openDrawer(GravityCompat.END)
            }
        }


        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.item_1->{
                    showToast("Item-1")
                }
                R.id.item_2->{
                    showToast("Item-2")
                }
                R.id.item_3->{
                    showToast("Item-3")
                }
            }
            true
        }


        return view
    }

    private fun showToast(msg: String) {
        Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show()
    }

}
