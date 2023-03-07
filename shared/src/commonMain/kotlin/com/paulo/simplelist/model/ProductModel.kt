package com.paulo.simplelist.model

import kotlinx.serialization.Serializable


@Serializable
data class ProductModel(
    val id: Int,
    val title: String,
    val price: Int,
    val description: String,
    val images: List<String>,
    val category: CategoryModel
)