package src.ru.vsu.sc.savenkova_a_v;


import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ReversingElementsTest {

    @Test
    public void testReversedEmptyStack() {
        String testingSource = ("");
        String actualResult = ReversingElementsOfStack.reverseStandardStack(testingSource);
        String correctResult = ("");

        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void testReversedStackWithOneSymbol() {
        String testingSource = ("d");
        String actualResult = ReversingElementsOfStack.reverseStandardStack(testingSource);
        String correctResult = ("d");

        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void testReversedStackWithSameElements() {
        String testingSource = ("oooooooooooo");
        String actualResult = ReversingElementsOfStack.reverseStandardStack(testingSource);
        String correctResult = ("oooooooooooo");

        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void testReversedStandardStack() {
        String testingSource = ("(0_o) well..");
        String actualResult = ReversingElementsOfStack.reverseSimpleStack(testingSource);
        String correctResult = ("..llew )o_0(");

        Assert.assertEquals(correctResult, actualResult);
    }

    @Test
    public void testReversedSimpleStack() {
        String testingSource = ("She is Eva");
        String actualResult = ReversingElementsOfStack.reverseSimpleStack(testingSource);
        String correctResult = ("avE si ehS");

        Assert.assertEquals(correctResult, actualResult);
    }
}
