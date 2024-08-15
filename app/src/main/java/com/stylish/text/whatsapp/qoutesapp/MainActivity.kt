package com.stylish.text.whatsapp.qoutesapp

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.stylish.text.whatsapp.qoutesapp.screens.QouteDetails
import com.stylish.text.whatsapp.qoutesapp.screens.QouteListScreen
import com.stylish.text.whatsapp.qoutesapp.ui.theme.QoutesAppTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            DataManager.loadAssetsFromJasonFile(applicationContext)
        }
        enableEdgeToEdge()
        setContent {
            QoutesAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    App()
//                    Text(text = "hello")
                }
            }
        }
    }
}

@Composable
fun App() {
    if (DataManager.currentPage.value == Pages.Listing)
    {
        if(DataManager.isDataLoaded.value){
            QouteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }else{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Loading...", style = MaterialTheme.typography.titleMedium)
            }
        }
    }else{
        DataManager.currentQuote?.let {
            QouteDetails(qoute = it)
        }
    }
}


enum class Pages(){
    Listing, Details
}
