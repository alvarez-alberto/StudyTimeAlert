package com.bitsapplication.app.modules.alarmasyrutinas.`data`.model

import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.di.MyApp
import kotlin.String

data class AlarmasYRutinasModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHeadline: String? = MyApp.getInstance().resources.getString(R.string.lbl_alarmas)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtExtendedTOPBA: String? = MyApp.getInstance().resources.getString(R.string.lbl_rutinas)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeader: String? = MyApp.getInstance().resources.getString(R.string.lbl_arquitectura)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtHeaderOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_pruebas)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var etCardRutinaValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etAlgebraCounterValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etCardRutinaOneValue: String? = null,
  /**
   * TODO Replace with dynamic value
   */
  var etCardRutinaTwoValue: String? = null
)
