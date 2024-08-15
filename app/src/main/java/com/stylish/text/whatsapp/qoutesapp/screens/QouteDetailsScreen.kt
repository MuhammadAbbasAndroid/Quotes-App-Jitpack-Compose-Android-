package com.stylish.text.whatsapp.qoutesapp.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stylish.text.whatsapp.qoutesapp.DataManager
import com.stylish.text.whatsapp.qoutesapp.model.Qoute


@Preview
@Composable
fun QouteDetails(qoute: Qoute) {

    BackHandler {
        DataManager.switchPages(null)
    }


    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color.White,
                        Color.Gray
                    )
                )
            )){
        Card(elevation = CardDefaults.cardElevation(3.dp),
            modifier = Modifier.padding(32.dp)) {

            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(16.dp)) {

                Image(imageVector = Icons.Filled.Face,
                    contentDescription = "Qoutes",
                    modifier = Modifier.size(80.dp)

                )

                Text(text = qoute.quote,
                    style = MaterialTheme.typography.headlineSmall)

                Spacer(modifier = Modifier.height(5.dp))

                Text(text = qoute.author, fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodySmall )


            }

        }

    }

}