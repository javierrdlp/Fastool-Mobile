package com.pmdm.fastool.data.services

import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import com.google.gson.stream.JsonToken

class ZonedDateTimeAdapter : TypeAdapter<ZonedDateTime>() {
    override fun read(reader: JsonReader): ZonedDateTime? {
        return when (reader.peek()) {
            JsonToken.NULL -> {
                reader.nextNull()
                null
            }
            else -> {
                ZonedDateTime.parse(reader.nextString(), DateTimeFormatter.ISO_ZONED_DATE_TIME)
            }
        }
    }
    override fun write(out: JsonWriter?, value: ZonedDateTime?) {
        TODO("Not yet implemented")
    }
}