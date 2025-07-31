import java.util.*;
public class fifth {
    public static int smallest(int numbers[] )
    {
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<numbers.length;i++)
        {
        if(smallest>numbers[i])
        {
            smallest=numbers[i];
        }
        }
        return smallest;
    }
    public static void main(String[] args) {
       int numbers[]={2,4,6,8,10};

       System.out.println("smallest value is :"+ smallest(numbers));

    }
}

