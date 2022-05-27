package id.ac.umn.app.a006

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent :: class)
class Module {
    @Singleton
    @Provides
    fun provideTestString()="Testing string dengan hilt"
}