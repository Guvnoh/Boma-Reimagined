package com.guvnoh.boma.database


import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseRefs {

    private val db = FirebaseDatabase.getInstance()

    //database root folder
    private val root: DatabaseReference = db.reference.child("Boma")

    val Products = root.child("testProducts")

    //val Products = root.child("Products")

    //val testProducts = root.child("testProducts")

    val bomaEmpties = root.child("Empties")

    val empties = root.child("BomaStock").child("Empties")

    val records = root.child("BomaDBRecords3")

    // stores dates and is used for new day validation
    val appMeta = root.child("appMeta")
}
