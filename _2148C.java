import java.io.*;
import java.util.*;

public class _2148C
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
            int[] a = new int[n+1];
            int[] b = new int[n+1];

            for (int i=1; i<=n; i++)
            {
                st = new StringTokenizer(input.readLine());

                a[i] = Integer.parseInt(st.nextToken());
                b[i] = Integer.parseInt(st.nextToken());
            }

            int sum = 0;

            for (int i=0; i<=n-1; i++)
            {
                if ( (a[i+1] - a[i]) % 2 == 1 ) {
                    sum += a[i+1] - a[i];

                    if ( b[i+1] == b[i] )
                        sum--;
                } else {
                    sum += a[i+1] - a[i];

                    if ( b[i+1] != b[i] )
                        sum--;
                }
            }

            sum += m - a[n];

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }
}