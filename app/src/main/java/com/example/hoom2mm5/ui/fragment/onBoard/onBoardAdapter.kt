package com.example.hoom2mm5.ui.fragment.onBoard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hoom2mm5.R
import com.example.hoom2mm5.databinding.ItemView2Binding

class onBoardAdapter(private val listner:getstart): RecyclerView.Adapter<onBoardAdapter.onBoardViewHolder>() {

    val tview = listOf("Have a good time","Have a good time","Have a good time")
    val tview1 = listOf("You should take the tame to help shose",
        "You should take the tame to help shose","You should take the tame to help choose")
    val tview2 = listOf("who need you","who need you","who need you")
    val img = listOf(R.drawable.img2,R.drawable.img2,R.drawable.img2)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): onBoardViewHolder {
       val binding = ItemView2Binding.inflate(LayoutInflater.from(parent.context),parent,false)
        return onBoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: onBoardViewHolder, position: Int) {
        holder.onBind(position)
        holder.binding.btnStart.setOnClickListener {
            listner.start()
        }
     }
    override fun getItemCount(): Int = tview.size

    inner class onBoardViewHolder( val binding: ItemView2Binding):
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            binding.tvOnb.text = tview[position]
            binding.tvOnb1.text = tview1[position]
            binding.tvOnb2.text = tview2[position]
            binding.imgon.setBackgroundColor(img[position])
           if (position == tview.size - 1){
               binding.btnStart.visibility = View.VISIBLE
           }else {
               binding.btnStart.visibility = View.GONE
           }
        }
    }
    interface getstart{
        fun start()
    }
}