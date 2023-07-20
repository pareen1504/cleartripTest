package com.pd.testfeature.compose.elements

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
        Column {
            AsyncImage(
                modifier = Modifier.size(width = 100.dp, height = 60.dp),
                model = ImageRequest.Builder(context).data(image()),
                contentDescription = ""
            )

            Text(
                modifier = Modifier.wrapContentSize(),
                text = name(),
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = price(),
                style = MaterialTheme.typography.labelMedium
            )

            Text(
                modifier = Modifier.wrapContentSize(),
                text = rating(),
                style = MaterialTheme.typography.labelMedium
            )


        }
    }
}