package com.bitsapplication.app.modules.alarmasyrutinas.`data`.model

import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class GridtitleRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtTitle: String? = MyApp.getInstance().resources.getString(R.string.lbl_tarea)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtTime: String? = MyApp.getInstance().resources.getString(R.string.lbl_09_00am)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.msg_d_l_m_m_j)

)
