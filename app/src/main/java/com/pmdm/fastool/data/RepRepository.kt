package com.pmdm.fastool.data

import com.pmdm.fastool.data.mocks.RepairDaoMock

class RepRepository {
    val proveedorRep = RepairDaoMock()

    fun get() = proveedorRep.get().toRep()
    fun get(id: Int) = proveedorRep.get(id)
    fun get(matricula: String) = proveedorRep.get(matricula).toRep()
}