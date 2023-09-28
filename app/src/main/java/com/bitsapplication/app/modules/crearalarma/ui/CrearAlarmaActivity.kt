package com.bitsapplication.app.modules.crearalarma.ui


import android.os.Bundle
import com.bitsapplication.app.R
import com.bitsapplication.app.appcomponents.base.BaseActivity

import com.bitsapplication.app.databinding.ActivityCrearAlarmaBinding
import java.util.Date
import kotlin.Int
import kotlin.String
import kotlin.Unit

class CrearAlarmaActivity : BaseActivity<ActivityCrearAlarmaBinding>(R.layout.activity_crear_alarma)
    {


  private val REQUEST_CODE_FRAME_NUEVA_TAREA_ACTIVITY: Int = 532

      override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      }
  override fun onInitialized(): Unit {

  }

  override fun setUpClicks(): Unit {
    binding.tobBarCrearAlarma.setNavigationOnClickListener( {finish()})
  }

    private fun onDateSelectedLinearStatelayer2(selectedDate: Date) {
    }

    companion object {
      const val TAG: String = "CREAR_ALARMA_ACTIVITY"

    }
  }
