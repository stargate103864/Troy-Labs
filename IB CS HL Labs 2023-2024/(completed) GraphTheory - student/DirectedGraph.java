import java.util.*;
import java.lang.*;

/*
 *     all vertices are numbered with Strings of length 1
 *     
 *     Edges are of the form (a, b), a and b are String with length 1
 *     
 *     Edges are assumed to be directed, which implies (1,3) is different from Edge (3,1)
 */

public class DirectedGraph 
{
    /*
     *   No duplicates vertices
     */
    private Set<String> myVertices;
    /*
     *   No duplicates edges
     */
    private Set<Edge> myEdges;
    private Map<Edge, Boolean> visited;
    private boolean anshasPath;
    private boolean simplehasPath;
    private String pAns;
    /**
     * Constructor for objects of class DirectedGraph
     */
    public DirectedGraph(Set<String> vertices)
    {
        myEdges = new HashSet<Edge>();
        myVertices = new HashSet<String>();
        for (String ele: vertices) {
            myVertices.add(ele);
        }
    }

    /*
     * precondition
     *   myVertices.contains(e.getA()) == true
     *   && myVertices.contains(e.getB()) == true
     *   myEdges.contains(e) == false
     * postcondtion:  myEdges.contains(e) == true
     */
    public void addEdge(Edge e)
    {
        myEdges.add(e);
    }

    /*
     * precondition
     *   for every edge in edges,
     *     myVertices.contains(edge.getA()) == true
     *     && myVertices.contains(edge.getB()) == true
     *   myEdges.contains(edge) == false
     * postcondtion:  every edge in edges is added to myEdges
     */
    public void addEdges(Set<Edge> edges)
    {
        for (Edge ele: edges) {
            myEdges.add(ele);
        }
    }

    /*
     *  precondition
     *    myVertices.contains(s) == false
     *    
     *  postcondition
     *    myVertices.contains(s) == true
     */
    public void addVertex(String s)
    {
        myVertices.add(s);
    }

    /*
     *     According to http://webwhompers.com/graph-theory.html
     *     
     *     Two vertices are called adjacent if they share a common edge,   (direction of edge not important)
     *     
     *     precondition myVertices.contains(s) == true  && myVertices.contains(t)
     *     
     *     returns true iff vertex s and vertex t share a common edge (in either direction)
     *                  
     *         yes, you can be adjacent to your self
     */
    public boolean isAdjacent(String s, String t)
    {
        for (Edge ele: myEdges) {
            if (ele.getA().equals(s) && ele.getB().equals(t) || ele.getA().equals(t) && ele.getB().equals(s)) {
                return true;
            }
        }
        return false;
    }

    /*
     *     According to http://webwhompers.com/graph-theory.html
     *     
     *     The neighborhood of a vertex v in a graph G is the set of vertices adjacent to v.
     *                      Use the definition of adjacent from isAdjacent above
     *                      i.e. - direction is NOT important
     *     
     *     precondition myVertices.contains(s) == true
     *     
     *     returns a Set of all neighbors of s
     *     The neighborhood does not include itself.
     */
    public Set<String> getNeighbors(String s)
    {
        Set<String> n = new HashSet<String>();
        for (Edge ele: myEdges) {
            if (ele.getA().equals(s)) {
                n.add(ele.getB());
            }
        }
        for (Edge ele: myEdges) {
            if (ele.getB().equals(s)) {
                n.add(ele.getA());
            }
        }
        return n;
    }

