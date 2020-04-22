# API Test Automation Framework

To-do : Description

## Getting Started

To-do : Getting Started

### Prerequisites

There are some basic prerequisites that are required to get started with this Nightwatch JS tutorial for testing with Selenium and JavaScript. As project requires a demo application to run which is a docker image and neds to be downloaded.

```
Node.js: Nightwatch module is built on top of Node.js, it indicates that Node.js is required to be installed on the system 
```
```
Node Package Manager (npm): Once Node.js installed , the node’s package manager i.e. npm can be leveraged to install the package which is the largest ecosystem of packages.
```
```
Java – SDK: Selenium requires Java for its remote Selenium Server. Since Nightwatch relies upon the Selenium WebDriver API and also requires a Selenium WebDriver Server, hence there is also a need to install the Java Development Kit (JDK 7+) on the system and configure the JAVA environment.
```
```
Docker : As demo application is a docker image. User needs to install docker and run below command to pull the application image from docker hub

command : docker pull spreecommerce/spree
```

### Installing

Once the project is checkedout follow below step to run the application and test. Enter below commands inside project i.e "/e2eNightWatchFramework"

1- Start demo application container using below command.

```
./bootApplication.sh
```

2- You can access application by hitting url "http://localhost:3000" in browser

4- Credentials of application is below.

```
    userName    :spree@example.com
    password    :spree123
```

3- Run below command to download all the package required to run NightWatch.js test

```
npm install --save-dev
```

## Running the tests


1- Run below command to run test located "/e2eNightWatchFramework/tests" directory

```
npm run chrome
```

2- After execution reports can be located at "/e2eNightWatchFramework/reports" directory

3- Incase of failure screenshot can be located at "/e2eNightWatchFramework/screenshots" directory

## Reference

Need to update

## Author

* **Vinaykumar Gupta** - [LinkedIn](https://in.linkedin.com/in/vinaygupta2050)


