package com.stylish.text.whatsapp.qoutesapp.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.stylish.text.whatsapp.qoutesapp.R
import com.stylish.text.whatsapp.qoutesapp.model.Qoute


@Preview
@Composable
fun QouteListItem(qoute: Qoute, onClick : (quote: Qoute)-> Unit)
{
    Card(elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier.padding(8.dp).fillMaxWidth().clickable {
                    onClick(qoute)
        }
    ) {


        Row(modifier = Modifier.padding(16.dp), ) {

            Image(alignment = Alignment.TopStart,
                modifier = Modifier.size(40.dp),
                imageVector = Icons.Filled.Face ,
                colorFilter = ColorFilter.tint(Color.Black),
                contentDescription = "Qoute")

            Spacer(modifier = Modifier.width(8.dp))

            Column {

                Text(text = qoute.quote,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(0.dp,0.dp,0.dp,8.dp))
                Box(modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(1.dp)
                    .background(Color.Gray),
                    ) {

                }
                Text(text = qoute.author, fontWeight = FontWeight.Thin,
                    fontStyle = FontStyle.Italic,
                    style = MaterialTheme.typography.bodySmall)
                
            }



        }


    }

}

