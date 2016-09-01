package jammazwan.xbq;

import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XbqTest extends CamelSpringTestSupport {

    @Override
    protected AbstractXmlApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("META-INF/spring/camel-context.xml");
    }

    @Test
    public void testXbq() throws Exception {
        String reply = template.requestBody("direct:xbq", "No Meaning Here", String.class);
		assertEquals("My No Meaning Here", reply);
    }

}
