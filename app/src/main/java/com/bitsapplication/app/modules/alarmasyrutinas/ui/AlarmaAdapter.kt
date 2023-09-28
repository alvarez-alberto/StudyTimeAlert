package com.bitsapplication.app.modules.alarmasyrutinas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitsapplication.app.R
import com.bitsapplication.app.databinding.RowGridtitleBinding
import com.bitsapplication.app.modules.alarmasyrutinas.`data`.model.GridtitleRowModel
import kotlin.Int
import kotlin.collections.List

class AlarmaAdapter(
  var list: List<GridtitleRowModel>
) : RecyclerView.Adapter<AlarmaAdapter.RowGridtitleVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowGridtitleVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_gridtitle,parent,false)
    return RowGridtitleVH(view)
  }

  override fun onBindViewHolder(holder: RowGridtitleVH, position: Int) {
    val gridtitleRowModel = GridtitleRowModel()
    // TODO uncomment following line after integration with data source
    // val gridtitleRowModel = list[position]
    holder.binding.gridtitleRowModel = gridtitleRowModel
  }

  override fun getItemCount(): Int = 8
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<GridtitleRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: GridtitleRowModel
    ) {
    }
  }

  inner class RowGridtitleVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowGridtitleBinding = RowGridtitleBinding.bind(itemView)
  }
}
