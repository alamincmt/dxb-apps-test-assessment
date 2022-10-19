package com.ft.laundrycomeshome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.ft.laundrycomeshome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            showToast("New Order Selected")
            /*supportFragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(R.id.fragment_container, NewOrderFragment(), "finish").commit()*/
        }

//        navController = Navigation.findNavController(this, R.id.fragment_container)
//        setupWithNavController(binding.bottomNavigationView , navController)


        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_fragment->{
                    showToast("Home Selected")
                    supportFragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .replace(R.id.fragment_container, HomeFragment(), "finish").commit()
                }

                R.id.orders_fragment -> {
                    showToast("Orders Selected")
                    /*supportFragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .replace(R.id.fragment_container, OrdersFragment(), "finish").commit()*/
                }

                R.id.new_order_fragment -> {
                    showToast("New Order Selected")
                    /*supportFragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .replace(R.id.fragment_container, NewOrderFragment(), "finish").commit()*/
                }

                R.id.notification_fragment -> {
                    showToast("Notification Selected")
                    /*supportFragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .replace(R.id.fragment_container, NotificationsFragment(), "finish").commit()*/
                }

                R.id.my_account_fragment -> {
                    showToast("My Account Selected")
                   /* supportFragmentManager.beginTransaction()
                        //.addToBackStack(null)
                        .replace(R.id.fragment_container, MyAccountFragment(), "finish").commit()*/
                }
            }
            true
        }
    }



    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}