package com.pmdm.fastool.di

import com.pmdm.fastool.data.RepairRepository
import com.pmdm.fastool.data.mocks.RepairDaoMock
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepairDaoMock(): RepairDaoMock = RepairDaoMock()

    @Provides
    @Singleton
    fun provideRepairRepository(
        repairDaoMock: RepairDaoMock
    ): RepairRepository = RepairRepository(repairDaoMock)

}