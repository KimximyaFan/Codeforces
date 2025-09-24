import java.io.*;

public class _tempA
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();
            int[] arr = new int[n];
            boolean flag = true;

            for (int i=0; i<n; i++)
                arr[i] = readInt();

            for (int size=n; size>=1; size--)
            {
                flag = check_subtract(arr, size);

                if ( flag == false )
                    break;
            }

            if ( flag == true )
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }

    static boolean check_subtract(int[] arr, int window_size)
    {
        int N = arr.length;

        boolean is_possible = false;

        for (int i=0; i<=N-window_size; i++)
        {
            boolean flag = true;

            for (int j=i; j<i+window_size; j++)
            {
                if ( arr[j] <= 0 )
                {
                    flag = false;
                    break;
                }
            }

            if ( flag == true )
            {
                for (int j=i; j<i+window_size; j++)
                {
                    arr[j]--;
                }

                is_possible = true;
                break;
            }
        }

        return is_possible;
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