package com.paulo.simplelist.android.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.paulo.simplelist.model.ProductModel


@Composable
fun ProductItemView(product: ProductModel) {
    Column(modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = product.title,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Text(
                text = "$ ${product.price}",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = product.description,
            maxLines = 3,
            overflow = TextOverflow.Clip,
            style = TextStyle(fontSize = 16.sp, color = Color.Gray)
        )

        AsyncImage(
            model = product.images.first(),
            contentDescription = null,
            modifier = Modifier
                .padding(vertical = 10.dp)
                .height(200.dp)
                .clip(RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillWidth
        )
    }
}