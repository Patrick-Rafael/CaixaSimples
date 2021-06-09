package com.example.cs.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cs.ui.ExampleItem
import com.google.firebase.database.FirebaseDatabase
import java.lang.Exception

class ItemViewModel: ViewModel() {

    private val dbitens = FirebaseDatabase.getInstance().getReference(NODE_ITEM)

    private val _result = MutableLiveData<Exception?>()
    val result: LiveData<Exception?> get() = _result

    private val _exampleItem = MutableLiveData<ExampleItem>()
    val exampleItem: LiveData<ExampleItem> get() = _exampleItem

    fun addItem(exampleItem: ExampleItem) {
        exampleItem.id = dbitens.push().key

        dbitens.child(exampleItem.id!!).setValue(exampleItem).addOnCompleteListener {
            if (it.isSuccessful) {
                _result.value = null
            } else {
                _result.value = it.exception
            }

        }
    }

}

