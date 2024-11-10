//importing java libraries needed
import java.util.Collection;

public interface NumberRangeSummarizer 
{
    //collects numbers from a comma-delimited string and returns them as a collection of integers
    Collection<Integer> collect(String input);

    //summarizes a collection of integers into a comma-delimited string with ranges
    String summarizeCollection(Collection<Integer> input);
}
