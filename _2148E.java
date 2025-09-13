import java.io.*;
import java.util.*;

public class _2148E
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int MAX = 200001;
        int T = readInt();
        int[] a = new int[MAX];
        int[] count = new int[MAX];

        while (T-- > 0)
        {
            int n = readInt();
            int k = readInt();
            
            Arrays.fill(count, 0);

            boolean flag = true;

            for (int i=0; i<n; i++) {
                a[i] = readInt();
                count[a[i]]++;
            }
            
            for (int i=0; i<n; i++) {
                if ( count[a[i]] % k != 0 ) {
                    flag = false;
                    break;
                }
            }

            if ( flag == false ) {
                sb.append(0).append("\n");
                continue;
            }

            long ans = 0;
            int left = 0, right = 0;
            int[] freq = new int[MAX];

            while ( right < n )
            {
                if ( freq[a[right]] + 1 <= count[a[right]] / k )
                {
                    freq[a[right]]++;
                    ans += right - left + 1;
                    right++;
                } 
                else
                {
                    freq[a[left]]--;
                    left++;
                }
            }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int readInt() throws IOException
    {
        int c, num = 0;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') { neg = true; c = System.in.read(); }
        do { num = (num << 3) + (num << 1) + (c & 15); } 
        while ((c = System.in.read()) >= '0' && c <= '9');
        return neg ? -num : num;
    }
}