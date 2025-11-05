package com.guvnoh.boma.models

data class Empties (
    val company: EmptyCompany? = null,
    var noOfBottles: NoOfBottles? = null
)

enum class EmptyCompany{
    COCA_COLA,
    HERO,
    NBL,
    GUINNESS,
}

enum class NoOfBottles{
    TWENTY,
    TWELVE,
    TWENTY_FOUR,
    EIGHTEEN,
    SIX
}