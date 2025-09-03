package com.example.f1app.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

object MoshiBuilder {

    fun build(): Moshi {

        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }
}