package com.qa.base;

public class TestBase {
  
  public TestBase()
  {
    FileInputStream fis;
    Properties prop = new Properties();
    try{
      fis = new FileInputStream("/Users/urvashimehta/eclipse-workspace/TestNGSessions/src/test/java/com/qa/util/config.properties");
      prop.load(fis);
    }catch(Exception e)
    {e.printStackTrace();}
    
  }

}
