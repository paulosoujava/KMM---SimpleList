package com.paulo.simplelist.android.screen

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.paulo.simplelist.android.components.ProductItemView
import com.paulo.simplelist.model.ProductModel
import com.paulo.simplelist.usecase.GetProductsUseCase

@Composable
fun ProductListView() {
    val scope = rememberCoroutineScope()
    var products by remember {
        mutableStateOf(emptyList<ProductModel>())
    }

    LaunchedEffect(true) {
        scope.runCatching {
            GetProductsUseCase().execute(Unit)
        }.onSuccess { remoteProducts ->
            products = remoteProducts
        }.onFailure {
            Log.d("Failed", "Network error")
        }
    }

    Scaffold(topBar = {
        TopAppBar {
            Row(modifier = Modifier.padding(10.dp)) {
                Text(text = "Products")
            }
        }
    }) { defaultPadding ->
        LazyColumn(modifier = Modifier.padding(defaultPadding)) {
            items(products) { product ->
                ProductItemView(product)
            }
        }
    }
}