    /*
     *   two graphs are equal iff both graphs have the same vertices and the same edges.
     */
    public boolean equals(Object obj)
    {
        DirectedGraph x = (DirectedGraph) obj;
        if (myVertices.equals(x.myVertices) && myEdges.equals(x.myEdges)) return true;
        return false;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   An edge incident on a single vertex is called a loop.
     */
    public boolean hasLoop()
    {
        for (Edge ele: myEdges) {
            if (ele.getA().equals(ele.getB())) return true;
        }
        return false;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   Two Edges associated with the same vertices are said to be parallel edges
     */
    public boolean hasParallelEdges()
    {
        for (Edge ele: myEdges) {
            for (Edge ele1: myEdges) {
                if (ele.getA().equals(ele1.getB()) && ele.getB().equals(ele1.getA())) return true;
            }
        }
        return false;
    }

    /*
     *   see top of page 379 for defintion of loop:
     *   
     *   A vertex not incident on any edge is called an isolated vertex
     *   A vertex incident on itself (i.e., a loop) is NOT isolated
     *   
     *   returns a List of all Isolted Vertices.  If there are not Isolated vertices, return an empty List
     */
    public List<String> getAllIsolatedVertices()
    {
        ArrayList<String> ans = new ArrayList<String>();
        for (String ele: myVertices) {
            boolean x = true;
            for (Edge ele1: myEdges) {
                if (ele1.getA().equals(ele) || ele1.getB().equals(ele)) x = false;
            }
            if (x) ans.add(ele);
        }
        return ans;
    }

    /*
     *  precondition:   myVertices.contains(v) == true
     *  postcondition:  no side effects
     *    returns the number of edges incident on v
     *    
     *  note the sentence that states:
     *      (By definition, each loop on v contributes 2 to the degree of v)
     *    
     *    see page 392
     */
    public int getVertexDegree(String v)
    {
        int n = 0;
        for (Edge ele: myEdges) {
            if (ele.getA().equals(v)) {
                n++;
            }
        }
        for (Edge ele: myEdges) {
            if (ele.getB().equals(v)) {
                n++;
            }
        }
        return n;
    }

    /*
     *     A graph is said to be even if every vertex has even degree
     *     
     *     returns true every vertex has even degree
     *             false otherwise
     */
    public boolean isEvenGraph()
    {
        for (String ele: myVertices) {
            if (getVertexDegree(ele) % 2 == 1) return false;
        }
        return true;
    }

    /*
     *   returns the union DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = union of this.myVertices and g.myVertices
     *        myEdges = union of this.myEdges and g.myEdges
     */
    public DirectedGraph union(DirectedGraph g)
    {
        DirectedGraph ans = new DirectedGraph(new HashSet<String>());
        for (String ele: myVertices) {
            ans.myVertices.add(ele);
        }
        for (String ele: g.myVertices) {
            ans.myVertices.add(ele);
        }
        for (Edge ele: myEdges) {
            ans.myEdges.add(ele);
        }
        for (Edge ele: g.myEdges) {
            ans.myEdges.add(ele);
        }
        return ans;
    }

    /*
     *   returns the intersection DirectGraoh this . and DirectedGraph g
     *   return a DirectedGraph with:
     *        myVertices = intersection of this.myVertices and g.myVertices
     *        myEdges = intersection of this.myEdges and g.myEdges
     */
    public DirectedGraph intersection(DirectedGraph g)
    {
        DirectedGraph ans = new DirectedGraph(new HashSet<String>());
        for (String ele: myVertices) {
            for (String ele1: g.myVertices) {
                if (ele.equals(ele1)) {
                    ans.myVertices.add(ele);
                }
            }
        }
        for (Edge ele: myEdges) {
            for (Edge ele1: g.myEdges) {
                if (ele.equals(ele1)) {
                    ans.myEdges.add(ele);
                }
            }
        }
        return ans;
    }

    /*
     *    use definition of Bipartite on page 383
     *       intersection is empty
     *       union == this
     *    Each edge in this.myEdges has one vertex in v1 and one vertex in v2   
     *    
     *    returns true if v1 and v2 form a Biparitite of this Directed Graph
     *    
     *    returns false otherwise
     */
    public boolean isBipartite(Set<String> v1, Set<String> v2)
    {
        for (Edge ele: myEdges) {
            if (v1.contains(ele.getA()) && v1.contains(ele.getB()) || v2.contains(ele.getA()) && v2.contains(ele.getB())) return false;
        }
        return true;
    }

    /*
     *   see page 388
     *   
     *   precondition:  myVertices.contains(v) == true  && myVertices.contains(w) == true
     *                  v and w may be the same vertex, i.e. v.equals(w) may be true
     *                  
     *                  A path must contain at least two different vertices.
     *                  This imples that a single isolated vertex is not a path
     *                  and a loop by itself is not a path
     *                  
     *   returns true iff there exist a path from v to w of any length and the path contains two different vertices.
     *   
     *       v and w
     */
    public void nextNode(String node, String target, Map<Edge, Boolean> visited) {
        for (Edge ele: myEdges) {
            if (ele.getA().equals(ele.getB())) continue;
            if (ele.getA().equals(node)) {
                if (ele.getB().equals(target)) anshasPath= true;
                Edge x = new Edge(node, ele.getB());
                if (!visited.get(x)) {
                    visited.put(x,true);
                    nextNode(ele.getB(), target, visited);
                }
            }
        }
    }
    public boolean hasPath(String v, String w)
    {
        anshasPath = false;
        visited = new HashMap<Edge, Boolean>();
        for (Edge ele: myEdges) {
            visited.put(ele,false);
        }
        nextNode(v, w, visited);
        if (anshasPath) return true;
        return false;
    }

    /*
     *   see page 388 for definition
     *   
     *   A graph is connected if given any two vertices v and w, there exist a path from v to w
     */
    public boolean isConnectedGraph()
    {
        for (String ele: myVertices) {
            for (String ele1: myVertices) {
                if (!hasPath(ele,ele1)) return false;
            }
        }
        return true;
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       myVertices.contains(p.get(k)) == true for all k, 0 <= k < p.size()
     *       p.get(k).length() == 1 for all k, 0 <= k < p.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *       
     *    returns true iff there is a path from p.get(0) to p.get(p.size()-1) with no repeated Vertices
     *            yes, you need to make sure myEdges contains the Edges required in p
     */
    public boolean isSimplePath(List<String> p)
    {
        Set<String> checkD = new HashSet<String>();
        for (String ele: p) {
            checkD.add(ele);
        }
        if (checkD.size() != p.size()) return false;
        for (int i = 0; i < p.size()-1; i++) {
            Edge x = new Edge(p.get(i),p.get(i+1));
            if (!myEdges.contains(x)) return false;
        }
        return true;
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postcondition:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a path of nonzerolength from c.get(0) to c.get(c.size()-1) with no repeated edges
     *            yes, you need to make sure myEdges contains the Edges required in c
     */
    public boolean isCycle(List<String> c)
    {
        if (c.size() == 1) return false;
        for (int i = 0; i < c.size()-1; i++) {
            Edge x = new Edge(c.get(i),c.get(i+1));
            if (!myEdges.contains(x)) return false;
        }
        return true; 
    }

    /*
     *    See page 391
     *    
     *    precondition:
     *       c.get(0).equals(c.get(c.size()-1)) == true
     *       myVertices.contains(c.get(k)) == true for all k, 0 <= k < c.size()
     *       c.get(k).length() == 1 for all k, 0 <= k < c.size()
     *    postconditino:
     *       myVertices & myEdges are not altered
     *
     *    returns true iff there is a cycle from c.get(0) to c.get(c.size()-1) in which, except for beginning and ending vertices, 
     *                     there are no repeated vertices.
     *            yes, you need to make sure myEdges contains the Edges required in c
     */
    public boolean isSimpleCycle(List<String> sc)
    {
        Set<String> checkD = new HashSet<String>();
        for (String ele: sc) {
            checkD.add(ele);
        }
        if (checkD.size() != sc.size()-1) return false;
        for (int i = 0; i < sc.size()-1; i++) {
            Edge x = new Edge(sc.get(i),sc.get(i+1));
            if (!myEdges.contains(x)) return false;
        }
        return true;
    }

    /*
     *   precondition:
     *       v.length() == 1;
     *       myVertices.contains(v) == true
     *
     *   See page 391 for defintion of a cycle
     *      A cycle (or circuit) is a path of nonzero length from v to v with no repeated edges
     *      loops can form a simple cycle, that is, the path "vv" is consider a simple cycle in this method
     *
     *   return
     *       A String containing a list vertices which form a simple cycle from v to v
     *          The first and last vertice of the String should be v, e.g.:  "v.....v"
     *              and no other vertice should be repeated in the String
     *       null if a simple cycle does not exist.
     */
    public void simplehelper(String node, String target, String ans, Map<String, Boolean> visited) {
        for (Edge ele: myEdges) {
            if (ele.getA().equals(node)) {
                if (ele.getB().equals(target)) {
                    simplehasPath = true;
                    pAns = ans + ele.getB();
                }
                if (!visited.get(ele.getB())) {
                    ans += ele.getB();
                    visited.put(ele.getB(),true);
                    simplehelper(ele.getB(), target, ans, visited);
                }
            }
        }
    }
    public String getSimpleCycle(String v)
    {
        Map<String, Boolean> visited = new HashMap<String, Boolean>();
        String ans = v;
        for (String ele: myVertices) {
            visited.put(ele, false);
        }
        simplehelper(v, v, ans, visited); 
        if (!simplehasPath) return null;
        return pAns;
    }
}