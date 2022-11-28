import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*******************************************************************************
 * Name          : Toposort.java
 * Author        : Brian S. Borowski
 * Version       : 1.1
 * Date          : October 13, 2020
 * Last modified : November 11, 2022
 * Description   : Solves SPOJ's TOPOSORT problem.
 *                 https://www.spoj.com/problems/TOPOSORT2/
 *                 Not fast enough to solve original problem in Java, though
 *                 it works fine in C/C++.
 *                 https://www.spoj.com/problems/TOPOSORT/
 ******************************************************************************/
class Main {
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int currentChar, numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int nextInt() throws IOException {
            int c = '0', value = 0;
            while (true) {
                if (currentChar >= numChars) {
                    currentChar = 0;
                    numChars = stream.read(buf);
                }
                if ((c = buf[currentChar++]) < 33) {
                    break;
                }
                value = (value << 3) + (value << 1) + (c & 15);
            }
            return value;
        }
    }

    public static List<Integer> toposort(List<Integer>[] graph) {
        // TODO
        int[] indegree = new int[graph.length];

        //Determine the indegree of each vertex.
        for (int vertex = 1; vertex < graph.length; vertex++) {
            for (int node : graph[vertex]) {
                indegree[node]++;
            }
        }
        // Declare a min heap priority queue.
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(int vertex = 1; vertex < graph.length; vertex++) {
            if (indegree[vertex] == 0) {
                q.add(vertex);
            }
        }

        // Perform the core algorithm.
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int vertex = q.poll();
            order.add(vertex);
            for (int adjacent : graph[vertex]) {
                if (--indegree[adjacent] == 0) {
                    q.add(adjacent);
                }
            }
        }

        if (order.size() != graph.length - 1) {
            return null;
        }

        return order;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        InputReader ir = new InputReader(System.in);
        int n = ir.nextInt(), m = ir.nextInt();

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i < graph.length; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        while (m-- > 0) {
            int x = ir.nextInt(), y = ir.nextInt();
            graph[x].add(y);
        }
        List<Integer> order = toposort(graph);
        if (order != null) {
            StringBuilder builder = new StringBuilder();
            for (int vertex: order) {
                builder.append(vertex);
                builder.append(" ");
            }
            System.out.println(builder.toString());
        } else {
            System.out.println("Sandro fails.");
        }
    }
}
