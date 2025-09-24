import java.io.*;
import java.util.*;

public class _tempB
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();
            int k = readInt();
            long sum = 0;

            PriorityQueue<Integer> a = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> b = new PriorityQueue<>();
            PriorityQueue<Integer> mid = new PriorityQueue<>();

            for (int i=1; i<=n; i++)
                a.add( readInt() );

            for (int i=1; i<=k; i++)
                b.add( readInt() );

            while (!b.isEmpty())
            {
                if ( a.size() < b.peek() )
                    break;

                int size = b.poll();

                for (int i=0; i<size; i++)
                {
                    mid.add(a.poll());
                }

                mid.poll();

                while ( !mid.isEmpty() )
                    sum += mid.poll();
            }

            while ( !a.isEmpty() )
                sum += a.poll();

            sb.append(sum).append("\n");
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