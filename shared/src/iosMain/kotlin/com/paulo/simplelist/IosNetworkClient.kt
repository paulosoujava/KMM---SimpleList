package com.paulo.simplelist

import io.ktor.client.*
import io.ktor.client.engine.darwin.*


actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Darwin) {
    config(this)

    engine {
        configureRequest {
            setAllowsCellularAccess(true)
        }
    }
}