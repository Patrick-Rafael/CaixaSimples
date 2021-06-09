package com.example.cs.ui

import com.google.firebase.database.Exclude

data class ExampleItem(

    var id: String? = null,
    var produto: String? = null,
    var valorUnitario: Int? = null,
    var quantidade: String? = null,
    var cliente: String? = null,
    var dia: String? = null,
    var mes: String? = null,
    var ano: String? = null,
    var alternativa: String? = null,
    var isDeleted: Boolean? = null


) {}



