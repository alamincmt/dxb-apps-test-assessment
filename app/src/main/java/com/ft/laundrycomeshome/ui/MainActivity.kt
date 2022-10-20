package com.ft.laundrycomeshome.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.NavController
import com.ft.laundrycomeshome.R
import com.ft.laundrycomeshome.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.floatingActionButton.setOnClickListener {
            showToast("New Order Selected")
        }

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home_fragment ->{
                    showToast("Home Selected")
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, HomeFragment(), "finish").commit()
                }

                R.id.orders_fragment -> {
                    showToast("Orders Selected")
                }

                R.id.new_order_fragment -> {
                    showToast("New Order Selected")
                }

                R.id.notification_fragment -> {
                    showToast("Notification Selected")
                }

                R.id.my_account_fragment -> {
                    showToast("My Account Selected")
                }
            }
            true
        }
    }



    private fun showToast(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}