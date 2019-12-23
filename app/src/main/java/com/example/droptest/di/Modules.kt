package com.example.droptest.di

import com.example.droptest.repository.ApiInitializer
import com.example.droptest.repository.Repository
import com.example.droptest.view.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        MainViewModel(get())
    }
}

val repositoryModule = module {
    single { Repository() }
}

val networkModule = module {
    single { ApiInitializer }
}