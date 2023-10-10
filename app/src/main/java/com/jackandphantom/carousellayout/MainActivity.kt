package com.jackandphantom.carousellayout

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.customviewimple.model.DataModel
import com.jackandphantom.carousellayout.adapter.DataAdapter
import com.jackandphantom.carousellayout.databinding.ActivityMainBinding
import com.jackandphantom.carouselrecyclerview.CarouselLayoutManager

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = ArrayList<DataModel>()
//        list.add(DataModel(R.drawable.hacker, "Thi is cool"))
//        list.add(DataModel(R.drawable.hobes, "Thi is cool"))
//        list.add(DataModel(R.drawable.guypro, "Thi is cool"))
//        list.add(DataModel(R.drawable.joker, "Thi is cool"))
//


        list.add(DataModel(R.drawable.axis, "Thi is cool"))
        list.add(DataModel(R.drawable.paytm, "Thi is cool"))
        list.add(DataModel(R.drawable.axis1, "Thi is cool"))
        list.add(DataModel(R.drawable.paytm2, "Thi is cool"))
        list.add(DataModel(R.drawable.axis2, "Thi is cool"))
        list.add(DataModel(R.drawable.stand1, "Thi is cool"))
       // list.add(DataModel(R.drawable.londonlove, "Thi is cool"))

        val adapter = DataAdapter(list)

        binding.recycler.apply {
            this.adapter = adapter
//            set3DItem(true)
            setInfinite(true)
            setAlpha(true)
            setIntervalRatio(0.6f)
//            setFlat(true)
            setIsScrollingEnabled(true)
            setOrientation(RecyclerView.VERTICAL)
//            set3DItem(true)
//            setAlpha(true)

        }

        //Trigger the button and put your useCase to test different cases of adapter
//        binding.button.setOnClickListener {
//            adapter.removeData()
//        }

//        handler.postDelayed(runnable, 2000)

        binding.recycler.setItemSelectListener(object : CarouselLayoutManager.OnSelected {
            override fun onItemSelected(position: Int) {
                binding.button.text = "Selected item ${position+1}"
                Log.d("mvv","onItemSelected position $position")
                setAlphaByPosition(position)
            }

        })

        val currentlyCenterPosition = binding.recycler.getSelectedPosition()
        binding.button.text = "Selected item ${currentlyCenterPosition+1}"

    }


    fun setAlphaByPosition(position: Int){

        binding.recycler.layoutManager?.findViewByPosition(position)
            ?.let { view ->
                view.alpha = 1f;

//                Toast.makeText(this, "position $position", Toast.LENGTH_LONG).show()
            }
    }


//    val handler = Handler(Looper.getMainLooper())

//    val runnable = Runnable {
//        binding.recycler.apply {
//            setIntervalRatio(0.4f)
//        }
//    }





}