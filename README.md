# RedfinTakeHome

# Prerequisites to run the application:
Java, Apache Maven

Steps to download and install prerequisites
1. Java: <br>
Download and Install - https://java.com/en/download/help/mac_install.xml

2. Apache Maven: <br>
Download - http://maven.apache.org/download.cgi
Install - https://maven.apache.org/install.html

# Steps and commands to execute the application(on macOs)
Step 1:cd to project directory <br>
cmd:   cd RedfinTakeHome

Step 2: build program <br>
cmd:    mvn package

Step 3:Run the program <br>
cmd:   mvn -B -q install exec:java  -Dexec.mainClass="FoodTruckFinder"
