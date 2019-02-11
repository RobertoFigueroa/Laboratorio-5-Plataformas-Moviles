package com.example.rober.laboratorio3

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_contact.*
import android.widget.EditText
import android.widget.Toast
import com.example.rober.laboratorio3.Utilities.Utilities
import kotlinx.android.synthetic.main.activity_create_contact.view.*


class CreateContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_contact)

        Utilities.newId()

        crear_cont.setOnClickListener { //se creara un contacto con la informacion obtenida por los cuadros de ingreso de texto

            Toast.makeText(this, "Se a creado un nuevo contacto!", Toast.LENGTH_LONG).show()

            //Ingreso de datos a la base de datos

            registerUsers()


            val intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this, "Se a creado un nuevo contacto!", Toast.LENGTH_LONG).show()
            startActivity(intent)

        }
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }

    private fun registerUsers() {
        //                                                  puede ser solo users, var utilitie
        val conection = ConectionDbHelper(this,"db_users",null,1)
        val db : SQLiteDatabase = conection.writableDatabase

        val values = ContentValues()
        values.put(Utilities.FIELD_ID,Utilities.genId)
        values.put(Utilities.FIELD_NAME,findViewById<EditText>(R.id.name).text.toString())
        values.put(Utilities.FIELD_PHONE,findViewById<EditText>(R.id.phone).text.toString())
        values.put(Utilities.FIELD_PHONE,findViewById<EditText>(R.id.mail).text.toString())

        val idResult : Long = db.insert(Utilities.TABLE_USER,Utilities.FIELD_ID,values)

        Toast.makeText(this,"ID registro : $idResult",Toast.LENGTH_LONG).show()
        db.close()

    }


}

