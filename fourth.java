import java.util.*;

public class fourth {
    public static int largest(int numbers[] )
    {
        int largest=0;
        for(int i=0;i<numbers.length;i++)
        {
        if(largest<numbers[i])
        {
            largest=numbers[i];
        }
        }
        return largest;
    }
    public static void main(String[] args) {
       int numbers[]={3,3,6,1};

       System.out.println("Largest value is :"+ largest(numbers));

    }
}
