package com.example.einkaufsliste

//Data Class, die nur die Struktur der Liste repräsentiert
data class Todo (
    val title: String,
    var isChecked: Boolean = false

)