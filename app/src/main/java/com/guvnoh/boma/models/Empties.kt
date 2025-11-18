package com.guvnoh.boma.models

data class Empties (
    val company: EmptyCompany? = null,
    var emptyType: EmptyType? = null
)

enum class EmptyCompany{
    COCA_COLA,
    HERO,
    NBL,
    GUINNESS,
}

enum class EmptyType{
    TWENTY,
    TWELVE,
    TWENTY_FOUR,
    EIGHTEEN,
    SIX
}