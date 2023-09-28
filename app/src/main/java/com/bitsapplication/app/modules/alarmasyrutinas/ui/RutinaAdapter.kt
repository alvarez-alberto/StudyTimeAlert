package com.bitsapplication.app.modules.alarmasyrutinas.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bitsapplication.app.R
import com.bitsapplication.app.databinding.RowRutinasBinding
import com.bitsapplication.app.modules.alarmasyrutinas.data.model.RowRutinasModel

class RutinaAdapter(
    var list: List<RowRutinasModel>
) : RecyclerView.Adapter<RutinaAdapter.RowRutinaVH>() {
    private var clickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowRutinaVH {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_rutinas,parent,false)
        return RowRutinaVH(view)
    }

    override fun onBindViewHolder(holder: RowRutinaVH, position: Int) {
        val rowRutinasModel = RowRutinasModel()
        // TODO uncomment following line after integration with data source
        // val gridtitleRowModel = list[position]
        holder.binding.rowRutinas = rowRutinasModel
    }

    override fun getItemCount(): Int = 8
    // TODO uncomment following line after integration with data source
    // return list.size

    public fun updateData(newData: List<RowRutinasModel>) {
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
            item: RowRutinasModel
        ) {
        }
    }

    inner class RowRutinaVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        val binding: RowRutinasBinding = RowRutinasBinding.bind(itemView)
    }
}