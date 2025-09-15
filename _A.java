import java.io.*;

public class _A
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();
            int[] prefix_sum = new int[n+1];

            for (int i=1; i<=n; i++)
            {
                int x = readInt();
                prefix_sum[i] += prefix_sum[i-1] + x;
            }

            boolean flag = false;

            for (int l=1; l<=n-2; l++)
            {
                for (int r=l+1; r<=n-1; r++)
                {
                    int sum_0 = prefix_sum[l] % 3;
                    int sum_1 = (prefix_sum[r] - prefix_sum[l]) % 3;
                    int sum_2 = (prefix_sum[n] - prefix_sum[r]) % 3;

                    if ( ( (sum_0 == sum_1) && (sum_1 == sum_2) ) || 
                        ((sum_0 != sum_1) && (sum_1 != sum_2) && (sum_0 != sum_2)) )
                    {
                        flag = true;
                        sb.append(l).append(" ").append(r).append("\n");
                        break;
                    }
                }

                if ( flag == true )
                    break;
            }

            if ( flag == false )
                sb.append(0).append(" ").append(0).append("\n");

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