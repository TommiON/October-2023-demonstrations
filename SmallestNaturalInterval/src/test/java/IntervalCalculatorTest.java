import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalCalculatorTest {

    @Test
    public void orderedArrayWithOneSmallestInterval() {
        int[] numbers = {1,3,6,10};
        assertEquals(1, IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {1,7,15,17};
        assertEquals(1, IntervalCalculator.shortestNaturalInterval(numbers2));
        int[] numbers3 = {1,10,100,105};
        assertEquals(4, IntervalCalculator.shortestNaturalInterval(numbers3));
        int[] numbers4 = {1,4,1,5,1,4,1,7};
        assertEquals(2, IntervalCalculator.shortestNaturalInterval(numbers4));
    }

    @Test
    public void orderedArrayWithMultipleSmallestIntervals() {
        int[] numbers = {0,2,4,10};
        assertEquals(1, IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {0,4,10,20,24,100};
        assertEquals(3, IntervalCalculator.shortestNaturalInterval(numbers2));
    }

    @Test
    public void unorderedArrayWithOneSmallestInterval() {
        int[] numbers = {5,1,3};
        assertEquals(1, IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {1,2,3,10,1,4};
        assertEquals(2, IntervalCalculator.shortestNaturalInterval(numbers2));
    }

    @Test
    public void unorderedArrayWithMultipleSmallestInterval() {
        int[] numbers = {10,1,4,100,200,203,300};
        assertEquals(2, IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {1,5,0,4,0,4,0,10,14};
        assertEquals(3, IntervalCalculator.shortestNaturalInterval(numbers2));
        int[] numbers3 = {6,0,5,1,2,3,8,15};
        assertEquals(4, IntervalCalculator.shortestNaturalInterval(numbers3));
    }

    @Test
    public void maxIntegerValues() {
        int[] numbers = {0, Integer.MAX_VALUE, 1, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE -2, IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE};
        assertEquals(Integer.MAX_VALUE -1, IntervalCalculator.shortestNaturalInterval(numbers2));
    }

    @Test
    public void arrayWithNoFreeSpaces() {
        int[] numbers = {1,2,3,4,5};
        assertNull(IntervalCalculator.shortestNaturalInterval(numbers));
        int[] numbers2 = {5,4,3,2,1};
        assertNull(IntervalCalculator.shortestNaturalInterval(numbers2));
        int[] numbers3 = {1,1,1,1,1};
        assertNull(IntervalCalculator.shortestNaturalInterval(numbers3));
    }

    @Test
    public void underlenghtArray() {
        int[] numbers = {1};
        assertNull(IntervalCalculator.shortestNaturalInterval(numbers));
    }
}