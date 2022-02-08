# Installation
Directly clone project

Make sure all dependencies are downloaded

If you are using different Java SDK, you will need to setup SKD

Under src > test > java > com > fashionette > tests, there is TestBase class which contains @BeforeMethod and @AfterMethod

You can directly run it from IDE or I added maven surefire plugin to pom.xml which helps to run tests from command line by typing **mvn verify**


# Framework
I have created this project with maven so I keep all dependencies in pom.xml file

I created configuration.properties file, which contains browser type and urls in key-value format.


# Utilities
-I created Driver utility, which is designed as singleton and it supports "chrome","chrome-headless","firefox","firefox-headless","internet explorer" for windows and "edge", "safari" for mac.

-I created ConfigurationReader utility to be able to get the values from configuration.properties file.

-I created BrowserUtilities which contains methods such as acceptCookies, waitForPageToLoad etc.


## Pages

Pages package has 

@BasePage which contains all common webelements and methods and other pages extends it.
I used PageFactory.initElements method to be able to initialize webelements by using @FindBy annotation without using findElement() method.

@LoginPage which contains locators for Scenerio_01

@ModifyPage which contains locators for Scenerio_02

@Voucher which contains locators for Scenerio_03


# Tests
I created objects from the pages to be able to use its webelements and methods. 

Since I execute these tests on my local computer, I used waits more than expected to avoid from synchronization issues because of internet and my computer`s speed.

I created TestBase class which contains before and after methods.

There are 3 Scenerios in assignment and each scenerios run with names.



