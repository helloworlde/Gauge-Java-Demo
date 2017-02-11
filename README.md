# Gauge-Java-Demo
This is a project of [Gauge](http://getgauge.io) of JavaWeb and build by [Gradle](http://gradle.org). For  test database,request and page operation automation of a [SpringBoot application](https://github.com/helloworlde/SpringBoot-Demo).This application can download here.


## Running this example
The tests are run on Chrome by default.

### Prerequisites

This example requires the following softwares to run.
  * [Java 1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or above
  
  * [Gauge](http://getgauge.io/get-started/index.html)
  * Gauge Java plugin
    * can be installed using `gauge --install java`
  * Chrome and [Chrome WebDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads)
  
### Setting up the System Under Test (SUT)

* Download SpringBootDemo.jar
* Bring up the SUT by executing the below command
```
java -jar SpringBootDemo.jar
```
* The SUT should now be available at [http://localhost:8080/](http://localhost:8080)

## Run specs

If you already have Gradle installed, you can execute specs as `gradle specs`. Otherwise, you can use the gradle wrapper and run specs as below:

#### On Linux / Mac

```
./gradlew gauge
```

#### On Windows

```
gradlew.bat gauge
```
This runs Gauge specs with [Gradle](http://gradle.org).

This uses Chrome as default browser for specs execution. Make sure Chrome and [Chrome WebDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) is installed.



####If you want to use Firefox/IE or others browser  

 - Edit build.gradle file and change env to what you wanted browser name
 - Then change configuration file under env, edit `BROWSER`, `drivername`, `driverpath` with comparable,
 
 Make sure comparable [WebDriver](http://www.seleniumhq.org/download/) is installed

--------------------------

This project reference from [https://github.com/getgauge/gauge-example-java](https://github.com/getgauge/gauge-example-java)