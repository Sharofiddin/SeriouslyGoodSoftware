javac -d classes uz/learn/chapter2/Container.java
java -cp classes uz.learn.chapter1.novice.Container

javac -cp libs/junit-4.12.jar:libs/hamcrest-core-1.3.jar uz/learn/chapter6/exercise/DivisorsTest.java -d classes
java -cp libs/junit-4.12.jar:classes:libs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore uz.learn.chapter6.exercise.DivisorsTest

