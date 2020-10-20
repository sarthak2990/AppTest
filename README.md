# AppTest for Gaming mobile App

Software Requirement: Java , Maven , Appium

Instruction to Install : mvn clean install

Instrauction to run: "mvn test"  or in case when app supports ios then "mvn test -Ddevice=ios/andriod" by default it picks andriod

Locators are stored in LoginScreen.properties  and for storing locatores for xpath I have added XP_ as prefix and ClassName CS_, AS_ for accesibility

Test consists of Positive and negatives login tests

I have log4f for logger and Extent report for reporting

This test will currenlty work on any default real andriod device connected to your laptop and incase of multiple connect currently it will pick  the first devices shown on adb devices command

I have used factory pattern to intiate Appium session and use of listeners , dataproviders are made to test with multiple test data
 Please reach out to me at sarthak2990@gmail.com incase of any questions
