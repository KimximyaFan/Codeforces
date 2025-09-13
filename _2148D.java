import java.io.*;
import java.util.*;

public class _2148D
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
            ArrayList<Long> odds = new ArrayList<>();
            long even_sum = 0;
            long odd_sum = 0;
            long[] a = new long[n];
            boolean is_odd_exist = false;

            st = new StringTokenizer(input.readLine());

            for (int i=0; i<n; i++) {
                a[i] = Long.parseLong(st.nextToken());

                if ( a[i] % 2 == 1 ) {
                    is_odd_exist = true;
                    odds.add(a[i]);
                }
                else {
                    even_sum += a[i];
                }
            }

            if ( is_odd_exist == false ) {
                sb.append(0).append("\n");
                continue;
            }

            Collections.sort(odds);

            for (int i=odds.size()-1; i>=odds.size()/2; i--)
                odd_sum += odds.get(i);

            sb.append(odd_sum + even_sum).append("\n");
        }

        System.out.print(sb);
    }
}