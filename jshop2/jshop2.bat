@echo jshop2.bat folder domain problem

cd %1
set PATH=%PATH%;"C:\Program Files\Java\jdk1.8.0_25\bin"
set CLASSPATH=%CLASSPATH%;../../JSHOP2.jar
set CLASSPATH=%CLASSPATH%;../../antlr.jar
set CLASSPATH=%CLASSPATH%;.
copy ..\..\run.java .

@echo "Translating domain..."
java JSHOP2.InternalDomain %2
@echo "Translating problem..."
java JSHOP2.InternalDomain -r %3
@echo "Compiling..."
javac run.java problem.java
@echo "Run!"
java -Xmx1024m run

del *.class
pause
