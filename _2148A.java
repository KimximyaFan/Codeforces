import java.io.*;
import java.util.*;

public class _2148A
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(input.readLine());

        while (T-- > 0)
        {
            st = new StringTokenizer(input.readLine());

            int x = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            if ( count % 2 == 0 )
                sb.append(0).append("\n");
            else
                sb.append(x).append("\n");
        }

        System.out.print(sb);
    }
}