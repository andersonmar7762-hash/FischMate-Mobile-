package com.fischmate.mobile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private var running = false
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bg = 0xFF100B18.toInt()
        val purple = 0xFFA855F7.toInt()
        val white = 0xFFF7F2FF.toInt()
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(28, 36, 28, 36)
            setBackgroundColor(bg)
        }
        val title = TextView(this).apply {
            text = "FISCHMATE MOBILE"
            textSize = 27f
            setTextColor(white)
            gravity = Gravity.CENTER
        }
        val subtitle = TextView(this).apply {
            text = "ASSISTENTE DE PESCA PARA ANDROID"
            textSize = 12f
            setTextColor(0xFFC4A5FD.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 8, 0, 28)
        }
        status = TextView(this).apply {
            text = "STATUS: PRONTO"
            textSize = 16f
            setTextColor(0xFF86EFAC.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 12, 0, 24)
        }
        val start = Button(this).apply {
            text = "START"
            setTextColor(white)
            setBackgroundColor(purple)
            setOnClickListener {
                running = true
                status.text = "STATUS: SOLICITANDO SERVIÇO"
                status.setTextColor(0xFFFDE68A.toInt())
                startActivity(Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS))
            }
        }
        val stop = Button(this).apply {
            text = "STOP"
            setOnClickListener {
                running = false
                FishingAccessibilityService.stopAutomation()
                status.text = "STATUS: PARADO"
                status.setTextColor(0xFFFCA5A5.toInt())
            }
        }
        val note = TextView(this).apply {
            text = "Protótipo inicial. A detecção visual do minijogo e o ciclo de pesca ainda precisam ser adaptados e testados no seu aparelho. Nenhum toque automático é executado nesta versão."
            textSize = 13f
            setTextColor(0xFFD6D3D1.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 28, 0, 0)
        }
        listOf(title, subtitle, status, start, stop, note).forEach { view ->
            root.addView(view, LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT).apply {
                bottomMargin = 12
            })
        }
        setContentView(root)
    }
}
