import java.io.*;
import java.util.*;

public class _tempC
{
    public static void main (String[] args) throws IOException
    {
        StringBuilder sb = new StringBuilder();

        int T = readInt();

        while (T-- > 0)
        {
            int n = readInt();

            int[] degree = new int[n+1];

            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for (int i=0; i<=n; i++)
                graph.add(new ArrayList<>());

            for (int i=0; i<n-1; i++)
            {
                int u = readInt();
                int v = readInt();
                int x = readInt();
                int y = readInt();

                if ( x >= y )
                {
                    graph.get(u).add(v);
                    degree[v]++;
                }
                else
                {
                    graph.get(v).add(u);
                    degree[u]++;
                }
            }

            Queue<Integer> queue = Topology_Sort(n, degree, graph);
            int[] sequence = new int[n+1];
            int val = n;

            while ( !queue.isEmpty() )
            {
                int current = queue.poll();
                sequence[current] = val;
                val--;
            }

            for (int i=1; i<=n; i++)
            {
                sb.append(sequence[i]);

                if ( i < n )
                    sb.append(" ");
            }

            sb.append("\n");
        }
        System.out.print(sb);
    }

    static Queue<Integer> Topology_Sort(int N, int[] degree, ArrayList<ArrayList<Integer>> graph)
    {
        Queue<Integer> Q = new LinkedList<>();
        Queue<Integer> Return_Q = new LinkedList<>();

        for (int i=1; i<=N; i++)
        {
            if ( degree[i] == 0)
                Q.add(i);
        }

        while ( !Q.isEmpty() )
        {
            int u = Q.poll();
            Return_Q.add(u);

            for (int i=0; i<graph.get(u).size(); i++)
            {
                int v = graph.get(u).get(i);
                degree[v]--;

                if ( degree[v] == 0 )
                    Q.add(v);
            }
        }

        return Return_Q;
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