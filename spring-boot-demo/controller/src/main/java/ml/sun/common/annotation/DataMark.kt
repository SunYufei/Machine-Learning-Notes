package ml.sun.common.annotation

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ml.sun.common.enums.DataMarkType
import ml.sun.common.serializer.DataMarkSerializer

@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
@JsonSerialize(using = DataMarkSerializer::class)
@JacksonAnnotationsInside
annotation class DataMark(
    val type: DataMarkType = DataMarkType.DEFAULT,
    val startIndex: Int = 0,
    val endIndex: Int = 0
)
