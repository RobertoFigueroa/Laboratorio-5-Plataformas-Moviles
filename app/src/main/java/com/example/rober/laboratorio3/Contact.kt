package com.example.rober.laboratorio3

import android.app.Application

class Contact : Application() {

    companion object {

        private var contacts : ArrayList<ContactObject> = ArrayList()

        fun add(element : ContactObject) {
            this.contacts.add(element)
        }

        fun getItem(index : Int): String {
            return this.contacts[index].getInfo()
        }
        fun getList() : ArrayList<String> {
            var values : ArrayList<String> = ArrayList()
            for(item in contacts){
                values.add(item.toString())
            }
            return values
        }

    }
}