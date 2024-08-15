package com.stylish.text.whatsapp.qoutesapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.stylish.text.whatsapp.qoutesapp.model.Qoute

@Preview
@Composable
fun QouteList(data : Array<Qoute>, onClick : (quote: Qoute)->Unit) {

    LazyColumn {
        itemsIndexed(data){
            index, item ->
            QouteListItem(qoute = item, onClick)
        }
    }

}