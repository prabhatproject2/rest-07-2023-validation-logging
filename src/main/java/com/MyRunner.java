package com;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication

public class MyRunner {
	
	private static final Logger logger=LoggerFactory.getLogger(MyRunner.class);

	public static void main(String[] args) {
		
		SpringApplication.run(MyRunner.class, args);
		
		logger.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
		logger.trace("A TRACE Message..Very detailed and low-level information");
        logger.debug("A DEBUG Message...Detailed information for debugging purposes..monitor variable values");
        logger.info("Default level..General information..generally for production");
        logger.warn("A WARN Message..Used for situations that might require attention ");
        logger.error("An ERROR Message,Represents errors that might still allow the application to continue running");
		
		
		
	}

}
