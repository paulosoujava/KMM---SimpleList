package com.paulo.simplelist.usecase

import com.paulo.simplelist.model.ProductModel
import com.paulo.simplelist.networkClient
import io.ktor.client.call.*
import io.ktor.client.request.*

class GetProductsUseCase: BaseUseCase<Unit, List<ProductModel>>() {
    override suspend fun execute(request: Unit): List<ProductModel> {
        val response = networkClient.get("https://api.escuelajs.co/api/v1/products")
        return response.body()
    }
}