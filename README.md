#Project 1

File Directory Description:
* src/ contains all the \*.java source files for running the SearchMap Program
* tst/ contains all the JUnit tests for the src \*.java files
* lib/ contains JUnit .jar files
* inputfile.txt and outputfile.txt are the default read and write files for the SearchMap Program (more explained below)
* When created by `ant init`:
	* bin/src contains all the \*.class files compiled from the src/ directory
	* bin/tst contains all the \*.class files compiled from the src directory
	* dist/ contains the \*.jar files
	* doc/ contains the javadocs

Ant Commands:
* everything works as specified in the instructions (`init`, `clean`, `compile`, `test`, `dist`, `doc`) 
* Running `ant run` or just `ant` will run the entire program as follows:
	* `ant init`
	* `ant compile`
	* `ant dist`
	* `ant test`
	* `ant doc`
	* runs the following command: `java SearchMap [...]/Project1/inputfile.txt [...]/Project1/outputfile.txt`
