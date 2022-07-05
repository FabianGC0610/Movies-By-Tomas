package com.backbase.moviesbythomas.di.modules

import com.backbase.moviesbythomas.ui.home.MoviesViewModel
import com.backbase.moviesbythomas.usecase.MostPopularMoviesUseCase
import com.backbase.moviesbythomas.usecase.NowPlayingMoviesUseCase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val moviesModule: Module = module {
    viewModel { MoviesViewModel(get(), get()) }
    single { NowPlayingMoviesUseCase() }
    single { MostPopularMoviesUseCase() }
}