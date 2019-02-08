package com.example.rober.laboratorio3

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_ver_contacto.*
import android.content.pm.PackageManager
import android.Manifest.permission
import android.Manifest.permission.CALL_PHONE
import android.net.Uri
import android.support.v4.app.ActivityCompat



class ViewContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_contacto)

        //Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra("EXTRA_INFO")
        //separar la cadena de caracteres con la informacion del contacto para deplegarla en la actividad adecuadamente
       val indxname = message.indexOf("-")
        val name = message.subSequence(0,indxname).toString()
        val indxmail = message.indexOf("+")
        val tel  = message.subSequence((indxname+1),(indxmail) ).toString()
        val mail = message.subSequence(indxmail+1,message.length).toString()
        val dummy = listOf(name,tel,mail)
        val contac = ArrayAdapter<CharSequence>(this, android.R.layout.simple_list_item_1, dummy)
        lista.adapter = contac

        lista.setOnItemClickListener { parent, view, position, id ->
            if(position == 1){
                val callIntent = Intent(Intent.ACTION_DIAL)
                callIntent.data = Uri.parse("tel:$tel")
                if (ActivityCompat.checkSelfPermission(this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                }
                startActivity(callIntent)

            }
            if(position == 2){
                val mIntent = Intent(this,SendMail::class.java)
                mIntent.putExtra("tel",tel)
                mIntent.putExtra("mail",mail)
                startActivity(mIntent)
            }

        }


    }

    fun back(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}
