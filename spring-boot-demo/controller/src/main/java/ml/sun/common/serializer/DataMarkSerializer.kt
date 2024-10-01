package ml.sun.common.serializer

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.BeanProperty
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.ser.ContextualSerializer
import ml.sun.common.annotation.DataMark
import ml.sun.common.enums.DataMarkType

class DataMarkSerializer : JsonSerializer<String>(), ContextualSerializer {
    private lateinit var type: DataMarkType
    private var startIndex: Int = 0
    private var endIndex: Int = 0

    fun set(type: DataMarkType, startIndex: Int, endIndex: Int) {
        this.type = type
        this.startIndex = startIndex
        this.endIndex = endIndex
    }

    override fun serialize(text: String, generator: JsonGenerator, provider: SerializerProvider) {
        generator.writeString(type.func(text, startIndex, endIndex))
    }

    /**
     * 检查是否有 DataMark 注解，数据类型是否为 String
     */
    override fun createContextual(provider: SerializerProvider, property: BeanProperty?): JsonSerializer<*> {
        // 判断是否为 String 类型
        if (property?.type?.rawClass == String::class.java) {
            // 获取自定义注解
            var annotation = property.getAnnotation(DataMark::class.java)
            if (annotation == null) {
                annotation = property.getContextAnnotation(DataMark::class.java)
            }
            // 标注数据脱敏
            return if (annotation != null) {
                val serializer = DataMarkSerializer()
                serializer.set(annotation.type, annotation.startIndex, annotation.endIndex)
                serializer
            } else {
                provider.findValueSerializer(property.type, property)
            }
        }
        // 默认序列化器
        return provider.findNullValueSerializer(property)
    }
}