import java.io.*;

public class _D
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();
            long y = readInt();
            long[] c = new long[n+1];

            for (int i=1; i<=n; i++)
            {
                c[i] = readInt();
            }

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