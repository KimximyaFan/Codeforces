import java.io.*;
import java.util.ArrayList;

public class _B
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();
            int[] a = new int[n+1];
            boolean[] used = new boolean[n+1];
            ArrayList<Integer> unused = new ArrayList<>();
            
            for (int i=1; i<=n; i++)
            {
                a[i] = readInt();
                used[a[i]] = true;
            }

            for (int i=1; i<=n; i++)
            {
                if ( used[i] == true)
                    continue;

                unused.add(i);
            }

            if ( unused.size() == 1 ) {
                for (int i=1; i<=n; i++) {
                    if ( a[i] == 0 ) {
                        a[i] = unused.get(0);
                    }
                }
            }

            int left = 1;
            int right = n;

            while (left < right)
            {
                if ( a[left] != left )
                    break;

                left++;
            }

            while (left < right)
            {
                if ( a[right] != right )
                    break;

                right--;
            }

            sb.append( right == left ? 0 : right-left+1 ).append("\n");
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