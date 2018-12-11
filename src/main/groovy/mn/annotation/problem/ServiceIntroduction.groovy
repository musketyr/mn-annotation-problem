package mn.annotation.problem

import groovy.util.logging.Slf4j
import io.micronaut.aop.MethodInterceptor
import io.micronaut.aop.MethodInvocationContext
import io.micronaut.core.annotation.AnnotationValue

import javax.inject.Singleton
import java.util.concurrent.Callable

@Slf4j
@Singleton
class ServiceIntroduction implements MethodInterceptor<Object, Object> {

    @Override
    Object intercept(MethodInvocationContext<Object, Object> context) {
        AnnotationValue<Anno> annotation = context.getAnnotation(Anno.class)
        log.info("Annotation: $annotation")
        log.info("Annotation from target method: ${context.targetMethod.getAnnotation(Anno.class)}")
        if (annotation != null) {
            try {
                Class<Callable> type = annotation.getRequiredValue(Class.class)
                return type.newInstance().call()
            } catch (Exception e) {
                return e.toString()
            }
        }
        return "annotation not found"
    }
}
