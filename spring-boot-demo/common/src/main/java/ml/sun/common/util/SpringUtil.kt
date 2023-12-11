package ml.sun.common.util

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component
import kotlin.reflect.KClass

@Component
object SpringUtil : ApplicationContextAware {
    private lateinit var applicationContext: ApplicationContext

    fun <T : Any> getBean(requiredType: KClass<T>): T = applicationContext.getBean(requiredType.java)

    override fun setApplicationContext(applicationContext: ApplicationContext) {
        this.applicationContext = applicationContext
    }
}