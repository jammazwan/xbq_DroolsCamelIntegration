package jammazwan.xbq;

import java.util.Set;

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
		FileMaintainer fileMaintainer = (FileMaintainer)this.applicationContext.getBean("fileMaintainer");
		HoldContextOpenUntilDone.go(context);
		Set<String> globalSet = (Set<String>)fileMaintainer.getRuleSession().getGlobal("controlSet");
		assertTrue(globalSet.contains("README"));
		assertTrue(globalSet.contains("pom"));
		assertTrue(globalSet.contains("NOTES"));
		assertFalse(globalSet.contains("EXTRA"));
		assertFalse(globalSet.contains("Jenkins"));
		assertTrue(globalSet.contains("adequatelyDocumented"));
	}

}
