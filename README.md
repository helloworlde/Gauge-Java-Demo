# Gauge-Java-Demo
This is a project of [Gauge](http://getgauge.io) of JavaWeb and build by [Gradle](http://gradle.org). For  test database,request and page operation automation of a [SpringBoot application](https://github.com/helloworlde/SpringBoot-Demo).


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

* Download [SpringBootDemo.jar](https://github.com/helloworlde/SpringBoot-Demo/blob/master/SpringBootDemo.jar) file
* Bring up the SUT by executing the below command
```
java -jar SpringBootDemo.jar
```
* The SUT should now be available at [http://localhost:8080/](http://localhost:8080)

## Run specs

If you already have Gradle installed, you can execute specs as `gradle specs`. Otherwise, you can use the gradle wrapper and run specs as below:

### On Linux / Mac

```
./gradlew gauge
```

### On Windows

```
gradlew.bat gauge
```
This runs Gauge specs with [Gradle](http://gradle.org).

This uses Chrome as default browser for specs execution. Make sure your Chrome and [Chrome WebDriver](https://sites.google.com/a/chromium.org/chromedriver/downloads) is comparable.




###If you want to use Firefox/IE or other browser  

 - Edit build.gradle file and change env to what you wanted browser name which in env folder
 
 
 Make sure [WebDriver](http://www.seleniumhq.org/download/) under env folder is comparable with your browser, if not, you need to replace it.

##WebDriver download
* [IE WebDriver](http://selenium-release.storage.googleapis.com/index.html)
* [Chrome WebDriver](https://sites.google.com/a/chromium.org/chromedriver/)
* [Edge WebDriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
* Others you can find in[http://www.seleniumhq.org/download/](http://www.seleniumhq.org/download/) mostly



--------------------------

This project reference from [https://github.com/getgauge/gauge-example-java](https://github.com/getgauge/gauge-example-java)