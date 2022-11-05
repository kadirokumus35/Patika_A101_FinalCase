package Logs;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.UyelikOlusturarakTest;
import utilities.TestBaseRapor;

public class Log extends TestBaseRapor {



    private static Logger log= LoggerFactory.getLogger(Log.class.getName());


    public static void startTestCase(String sTestCaseName){

        log.info("******************         "+sTestCaseName+" Basladi         ******************");


        UyelikOlusturarakTest.extentTest = UyelikOlusturarakTest.extentReports.createTest(sTestCaseName);



    }
    public static void endTestCase(String sTestCaseName){
        log.info("******************         "+sTestCaseName+" bitti         ******************");

        UyelikOlusturarakTest.extentTest.info(sTestCaseName);
    }


    public static void assertLog(String msg) {

        log.info(msg);
        UyelikOlusturarakTest.extentTest.pass(msg);

    }


    public static void debug(String message)
    {
        log.debug(message);
        UyelikOlusturarakTest.extentTest.debug(message);

    }


    public static void error(String message) {
        log.error(message);
        UyelikOlusturarakTest.extentTest.error(message);

    }

    public static void info(String message) {

        log.info(message);
        UyelikOlusturarakTest.extentTest.info(message);
    }

    public static void warn(String message) {
        log.warn(message);
        UyelikOlusturarakTest.extentTest.warning(message);

    }
}
