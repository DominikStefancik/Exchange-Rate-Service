# Exchange-Rate-Service
A simple foreign exchange rate RESTful service. It uses data provided by the European Central Bank. Provides simple REST API endpoints to get the conversion rate for Euro to any other currency provided by ECB for any of the past 90 days. The service is implemented in the Spring 4 Framework.


### Building and running the application
For building this project you will need Maven 3.x and Java 8 installed on your computer.
After downloading or cloning the project you can build it in two ways:

* Use your favourite IDE (e.g. Eclipse) and import it as an existing Maven project. Then build the project (the default setting of the IDE is automatic build after importing). Then run the project from the IDE.

or 

* In the command line (or shell), go to the directory where the pom.xml file of the project resides. Then type
      
      mvn install

  If you want to run the application, type

      java -jar target\exchange-rate-service-1.0-SNAPSHOT.jar


### Usage of the application
After you built and run the application a local server is started on 

      http://localhost:8080
      
The server provides three REST API end points:

* /currencies
  
  Returns lists of currencies and their rates towards EURO for 90 days back
  
* /currencies/{date}
  
  Returns a list of currencies and their rates towards EURO for a particular date. The {date} parameter has to have the format
  'yyyy-mm-dd' (e.g. 2017-05-10)
  
* /currencies/{date}/{currency}
  
  Returns a currency and its rate towards EURO for a particular date. The {date} parameter has to have the format
  'yyyy-mm-dd' (e.g. 2017-05-10). The {currency} parameter has to be a string with exactly three letters, all in capital (e.g. USD)  
  
  
#### Note
To run the application properly and get the currency data from the European Central Bank, you must be connected to the internet.

