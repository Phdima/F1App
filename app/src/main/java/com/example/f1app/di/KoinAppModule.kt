package com.example.f1app.di

import com.example.f1app.data.network.MoshiBuilder
import com.example.f1app.data.network.RetrofitBuilder
import com.example.f1app.data.network.api.OpenF1ApiService
import com.example.f1app.data.repository.DriversRepoImpl
import com.example.f1app.domain.repository.DriversRepo
import com.example.f1app.presentation.viewmodels.DriversVM
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val dataModule = module {
    single { MoshiBuilder.build() }
    single { RetrofitBuilder.build(get(), "https://api.openf1.org/v1") }
    single { get<Retrofit>().create(OpenF1ApiService::class.java) }
    single<DriversRepo> { DriversRepoImpl(get()) }
}

val presentationModule = module {
    viewModel { DriversVM(get()) }
}