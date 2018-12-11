package mn.annotation.problem

import io.micronaut.context.ApplicationContext
import spock.lang.Specification

class ServiceIntroductionSpec extends Specification {

    void 'annotation is found'() {
        when:
            ApplicationContext context = ApplicationContext.run()
            SomeService service = context.getBean(SomeService)
        then:
            service
            service.readAnno() == "Hello"
    }

}

@Service interface SomeService {

    @Anno({ "Hello" }) String readAnno()

}
