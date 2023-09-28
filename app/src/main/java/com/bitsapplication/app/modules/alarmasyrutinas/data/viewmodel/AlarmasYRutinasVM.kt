package com.bitsapplication.app.modules.alarmasyrutinas.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bitsapplication.app.modules.alarmasyrutinas.`data`.model.AlarmasYRutinasModel
import com.bitsapplication.app.modules.alarmasyrutinas.`data`.model.GridtitleRowModel
import com.bitsapplication.app.modules.alarmasyrutinas.data.model.RowRutinasModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class AlarmasYRutinasVM : ViewModel(), KoinComponent {
  val alarmasYRutinasModel: MutableLiveData<AlarmasYRutinasModel> =
      MutableLiveData(AlarmasYRutinasModel())

  var navArguments: Bundle? = null

  val gridtitleList: MutableLiveData<MutableList<GridtitleRowModel>> =
      MutableLiveData(mutableListOf())



val rowRutinasList: MutableLiveData<MutableList<RowRutinasModel>> =
    MutableLiveData(mutableListOf())
}
