import org.apache.log4j.Logger;

public class Test_Log4j {

	public static void main(String[] args) {
		Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
		APPLICATION_LOGS.debug("Starting");
		APPLICATION_LOGS.debug("Executing");
		APPLICATION_LOGS.debug("Ending");
	}

}
