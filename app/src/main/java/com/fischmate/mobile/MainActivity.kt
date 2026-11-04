
package com.fischmate.mobile

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Switch
import android.widget.TextView

class MainActivity : Activity() {

    private lateinit var status: TextView
    private val toggles = mutableListOf<Switch>()

    private val bg = Color.rgb(16, 11, 24)
    private val purple = Color.rgb(168, 85, 247)
    private val white = Color.rgb(247, 242, 255)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(22.dp(), 30.dp(), 22.dp(), 24.dp())
            setBackgroundColor(bg)
        }

        val scroll = ScrollView(this)
        val content = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val title = TextView(this).apply {
            text = "FISCHMATE MOBILE"
            textSize = 27f
            setTextColor(white)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        val subtitle = TextView(this).apply {
            text = "PAINEL DE CONTROLE"
            textSize = 13f
            setTextColor(0xFFC4A5FD.toInt())
            gravity = Gravity.CENTER
            setPadding(0, 8.dp(), 0, 25.dp())
        }

        status = TextView(this).apply {
            text = "STATUS: PRONTO"
            textSize = 16f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(0xFF86EFAC.toInt())
            gravity = Gravity.CENTER
            setPadding(12.dp(), 16.dp(), 12.dp(), 16.dp())
            background = rounded(0xFF241832.toInt(), 14)
        }

        content.addView(title)
        content.addView(subtitle)
        content.addView(status, params())

        addSectionTitle(content, "CONFIGURAÇÕES")

        addToggle(content, "AUTO FISHING")
        addToggle(content, "AUTO SHAKE")
        addToggle(content, "AUTO REEL")

        val start = Button(this).apply {
            text = "INICIAR DEMONSTRAÇÃO"
            textSize = 14f
            setTextColor(white)
            background = rounded(purple, 14)
            setOnClickListener {
                status.text = "STATUS: DEMONSTRAÇÃO ATIVA"
                status.setTextColor(0xFF86EFAC.toInt())
            }
        }

        val stop = Button(this).apply {
            text = "PARAR DEMONSTRAÇÃO"
            textSize = 14f
            setTextColor(white)
            background = rounded(0xFF49304F.toInt(), 14)
            setOnClickListener {
                status.text = "STATUS: PARADO"
                status.setTextColor(0xFFFCA5A5.toInt())
            }
        }

        content.addView(start, params())
        content.addView(stop, params())

        val note = TextView(this).apply {
            text = "VERSÃO DE TESTE\n\nOs controles desta versão são apenas visuais. Nenhuma ação automática é executada no jogo."
            textSize = 12f
            setTextColor(0xFFD6D3D1.toInt())
            gravity = Gravity.CENTER
            setPadding(8.dp(), 24.dp(), 8.dp(), 16.dp())
        }

        content.addView(note)
        scroll.addView(content)

        root.addView(
            scroll,
            LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )

        setContentView(root)
    }

    private fun addSectionTitle(
        parent: LinearLayout,
        label: String
    ) {
        val title = TextView(this).apply {
            text = label
            textSize = 14f
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(0xFFC4A5FD.toInt())
            setPadding(4.dp(), 24.dp(), 4.dp(), 12.dp())
        }
        parent.addView(title)
    }

    private fun addToggle(
        parent: LinearLayout,
        label: String
    ) {
        val toggle = Switch(this).apply {
            text = label
            textSize = 14f
            setTextColor(white)
            isChecked = false
            setPadding(14.dp(), 12.dp(), 14.dp(), 12.dp())
            background = rounded(0xFF241832.toInt(), 14)
        }

        toggle.setOnCheckedChangeListener { _, checked ->
            status.text = if (checked) {
                "$label: SELECIONADO"
            } else {
                "$label: DESLIGADO"
            }
        }

        toggles.add(toggle)
        parent.addView(toggle, params())
    }

    private fun params(): LinearLayout.LayoutParams {
        return LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ).apply {
            bottomMargin = 12.dp()
        }
    }

    private fun rounded(color: Int, radius: Int): GradientDrawable {
        return GradientDrawable().apply {
            setColor(color)
            cornerRadius = radius.dp().toFloat()
        }
    }

    private fun Int.dp(): Int {
        return (this * resources.displayMetrics.density).toInt()
    }
}
