import java.io.*;
import java.util.*;

public class _temp6
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            int n = Integer.parseInt(input.readLine());
            String[] strs = new String[n];

            for (int i=0; i<n; i++)
            {
                String temp = input.readLine();
                String s = temp.replace(" ", "");
                s = s.substring(1, s.length());

                strs[i] = s;
            }

            
        }

        System.out.print(sb);
    }
}