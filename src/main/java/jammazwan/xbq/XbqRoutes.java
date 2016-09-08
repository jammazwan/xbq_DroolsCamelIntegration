package jammazwan.xbq;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class XbqRoutes extends RouteBuilder {
	@Autowired
	FileMaintainer fileMaintainer;

	@Override
	public void configure() throws Exception {
		from("file://.?noop=true").process(new Processor() {
			public void process(Exchange exchange) throws Exception {
				String fileName = "" + exchange.getIn().getHeader("CamelFileName");
				fileMaintainer.takeInput(fileName);
				fileMaintainer.updateAndFireAllRules();
			}
		});
	}
}
