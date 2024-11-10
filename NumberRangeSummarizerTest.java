//import java libraries needed
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.Collection;

public class NumberRangeSummarizerTest 
{
    //defining new test class for NumberRangerSummarizerImpl
    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImpl();

    //method to check collect method properly splits, trims, sorts 
    @Test
    public void testCollect() 
    {
        Collection<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expected, summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31"));
    }

    //method to check that sequential numbers are grouped into ranges
    @Test
    public void testSummarizeCollection() 
    {
        Collection<Integer> numbers = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String expected = "1,3,6-8,12-15,21-24,31";
        assertEquals(expected, summarizer.summarizeCollection(numbers));
    }

    //method to display non-sequential numbers individually
    @Test
    public void testSummarizeCollectionWithSingleNumber() 
    {
        Collection<Integer> numbers = Arrays.asList(5);
        String expected = "5";
        assertEquals(expected, summarizer.summarizeCollection(numbers));
    }

    //method to handle empty inputs
    @Test
    public void testSummarizeCollectionWithEmptyInput() 
    {
        Collection<Integer> numbers = Arrays.asList();
        String expected = "";
        assertEquals(expected, summarizer.summarizeCollection(numbers));
    }

    //method to check if the summary list is empty
    @Test
    public void testCollectWithEmptyString() 
    {
        Collection<Integer> expected = Arrays.asList();
        assertEquals(expected, summarizer.collect(""));
    }

    //method to check if invalid characters are in the summary list
    @Test
    public void testCollectWithInvalidNumbers() 
    {
        Collection<Integer> expected = Arrays.asList(1, 2, 3);
        assertEquals(expected, summarizer.collect("1,2,3,abc,xyz"));
    }
}
