package utilities;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.HepsiburadaTest;


public class Log {

    private static Logger log= LoggerFactory.getLogger(Log.class.getName());


    public static void startTestCase(String sTestCaseName){

        log.info("******************         "+sTestCaseName+"         ******************");


        HepsiburadaTest.extentTest = HepsiburadaTest.extentReports.createTest(sTestCaseName);



    }
    public static void endTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+"         ******************");

        HepsiburadaTest.extentTest.info(sTestCaseName);
    }


    public static void assertLog(String msg) {

        log.info(msg);
        HepsiburadaTest.extentTest.pass(msg);

    }


    public static void debug(String message)
    {
        log.debug(message);
        HepsiburadaTest.extentTest.debug(message);

    }


    public static void error(String message) {
        log.error(message);
        HepsiburadaTest.extentTest.error(message);

    }

    public static void info(String message) {

        log.info(message);
        HepsiburadaTest.extentTest.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
        HepsiburadaTest.extentTest.warning(message);

    }


}