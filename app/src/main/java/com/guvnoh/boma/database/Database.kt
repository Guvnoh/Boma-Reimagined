package com.guvnoh.boma.database

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

val database: FirebaseDatabase = FirebaseDatabase.getInstance()

//database root folder
val DBRoot: DatabaseReference = database.reference.child("Boma")

//val DBBomaPrices : DatabaseReference = DBRoot.child("BOMAPrices")

//products
val DBBottleProducts: DatabaseReference = DBRoot.child("BottleProducts")
val DBPetsAndCans: DatabaseReference = DBRoot.child("PetsAndCans")

//records
val bomaRecords: DatabaseReference = DBRoot.child("BomaDBRecords")

//stock
val stockFulls = DBRoot.child("Stock").child("fulls ")
val stockEmpties = DBRoot.child("Stock").child("empties")