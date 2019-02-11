package com.example.rober.laboratorio3.Entity

class User {

    private  var id = 0
    private var name = ""
    private var mail = ""
    private var phone = ""
    //private foto

    constructor(id: Int, nombre: String, mail: String) {
        this.id = id
        this.name = nombre
        this.mail = mail
    }

    override fun toString(): String {
        return "$name - $phone + $mail"
    }

    fun getName(): String {
        return name
    }

    fun getMail(): String {
        return mail
    }

    fun getPhone(): String {
        return phone
    }

    fun setName(name : String)  {
        this.name = name
    }

    fun setMail(mail : String)  {
        this.mail = mail
    }

    fun setPhone(phone : String)  {
        this.phone = phone
    }
    fun setId(id : Int)  {
        this.id = id
    }

}