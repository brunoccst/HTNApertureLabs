@echo off

set PATH=%PATH%;"C:\Program Files (x86)\Java\jdk1.8.0_31\bin"
set CLASSPATH=%CLASSPATH%;../../JSHOP2.jar
set CLASSPATH=%CLASSPATH%;../../antlr.jar
set CLASSPATH=%CLASSPATH%;.

java JSHOP2.InternalDomain blocks.jshop
java JSHOP2.InternalDomain -r smallproblem.jshop
javac run.java problem.java
java -Xmx1024m run

del *.class
pause