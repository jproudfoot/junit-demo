# JUnit Demo for Data Structures
Example test file for testing the vector data structure, a generic test runner class, and a logger.

## Running Tests
To run the tests first download the five java files then run the following command to compile the files.
```bash
javac VectorIterator.java Vector.java Logger.java VectorTest.java TestRunner.java
```
Then run the following command to run the tests.
```bash
java TestRunner VectorTest
```

### Vector Tests
The VectorTest.java file contains the tests for testing the implementation of Vector.

This annotation before the class declaration is used for telling the TestRunner which order to run the tests in. Without it the tests may be run in any order.
```java
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
```
To control the order of the tests we prepend all of the test names with a letter which corresponds to what test block the test is in.
```java
public void a_testCreate()
```
```java
public void b_testAdd0()
```
All of the tests are written within a try-catch block for example the following test asserts that the size of a new array is equal to zero.
```java
Vector v = new Vector();
try {
  assertEquals(0, v.getSize());
  Logger.pass();
} catch (AssertionError e) {
  Logger.wrongValue();
  throw e;
}
```

### Test Runner
The TestRunner.java file contains a generic runner that will run any test file. The following command is used to run a test file.
```bash
java TestRunner <Name of Test File>
```

### Logger
The Logger.java file contains a logger designed for logging various aspects of the testing.
