package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jHandler {
        public static Logger Add_Log = null;

        public static Logger getLogger(){
            if (Add_Log == null) {
                Add_Log = Logger.getLogger("log4j");
                String partLog4J = System.getProperty("user.dir") + "//src//test//testConfig//log4j.properties";
                PropertyConfigurator.configure(partLog4J);
                Add_Log.info("Log4j initialized");
            }
            return Add_Log;
        }
}
