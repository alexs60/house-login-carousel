package com.example.myapplication.ui.carousel

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Carousel
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.domain.model.House

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var myAdapter = MyAdapter()

        binding.carousel.setAdapter(myAdapter)
        binding.carousel.jumpToIndex(0)

    }


    class MyAdapter(var houseList: List<House> = emptyList<House>()): Carousel.Adapter {

        override fun count(): Int {
            return houseList.size
        }

        override fun populate(view: View?, index: Int) {
            Log.d(MainActivity::class.simpleName, "populate")
        }

        override fun onNewItem(index: Int) {
            var current = houseList[index]
        }
    }

}
