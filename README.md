Poker
A two-player poker game with a Java Swing GUI. The project is set up
with Maven.

Requirements
Java JDK 17 or newer. No other libraries are needed. The only
dependency in pom.xml is JUnit, which is only used for tests.

Building
Unzip the project, then open a terminal in the folder that contains
RUN.java and pom.xml.

Then run:

javac -d out -sourcepath src main java RUN.java

On Mac or Linux use a forward slash instead:

javac -d out -sourcepath src/main/java RUN.java

This compiles RUN.java and all the game classes it uses into a new folder
called out. It prints nothing if it worked.

Running
From the same folder, run:
java -cp out RUN

The start screen will boot up.

How to play 

Press Play on the start screen. Starting money and the big blind can be changed in settings. On the board, press Deal to start a game. Players take turns to call, raise or fold. If someone folds, the other player gets the pot. After the flop, turn and river rounds, press Show Winner and the pot goes to the player with the best hand. The match ends when a player runs out of money
