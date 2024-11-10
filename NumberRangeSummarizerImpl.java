//importing needed java libraries
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NumberRangeSummarizerImpl implements NumberRangeSummarizer 
{
    //collection method to split strings into individual numbers returning sorted collection
    @Override
    public Collection<Integer> collect(String input) 
    {
        //space for sorted collection created using arraylist
        Collection<Integer> numbers = new ArrayList<>();
        if(input == null || input.isEmpty()) 
        {
            return numbers;
        }
        //splitting string into parts by comma
        String[] parts = input.split(",");
        for(String part : parts) 
        {
            //try catch statement to trim spaces between strings
            try
            {
                numbers.add(Integer.parseInt(part.trim()));
            } 
            catch(NumberFormatException e) 
            {
                // Ignore invalid numbers
            }
        }
        return numbers;
    }

    //method to collect sorted collection of ints converting into ranges and individual numbers
    @Override
    public String summarizeCollection(Collection<Integer> input) 
    {
        //checking if arraylist isnt empty
        if(input == null || input.isEmpty()) 
        {
            return "";
        }
        //retrieving sorted list of ints
        List<Integer> sortedList = new ArrayList<>(input);
        Collections.sort(sortedList);

        //starting point of range = first number in possible range (stringbuilder used to construct output string)
        StringBuilder summary = new StringBuilder();
        int rangeStart = sortedList.get(0);
        int prev = rangeStart;

        //loop through list
        for(int i = 1; i < sortedList.size(); i++) 
        {
            //getting the current range to identify where the index is
            int current = sortedList.get(i);
            if(current != prev + 1) 
            {
                //appending range to result
                if(rangeStart == prev) 
                {
                    summary.append(rangeStart).append(",");
                } 
                else 
                {
                    summary.append(rangeStart).append("-").append(prev).append(",");
                }
                //updating value while if condition is true
                rangeStart = current;
            }
            prev = current;
        }

        //conditions to append the result to be outputed
        if(rangeStart == prev) 
        {
            summary.append(rangeStart);
        } 
        else 
        {
            summary.append(rangeStart).append("-").append(prev);
        }
        //returning final string summarized output
        return summary.toString();
    }
}
