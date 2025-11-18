package com.guvnoh.boma.database

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

val database: FirebaseDatabase = FirebaseDatabase.getInstance()

//database root folder
val DBRoot: DatabaseReference = database.reference.child("Boma")

//records
val bomaRecords: DatabaseReference = DBRoot.child("BomaDBRecords2")

//stock
//val stockFulls = DBRoot.child("Stock").child("fulls ")

//val stockEmpties = DBRoot.child("Stock").child("empties")
val bomaStock = DBRoot.child("BomaStock")