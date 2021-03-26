# TestNGSessions
The tests are in src/test/java/com/qa/tests
There are two test classes:
1. Testngstart is just to login to freecrm with a parameter "url" passed in testng
2. DataProviderTest is to read data from an excel file in src/test/java/com/excelSheet, read by methods of class src/test/java/com/qa/util/TestUtil.java,XLs_Reader.java,config.properties
src/main/resources/testng.xml file specifies the "url" parameter value as "https://www.freecrm.com" and lists both test classes in <classes> to run as a suite
