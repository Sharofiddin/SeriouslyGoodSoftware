javac -d classes uz/learn/chapter2/Container.java
java -cp classes uz.learn.chapter1.novice.Container

javac -cp libs/junit-4.12.jar:libs/hamcrest-core-1.3.jar uz/learn/chapter6/exercise/DivisorsTest.java -d classes
java -cp libs/junit-4.12.jar:classes:libs/hamcrest-core-1.3.jar org.junit.runner.JUnitCore uz.learn.chapter6.exercise.DivisorsTest
java -javaagent:/home/sharofiddin/Downloads/jacoco-0.8.13/lib/jacocoagent.jar=destfile=jacoco.exec -cp ".:libs/junit-4.12.jar:libs/hamcrest-core-1.3.jar:classes" org.junit.runner.JUnitCore  uz.learn.chapter6.exercise.InterleaveListsTest uz.learn.chapter6.exercise.DivisorsTest uz.learn.chapter6.exercise.IndexOfTest
java -jar ~/Downloads/jacoco-0.8.13/lib/jacococli.jar report jacoco.exec --classfiles classes --html ./jacoco-report  --sourcefiles src/
