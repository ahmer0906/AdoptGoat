# AdoptGoat
## Test Scenarios

   under the src/test/java package its contain the two classes AdoptionConfirmation_page.java and AdoptorDetais_page.java
   which covers both scenarios Happy and negative path. I have explained the framework and its execution below, Before you execute the framework it is important to change the application path in the configuration folder which has the configuration property file, make sure that it points to the local system.

# Framework
####Test Data, Excel Data & Config Data - 
    These files holds data for various purposes which includes Test data, configuration data
####Data Provider - 
    This module deals with interaction between above mentioned files.
####Browser Factory - 
    This holds responsibility for Browser Instantiation.
####Utility - 
    This provides various utilities which are mostly used up by page and test classes like JavaScript Executor functions,         Reusable actions
###Page Classes - 
    These classes hold application page related functions and corresponding object properties
####Test Script - 
    These are actual test scenarios which coordinates with Utility, Browser Factory and  Page Classes. These contain classes which hold the actual test automation flow.
####TestNG.xml - 
    This xml is place where we set test suite configuration in order to manage test case executions along with few parameters.
####POM.xml - 
    It is the backbone of the whole project, as this file contains all the dependencies which are being used in whole project. This file directly communicates with Maven Repository and downloads all required dependencies for project. It basically downloads jar files.


## Way to Execute Test Scenario
Maven should be installed on Local machine
Navigate to project root folder via cmd/terminal
```sh
mvn clean install test
```

### OR

If project in imported into Eclipse then 
Right click on pom.xml -> Run as Maven -> 
```sh
Maven install
Maven test
```

## Execution Report
TestNG report has been taken as Test Execution report 
Once the execution get done, same can be fetched from 'test-output' folder as 'emailable-report.html' which can be view through Web Browser
