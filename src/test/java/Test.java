import com.mindera.GroupsGP;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import java.util.ArrayList;
import java.util.Arrays;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by carlosmorais on 15/06/2017.
 */
public class Test {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @org.junit.Test
    public void nullListShouldThrowIllegalArgumentException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the list can't be null !");

        GroupsGP g = new GroupsGP();
        assertEquals("expected IllegalArgumentException", g.groups(null,7));
        fail("Expected an IllegalArgumentException to be thrown");
    }


    @org.junit.Test
    public void zeroGroupsShouldReturnEmptyList() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>();
        l.add(2);
        assertEquals("expected a empty list", new ArrayList<>(), g.groups(l,0));
    }

    @org.junit.Test
    public void nGroupsBiggerThanNumberShouldThrowIllegalArgumentException() throws Exception {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("the total of different numbers should be bigger than the number of groups");

        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>();
        assertEquals("expected IllegalArgumentException", g.groups(l,7));
        fail("Expected an IllegalArgumentException to be thrown");
    }

    @org.junit.Test
    public void nGroupsBiggerThanTotalOfDiffrentNumberShouldThrowException() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("the total of different numbers should be bigger than the number of groups");

        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(2,2,8,9));
        assertEquals(new ArrayList<>(), g.groups(l,4));
        fail("Expected an Exception to be thrown");
    }

    @org.junit.Test
    public void test0() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(1,2,8,9,89,300));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1,2,8,9)));
        expected.add(new ArrayList<>(Arrays.asList(89)));
        expected.add(new ArrayList<>(Arrays.asList(300)));
        assertEquals("unexpected list", expected, g.groups(l,3));
    }

    @org.junit.Test
    public void test1() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 34, 23, 29, 12, 23, 23, 12, 34, 23, 23)));
        expected.add(new ArrayList<>(Arrays.asList(45, 45, 45)));
        expected.add(new ArrayList<>(Arrays.asList(67, 67, 67)));
        assertEquals("unexpected list", expected, g.groups(l,3));
    }

    @org.junit.Test
    public void test2() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 23, 12, 34, 45, 23, 23)));
        expected.add(new ArrayList<>(Arrays.asList(67, 67)));
        expected.add(new ArrayList<>(Arrays.asList(670)));
        assertEquals("unexpected list", expected, g.groups(l,3));
    }

    @org.junit.Test
    public void test3() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(160, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 670));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 23, 12, 34, 45, 23, 23)));
        expected.add(new ArrayList<>(Arrays.asList(67, 67)));
        expected.add(new ArrayList<>(Arrays.asList(160)));
        expected.add(new ArrayList<>(Arrays.asList(670)));
        assertEquals("unexpected list", expected, g.groups(l,4));
    }

    @org.junit.Test
    public void test4() throws Exception {
        GroupsGP g = new GroupsGP();
        ArrayList<Integer> l = new ArrayList<>(Arrays.asList(16, 15, 14, 13, 34, 23, 24, 25, 26, 28, 45, 34, 23, 29, 12, 23, 45, 67, 23, 12, 34, 45, 23, 67, 23, 67));
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(16, 15, 14, 13, 12, 12)));
        expected.add(new ArrayList<>(Arrays.asList(23, 24, 25, 26, 28, 23, 29, 23, 23, 23, 23)));
        expected.add(new ArrayList<>(Arrays.asList(34, 34, 34)));
        expected.add(new ArrayList<>(Arrays.asList(45, 45, 45)));
        expected.add(new ArrayList<>(Arrays.asList(67, 67, 67)));
        assertEquals("unexpected list", expected, g.groups(l,5));
    }
}
