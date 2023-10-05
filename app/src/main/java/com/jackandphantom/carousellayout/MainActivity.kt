package com.jackandphantom.carousellayout

import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewimple.model.DataModel
import com.jackandphantom.carousellayout.adapter.DataAdapter
import com.jackandphantom.carousellayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<DataModel>()
        list.add(DataModel(R.drawable.hacker, "Thi is cool"))
        list.add(DataModel(R.drawable.hobes, "Thi is cool"))
        list.add(DataModel(R.drawable.guypro, "Thi is cool"))
        list.add(DataModel(R.drawable.joker, "Thi is cool"))
        list.add(DataModel(R.drawable.joker, "Thi is cool"))
        list.add(DataModel(R.drawable.joker, "Thi is cool"))
        list.add(DataModel(R.drawable.joker, "Thi is cool"))
       // list.add(DataModel(R.drawable.londonlove, "Thi is cool"))

        val adapter = DataAdapter(list)

        binding.recycler.apply {
            this.adapter = adapter
//            set3DItem(true)
//            setInfinite(true)
            setAlpha(true)
//            setIntervalRatio(0.7f)
//            setFlat(true)
            setIsScrollingEnabled(true)
            setOrientation(RecyclerView.VERTICAL)
//            set3DItem(true)
//            setAlpha(true)

        }

        //Trigger the button and put your useCase to test different cases of adapter
        binding.button.setOnClickListener {
            adapter.removeData()
        }
    }
}