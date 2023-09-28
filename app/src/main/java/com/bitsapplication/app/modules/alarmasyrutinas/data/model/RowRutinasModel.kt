package com.bitsapplication.app.modules.alarmasyrutinas.data.model

import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.di.MyApp

data class RowRutinasModel(
    /**
     * TODO Replace with dynamic value
     */
    var txtTitle: String? = MyApp.getInstance().resources.getString(R.string.lbl_tarea)
    ,

    var iconResId: Int? = R.drawable.img_clock



)
