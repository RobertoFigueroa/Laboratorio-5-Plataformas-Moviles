package com.example.rober.laboratorio3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_send_mail.*


class SendMail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_mail)

        val telefono = intent.getStringExtra("tel")
        val correo = intent.getStringExtra("mail")



    }
    fun enviar(view : View){
        val editText = findViewById<EditText>(R.id.para)
        val destiny = editText.text.toString()
        val emailIntent = Intent(Intent.ACTION_SEND)
        Snackbar.make(view, "Enviado de ${intent.getStringExtra("tel")} hacia $destiny", Snackbar.LENGTH_LONG).show()
    }
}
