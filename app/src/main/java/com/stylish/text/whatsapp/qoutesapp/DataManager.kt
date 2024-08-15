package com.stylish.text.whatsapp.qoutesapp

import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.stylish.text.whatsapp.qoutesapp.model.Qoute

object DataManager {


    var data = emptyArray<Qoute>()
    var isDataLoaded = mutableStateOf(false)
    var currentPage = mutableStateOf(Pages.Listing)
    var currentQuote : Qoute? = null

    fun loadAssetsFromJasonFile(context: Context)
    {
        val inputStream = context.assets.open("quotes.json")
        val size: Int = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Qoute>::class.java)
        for (x in data)
        {
            println("x is ----- ${x.quote}")
        }
        for (x in data)
        {
            println("x is ----- ${x.author}")
        }
        isDataLoaded.value = true
    }

    fun switchPages(qoute: Qoute?)
    {
        if (currentPage.value.equals(Pages.Listing))
        {
            currentQuote = qoute
            currentPage.value = Pages.Details
        }else{
            currentPage.value = Pages.Listing
        }
    }

}