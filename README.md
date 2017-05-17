# Exchange-Rate-Service
A simple foreign exchange rate RESTful service. It uses data provided by the European Central Bank. Provides a simple REST API endpoint to get the conversion rate for Euro to any other currency provided by ECB for any of the past 90 days. The service is implemented in the Spring Framework 4.

=== Building and running the application
For building this project you will need Maven 3.x and Java 8 installed on your computer.
After downloading or cloning the project you can build it in two ways:

1. Use your favourite IDE (e.g. Eclipse) and import it as an existing Maven project. Then build the project (the default setting of the IDE is automatic build after importing).

2. In the command line (or shell), go to the directory where the pom.xml file of the project resides. Then type

mvn build

If you want to run the application, type

java -jar target\exchange-rate-service-1.0-SNAPSHOT.jar




