package com.guvnoh.boma.models

data class Empties (
    val company: EmptyCompany = EmptyCompany.COCA_COLA,
    var noOfBottles: NoOfBottles = NoOfBottles.TWELVE

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