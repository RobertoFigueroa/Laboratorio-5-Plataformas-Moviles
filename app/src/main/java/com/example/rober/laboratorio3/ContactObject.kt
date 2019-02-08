package com.example.rober.laboratorio3

import com.example.rober.laboratorio3.R.id.mail
import com.example.rober.laboratorio3.R.id.phone
import java.lang.reflect.Constructor


class ContactObject {
    private var name = ""
    private var phone = ""
    private var mail = ""


    constructor(name: String, phone: String, mail: String) {
        this.name = name
        this.phone = phone
        this.mail = mail
    }

    override fun toString(): String {
        return "$name - $phone"
    }

    fun getInfo() : String {
        return "$name - $phone + $mail"
    }


}