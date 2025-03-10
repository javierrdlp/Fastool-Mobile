package com.pmdm.fastool.data

import com.pmdm.fastool.data.mocks.RepDaoMock

class RepRepository {
    val proveedorRep = RepDaoMock()

    fun get() = proveedorRep.get().toRep()
    fun get(id: Int) = proveedorRep.get(id)
    fun get(matricula: String) = proveedorRep.get(matricula).toRep()
}