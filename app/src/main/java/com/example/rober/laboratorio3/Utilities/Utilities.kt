package com.example.rober.laboratorio3.Utilities

class Utilities {

    companion object {
        var genId : Int = 0
        //campos de la tabla
        const val TABLE_USER = "user"
        const val FIELD_ID = "id"
        const val FIELD_NAME = "name"
        const val FIELD_PHONE = "phone"
        const val FIELD_MAIL = "mail"
        //const val FIELD_PHOTO = "user"

        const val CREATE_USER_TABLE : String = "CREATE TABLE users $TABLE_USER($FIELD_ID INTEGER, $FIELD_NAME TEXT, $FIELD_PHONE TEXT, $FIELD_MAIL TEXT)"

        fun newId()  {
            this.genId += 1
        }
    }

}


