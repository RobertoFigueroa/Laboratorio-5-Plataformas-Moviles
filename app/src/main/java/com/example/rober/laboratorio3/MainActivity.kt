package com.example.rober.laboratorio3


import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import com.example.rober.laboratorio3.Entity.User
import com.example.rober.laboratorio3.Utilities.Utilities
import kotlinx.android.synthetic.main.activity_main.*
class MainActivity : AppCompatActivity() {

    val infoList : ArrayList<String> = ArrayList()
    val users : ArrayList<User> = ArrayList()
    val conection = ConectionDbHelper(this,"db_users",null,1)

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        consultPersonList()

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,infoList)
        contact_list.adapter = adapter

        contact_list.setOnItemClickListener { parent, view, position, id -> /*mostrar la info. del contacto al presionar*/
            val intent = Intent(this, ViewContact::class.java)
            intent.putExtra("EXTRA_INFO" , users[position].toString())
            startActivity(intent)
        }

    }
    fun addContact(view: View) {
        val intent = Intent(this, CreateContact::class.java)
        startActivity(intent)
    }

    private fun consultPersonList() {
        val db : SQLiteDatabase = conection.readableDatabase
        val user : User = User(0,"","")
        val cursor = db.rawQuery("SELECT * FROM ${Utilities.TABLE_USER}",null)

        while(cursor.moveToNext())
        {
            user.setId(cursor.getInt(0))
            user.setName(cursor.getString(1))
            user.setPhone(cursor.getString(2))
            user.setMail(cursor.getString(3))

            users.add(user)

        }

        retrieveList()
    }
    private fun retrieveList() {

        for(i in users){
            infoList.add("${i.getName()} - ${i.getPhone()}")
        }

    }



}
