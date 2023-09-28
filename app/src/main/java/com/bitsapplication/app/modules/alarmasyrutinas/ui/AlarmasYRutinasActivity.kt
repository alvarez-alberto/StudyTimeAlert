package com.bitsapplication.app.modules.alarmasyrutinas.ui

import android.view.View
import androidx.activity.viewModels
import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.base.BaseActivity
import com.bitsapplication.app.databinding.ActivityAlarmasYRutinasBinding
import com.bitsapplication.app.modules.alarmasyrutinas.`data`.model.GridtitleRowModel
import com.bitsapplication.app.modules.alarmasyrutinas.data.model.RowRutinasModel
import com.bitsapplication.app.modules.alarmasyrutinas.`data`.viewmodel.AlarmasYRutinasVM
import kotlin.Int
import kotlin.String
import kotlin.Unit

class AlarmasYRutinasActivity :
    BaseActivity<ActivityAlarmasYRutinasBinding>(R.layout.activity_alarmas_y_rutinas) {
  private val viewModel: AlarmasYRutinasVM by viewModels<AlarmasYRutinasVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val alarmaAdapter = AlarmaAdapter(viewModel.gridtitleList.value?:mutableListOf())
    binding.recyclerAlarmas.adapter = alarmaAdapter
    alarmaAdapter.setOnItemClickListener(
    object : AlarmaAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : GridtitleRowModel) {
        onClickRecyclerGridtitle(view, position, item)
      }
    }
    )
    viewModel.gridtitleList.observe(this) {
      alarmaAdapter.updateData(it)
    }
    binding.alarmasYRutinasVM = viewModel
    val rutinaAdapter = RutinaAdapter(viewModel.rowRutinasList.value?:mutableListOf())
    binding.recyclerRutinas.adapter = rutinaAdapter
    rutinaAdapter.setOnItemClickListener(
      object : RutinaAdapter.OnItemClickListener {
        override fun onItemClick(view:View, position:Int, item : RowRutinasModel) {
          onClickRecyclerRowRutina(view, position, item)
        }
      }
    )
    viewModel.rowRutinasList.observe(this) {
      rutinaAdapter.updateData(it)
    }
    binding.alarmasYRutinasVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  fun onClickRecyclerGridtitle(
    view: View,
    position: Int,
    item: GridtitleRowModel
  ): Unit {
    when(view.id) {
    }
  }

  fun onClickRecyclerRowRutina(
    view: View,
    position: Int,
    item: RowRutinasModel
  ): Unit {
    when(view.id) {
    }
  }

  companion object {
    const val TAG: String = "ALARMAS_Y_RUTINAS_ACTIVITY"

  }
}
