# JUnit Demo for Data Structures
Example test file for testing the vector data structure, a generic test runner class, and a logger.

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
