package com.pd.testfeature.compose.elements

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ProductItem(
    image: () -> String,
    name: () -> String,
    price: () -> String,
    rating: () -> String,
) {
    val context = LocalContext.current
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .padding(8.dp),
                model = ImageRequest.Builder(context).data(image()).diskCacheKey(image()).build(),
                contentDescription = ""
            )

            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(4.dp),
                text = name(),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(4.dp),
                text = "Price: ${price()}",
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(4.dp),
                text = "Rating: ${rating()}",
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}