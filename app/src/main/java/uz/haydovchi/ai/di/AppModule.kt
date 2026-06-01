package uz.haydovchi.ai.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // TODO: Provide Retrofit, Room, DataStore, Location services etc. here

    @Provides
    @Singleton
    fun provideApplicationContext(@dagger.hilt.android.qualifiers.ApplicationContext context: android.content.Context): android.content.Context {
        return context
    }
}