package mn.annotation.problem;

import java.lang.annotation.*;
import java.util.concurrent.Callable;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
public @interface Anno {
    Class<Callable> value();
}
