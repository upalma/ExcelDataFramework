package logforj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jStatus {
    //pre requisition:
    // 1. add log4j dependency (core and api)
    // 2. create reference logger variable in class
    // 3. create log4j.xml or log4j property files
    private static Logger logger = LogManager.getLogger(Log4jStatus.class);

    public static void main(String[] args) {
        System.out.println("\n Hello This is my log4j test \n" );

        logger.info("All information");
        logger.error("All error");
        logger.warn("All warning");
        logger.fatal("All fatal");
        System.out.println("\n Test completed");
    }
}
