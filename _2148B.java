import java.io.*;
import java.util.*;

public class _2148B
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

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            st.nextToken();
            st.nextToken();

            st = new StringTokenizer(input.readLine());

            for (int i=0; i<n; i++)
                st.nextToken();

            st = new StringTokenizer(input.readLine());

            for (int j=0; j<m; j++)
                st.nextToken();

            sb.append(n+m).append("\n");
        }

        System.out.println(sb);
    }
}