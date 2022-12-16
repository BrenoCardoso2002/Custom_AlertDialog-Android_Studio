package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pega o botão da tela principa, faz o envento de click nele e chama a função que chama a AlertDialog.
        findViewById<Button>(R.id.button).setOnClickListener {
            chamarAlertDialog()
        }
    }

    // Função que chama a alertDialog:
    private fun chamarAlertDialog(){
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.alert_dialog, null)
        val mBuilder = AlertDialog.Builder(this,  R.style.CustomDialog)
            .setView(mDialogView)
            .setCancelable(false) // aqui bloqueia que a alertDialog seja fechada pelo usuário clicando fora.
        val mAlertDialog = mBuilder.show()
        // Esse trecho faz com que a alertDialog feche automaticamente após 10 segundos.
        val tempo = Timer()
        tempo.schedule(object : TimerTask() {
            override fun run() {
                mAlertDialog.dismiss()
                tempo.cancel()
            }
        }, 10000)
    }
}