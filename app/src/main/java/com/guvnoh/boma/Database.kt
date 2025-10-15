package com.guvnoh.boma

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

val database: FirebaseDatabase = FirebaseDatabase.getInstance()
val boma: DatabaseReference = database.reference.child("Boma")
val databasePrices : DatabaseReference = boma.child("BOMAPrices")
val bomaRecords: DatabaseReference = boma.child("BomaRecords")
val stockFulls = boma.child("Stock").child("fulls ")