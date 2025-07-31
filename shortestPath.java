public class shortestPath {
    public static float getShortestPath(String path)
    {
        int x=0,y=0;
        for(int i=0;i<path.length();i++)
        {
            char dir=path.charAt(i);

            //north
            if(dir=='N')
            {
                y++;
            }
           else if(dir=='S')
            {
                y--;
            }
            else if(dir=='w')
            {
                x--;
            }
            else
            {
                x++;
            }

        }
        int x2=x*x;
        int y2=y*y;
        return (float)Math.sqrt(x2+y2);
    }
    public static void main(String[] args) {
        // String  path="NS";
        // System.out.println(getShortestPath(path));

        String str1="Tony";
        String str2="Tony";
        String str3=new String("Tony");

        if(str1==str3)
        {
            System.out.println("Strings are equal");
        }
        else{
            System.out.println("Strings are not equal");
        }
        if(str1.equals(str3))
        {
            System.out.println("Strings are equal");
        }

        //equals function checks only value...

        

    }
}
