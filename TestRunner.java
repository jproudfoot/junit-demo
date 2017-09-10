import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.IOException;

public class TestRunner {
  public static void main(String[] args) {
      if(args.length == 0) {
        System.out.println("No test class supplied.");
      }
      else {

        try {
          Logger.logln("Tests for Vector");
          Logger.addMajorSectionBreak();

          //Fetch the test class
          Class testClass = Class.forName(args[0]);

          //Run the test classes
          Result result = JUnitCore.runClasses(testClass);

          /*for (Failure failure : result.getFailures()) {
             System.out.println(failure.toString());
          }*/

          logStatistics(result);
          System.out.println(Logger.log);
          
          try {
            Logger.export("vector-tests");
          } catch (IOException e) {
            System.out.print("Error while exporting log.");
          }

        } catch (ClassNotFoundException e) {
          System.out.println("Test class not found.");
        }
      }
   }

   public static void logStatistics(Result result) {
     Logger.logln("\n==================================================");
     Logger.logln("Tests run in: " + result.getRunTime() +"ms");
     Logger.logln("Tests passed: " + (result.getRunCount() - result.getFailureCount()));
     Logger.logln("Tests failed: " + result.getFailureCount());
   }
}
