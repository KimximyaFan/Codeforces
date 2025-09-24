import java.io.*;
import java.util.*;

public class _temp
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();
        long MOD = 998244353;

        while (T-- > 0)
        {
            int n = readInt();
            int[] a = new int[n];
            int[] b = new int[n];

            for (int i=0; i<n; i++)
                a[i] = readInt();

            for (int i=0; i<n; i++)
                b[i] = readInt();

            long ans = 1;

            for (int i=0; i<n; i++)
            {
                if ( a[i] > b[i] )
                    Swap(a, b, i);

                if ( i == 0 || a[i] >= b[i-1] )
                    ans = (ans * 2L) % MOD;
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

    static void Swap(int[] a, int[] b, int index)
    {
        int temp = a[index];
        a[index] = b[index];
        b[index] = temp;
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