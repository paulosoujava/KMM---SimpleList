package com.paulo.simplelist.model

import kotlinx.serialization.Serializable

@Serializable
data class CategoryModel(
    val id: Int,
    val name: String,
    val image: String
)