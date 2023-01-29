this project was created using vscode and maven 
in order to run this project apache tomcat version 10.0.8 needed

you can get it from vscode extensions named Community Server Connector
then choose a new server and use apache tomcat 10  then run the server 
you will be able to use localhost:8080
after making sure that maven and apache server works fine

use mvn clean 
then mvn package

after that add the generated project.war in the target folder to the community server connector apache tomcat 10

then you will be able to use the GUI of the program under
register servlet

www.localhost:8080/project/register

presentation servlet

www.localhost:8080/project/presentation
