echo "./run.sh folder domain problem"

# Environment configuration
# I believe it will not work on Mac
TOOL_PATH=`readlink -f \`dirname $0\``
JSHOP=${TOOL_PATH}/JSHOP2.jar
ANTLR=${TOOL_PATH}/antlr.jar
classpath=${TOOL_PATH}:${ANTLR}:${JSHOP}:./

cp run.java $1
cd $1

echo "Translating domain..."
java -cp ${classpath} JSHOP2.InternalDomain $2

echo "Translating problem..."
java -cp ${classpath} JSHOP2.InternalDomain -r $3

echo "Compiling..."
javac -cp ${classpath} run.java problem.java

echo "Run!"
java -cp ${classpath} -Xmx1024m run 

rm *.class
