package com.guvnoh.boma.database


import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

object FirebaseRefs {

    private val db = FirebaseDatabase.getInstance()

    //database root folder
    private val root: DatabaseReference = db.reference.child("Boma")
    val bomaRoot = root.child("BomaStock")

    val warehouseFulls = bomaRoot.child("Warehouse").child("Fulls")
    val warehouseEmpties = bomaRoot.child("Warehouse").child("Empties")

    val HeadOfficeFulls = bomaRoot.child("HeadOffice").child("Fulls")
    val HeadOfficeEmpties = bomaRoot.child("HeadOffice").child("Empties")

    val fullStock = root.child("BomaStock").child("Stock_Fulls")
    val empties = root.child("BomaStock").child("Empties")
    val records = root.child("BomaDBRecords2")
    val appMeta = root.child("appMeta")
}
