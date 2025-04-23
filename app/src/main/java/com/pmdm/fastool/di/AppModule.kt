package com.pmdm.fastool.di

import com.google.gson.GsonBuilder
import com.pmdm.fastool.data.RepairRepository
import com.pmdm.fastool.data.services.RepairService
import com.pmdm.fastool.data.services.RepairServiceImplementation
import com.pmdm.fastool.data.services.ZonedDateTimeAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.time.ZonedDateTime
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepairRepository(
        repairService: RepairServiceImplementation  // Ahora usamos RepairService en lugar de RepairDaoMock
    ): RepairRepository = RepairRepository(repairService)

    @Provides
    @Singleton
    fun provideOkHttpClient() : OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.HEADERS

        val timeout = 10L
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .writeTimeout(timeout, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        val gson = GsonBuilder()
            .registerTypeAdapter(ZonedDateTime::class.java, ZonedDateTimeAdapter())
            .create()

        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("http://10.0.2.2:8080/fasttool/datos/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideRepairService(
        retrofit: Retrofit
    ) : RepairService = retrofit.create(RepairService::class.java)




}
