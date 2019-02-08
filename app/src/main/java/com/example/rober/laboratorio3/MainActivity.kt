package com.example.rober.laboratorio3


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val products = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Contact.getList())
        contact_list.adapter = products

        contact_list.setOnItemClickListener { parent, view, position, id -> /*mostrar la info. del contacto al presionar*/
            val intent = Intent(this, ViewContact::class.java)
            intent.putExtra("EXTRA_INFO" , Contact.getItem(position))
            startActivity(intent)
        }

    }
    fun addContact(view: View) {
        val intent = Intent(this, CreateContact::class.java)
        startActivity(intent)
    }
}
