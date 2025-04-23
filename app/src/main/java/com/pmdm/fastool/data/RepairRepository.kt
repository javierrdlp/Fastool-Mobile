package com.pmdm.fastool.data

import com.pmdm.fastool.data.services.RepairServiceImplementation
import com.pmdm.fastool.models.Repair
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RepairRepository @Inject constructor(private val repairService: RepairServiceImplementation) {
    suspend fun get(): List<Repair> = withContext(Dispatchers.IO) {
        repairService.get().map { it.toRepair() }
    }
}