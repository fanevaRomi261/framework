javac -d framework/build/WEB-INF/classes/ framework/src/*.java 
cd framework/build/WEB-INF/classes
jar -cf framework.jar ./
xcopy /y .\framework.jar ..\..\..\..\testframework\build\WEB-INF\lib
xcopy /y .\framework.jar ..\..\..\..\
cd ../../../../
SET CLASSPATH=.\testframework\build\WEB-INF\lib\framework.jar
javac -parameters -d testframework/build/WEB-INF/classes testframework/src/*.java
cd testframework/build
jar -cf testfr.war ./
xcopy /y .\testfr.war "C:\Program Files\Apache Software Foundation\Tomcat 10.0\webapps"
xcopy /y .\testfr.war ..\..\
cd ../../