import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VectorTest {

  /**************************************************/
  /* Testing new vector is created to specification */
  /**************************************************/
  @Test
  public void a_testCreate() {
    Logger.addTest("vector-initial-size");
    Logger.expectSuccess();

    Vector v = new Vector();

    try {
      assertEquals(0, v.getSize());
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

  /**********************************/
  /* Testing valid and invalid adds */
  /**********************************/
  @Test
  public void b_testAdd0() {
    Logger.addSectionBreak();
    Logger.addTest("vector-add-0");
    Logger.expectException();

    Vector<Integer> v = new Vector<Integer>();

    boolean fail = false;
    try {
      v.add(-1, 0);
      Logger.noException();
      fail = true;
    } catch (IndexOutOfBoundsException e) {
      Logger.pass();
    }
    if(fail) throw new AssertionError();
  }

  @Test
  public void b_testAdd1() {
    Logger.addTest("vector-add-1");
    Logger.expectException();

    Vector<Integer> v = new Vector<Integer>();

    boolean fail = false;
    try {
      v.add(2, 0);
      Logger.noException();
      fail = true;
    } catch (IndexOutOfBoundsException e) {
      Logger.pass();
    }
    if(fail) throw new AssertionError();
  }

  @Test
  public void b_testAdd2() {
    Logger.addTest("vector-add-2");
    Logger.expectSuccess();

    Vector<Integer> v = new Vector<Integer>();

    try {
      v.add(0);
      assertEquals(1, v.size());
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

  /**********************************/
  /* Testing valid and invalid gets */
  /**********************************/
  @Test
  public void c_testGet0() {
    Logger.addSectionBreak();
    Logger.addTest("vector-get-0");
    Logger.expectException();

    Vector v = new Vector();

    boolean fail = false;
    try {
      v.get(0);
      Logger.noException();
      fail = true;
    } catch (IndexOutOfBoundsException e) {
      Logger.pass();
    }
    if(fail) throw new AssertionError();
  }

  @Test
  public void c_testGet1() {
    Logger.addTest("vector-get-1");
    Logger.expectException();

    Vector v = new Vector();

    boolean fail = false;
    try {
      v.get(-1);
      Logger.noException();
      fail = true;
    } catch (IndexOutOfBoundsException e) {
      Logger.pass();
    }
    if(fail) throw new AssertionError();
  }

  @Test
  public void c_testGet2() {
    Logger.addTest("vector-get-2");
    Logger.expectSuccess();

    Vector<Integer> v = new Vector<Integer>();
    v.add(1234);

    try {
      int val = v.get(0);
      assertEquals(1234, val);
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

  /*****************************************/
  /* Testing a valid and an invalid remove */
  /*****************************************/
  @Test
  public void d_testRemove0() {
    Logger.addSectionBreak();
    Logger.addTest("vector-remove-0");
    Logger.expectException();

    Vector<Integer> v = new Vector<Integer>();
    v.add(1234);

    try {
      boolean b = v.remove(new Integer(1234));
      assertTrue(b);
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

  @Test
  public void d_testRemove1() {
    Logger.addSectionBreak();
    Logger.addTest("vector-remove-1");
    Logger.expectException();

    Vector<Integer> v = new Vector<Integer>();
    v.add(1234);

    try {
      boolean b = v.remove(new Integer(0));
      assertFalse(b);
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

  /***********************/
  /* Testing a valid set */
  /***********************/
  @Test
  public void e_testSet0() {
    Logger.addSectionBreak();
    Logger.addTest("vector-set-0");
    Logger.expectException();

    Vector<Integer> v = new Vector<Integer>();
    v.add(1234);

    try {
      Integer i = v.set(0, 10);
      assertNotNull(i);
      Logger.pass();
    } catch (AssertionError e) {
      Logger.wrongValue();
      throw e;
    }
  }

}
