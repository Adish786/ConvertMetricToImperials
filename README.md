The brief of the assignment was outlined as follows:

Technical test instructions:    
 
    1. Create a Spring Boot application using rest API’s to do a conversions.
 
    2. Convert Metric to imperial and vice versa. The API must cater for at least 3 conversions (include temperature conversion please).
 
    3. Ensure that you have proper Unit and Integration testing that accompany the project.
 
    4. Postman/Jmeter project with your RestAPI's.
 
    5. Upload your project into your own GIT repository and share the project with us.
 
    6. The project must be able to run in its own Docker environment
 
    7. Build system must use Maven.
    
Tech Stack
As per the brief, a Spring Boot application has been created using Maven for dependency management and as the build tool.

Unit tests are implemented using JUnit5 with Mockito for unit tests, and a short-lived Spring Boot Test instance being spun up to facilitate integration testing by triggering all predefined endpoints.

The application has also been containerized by means of a Dockerfile located in the base directory. The image can be built from the root directory (demo) using the docker build . command and specifying a tag of your choice. The image can then be spun up using docker run < your_tagged_image > and will be exposed on port 9191 as per the Dockerfile. Alternatively you may use Docker Desktop to manage images and containers once the image is built and tagged.

A Postman collection has been specified which can be used to trigger all predefined endpoints. The file Imperial Collection API-convertor.json may be imported into Postman for testing purposes and includes two error test cases to highlight the functionality to first time users.

Solution
As per the requirements, a solution was designed that exposed a single REST API with multiple conversions between two known systems, namely metric and imperial.

The application makes use of the Convertor interface which specifies all convertors must be able to convert both to imperial and to metric. Each of the available services implement this interface and contains formulas to conduct conversions.

All endpoints trigger the convertor method on ConvertorService.java which will then by means of the ConvertorFactory.java injects the appropriate implementation of the Convertor.java interface. The endpoint allows a user (by means of triggering a single endpoint) to convert to metric, or to imperial, by specifying the desired system to convert into, as a path variable on the URL.

Further to this, the user may use the same endpoint to trigger conversions between different types of measurements by specifying the type on a different path variable. There are, as mentioned below, 5 units of measurement that may be specified on the endpoint.

The measurements selected were:

Temperature - allowing conversions between Fahrenheit and Celsius (and vice-versa)
Area - allowing conversions between Acre and Hectare (and vice-versa)
Length - allowing conversions between Mile and Kilometer (and vice-versa)
Volume - allowing conversions between Gallon and Litre (and vice-versa)
Weight - allowing conversions between Pound and Kilogram (and vice-versa)
Should a user specify an unknown system or unknown measurement, the API will respond accordingly with an appropriate error response code as well as an error message defining the issue and what are the possible solutions.

An example would be as follows: http://localhost:9191/convert/temperature/imperial/33.2 where temperature would be a known measurement, 33.2 degrees celsius would be the value to convert and imperial would be the system to convert the value into.

Considerations
I had played around with the idea of each service (where applicable) being able to convert between multiple different units of measure. For example, being able to convert Weight from Imperial Pounds to Metric grams, as well as Metric Kilograms etc. This can be implemented by extending the Convertor to allow units to be specified and thereafter trigger the appropriate conversion.

I had considered implementing in this manner, but it seemed to be overkill for the brief and decided instead to opt for a simplified solution to cater to just one unit of measurement per conversion.

Note :- Use the latest Angular to create a front end for your project. (Only if you have time)

Docker :- 
Step 1 :- Build the maven project run the command // clean compile install

Step 2 :- check the docker are install your local system and check the version // docker --version

step 3 :- Build the docker project using  the run command with local system // docker build -t convertmetrictoimperial .

step 4:- Check the docker image using the command // docker image ls 

step 5 :- Run the Dokcer Project using the command with image id and port number  //docker run -p 9191:9191 convertmetrictoimperial
