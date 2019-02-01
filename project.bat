@ECHO OFF
F:
cd /path/
javac -cp mysql.jar;. Main.java
java -cp mysql.jar;. Main
