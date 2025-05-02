/*    implewment (almost) ALL the methods in this class.
 *
 *    But first, you need to finish implementing the OrderedPair class
 *    
 *    The first tester provided test the OrderedPair class methods equals and hashCode
 *    which I believe are important methods that you may use or I use in the tester when I create
 *    a HashSet.  This tester method is only for your benefit as it is not included the stipulator tester.
 */
import java.util.*;
import java.lang.Math;
/**
 *
 * @author  
 * @version (a version number or a date)
 */
public class FunctionsChapter3Style
{

    private Set<String> domain;
    private Set<String> coDomain;
    private Set<OrderedPair> relation;
    public FunctionsChapter3Style(Set<String> d, Set<String> co)
    {
        domain = new HashSet<>(d);
        coDomain = new HashSet<>(co);
        relation = new HashSet<>();
    }

    public FunctionsChapter3Style(Set<String> d, Set<String> co, Set<OrderedPair> r)
    {
        domain = new HashSet<>(d);
        coDomain = new HashSet<>(co);
        relation = new HashSet<>(r);
    }

    /*
     *    Not tested.
     *    
     *    I admit that I did use this method a couple of times.
     *    It came in very handy and SHORTEN my code and GREATLY simplified some methods
     *    I will let you figure out which ones and how
     *    
     *    returns a String of the form: [(a,b), (c,d), ...(v,w)]
     */
    public String getRelString()
    {
        String ans = "";
        ans += "[";
        for (OrderedPair x : relation) {
            ans += "(" + x.getX() + "," + x.getY() + ")";
        }
        ans += "]";
        return ans;
    }

    /*
     *    replaces the current relation instance variable with op
     *    
     *    YES - this method gets used in the my (stipulator) tester
     */
    public void setRelation(Set<OrderedPair> op)
    {
        relation = new HashSet<>(op);
    }

    /*
     *    returns the current relation instance variable
     */
    public Set<OrderedPair> getRelation()
    {  
        return relation;
    }

    /*
     *    retruns the number of Order Pairs in the relation
     */
    public int size()
    {
        return relation.size();
    }

    /*
     *    returns true if the array of Order Pairs forms a function
     *    returns false otherwise
     */
    public boolean isFunction()
    {
        Set<String> ff = new HashSet<>();
        for (OrderedPair pair : relation) {
            String x = pair.getX();
            if (ff.contains(x)) {
                return false;
            }
            ff.add(x);
        }
        return true;
    }

    /*
     *    A function f from X to Y is said to be one to one if
     *    for each y in Y, there is at most one x in X with f(x) = y
     *
     *    returns true if array of order Pairs is a function and the function is one to one
     *    returns false otherwise
     */
    public boolean is1To1()
    {
        if (!isFunction()) return false;
        Set<String> ee = new HashSet<>();
        for (OrderedPair pair : relation) {
            String y = pair.getY();
            if (ee.contains(y)) {
                return false;
            }
            ee.add(y);
        }
        return true;
    }

    /*
     *    A function from X to Y is said to be onto if
     *    the range of f == Y
     *
     *    returns true if array of order Pairs is a function and the function is onto
     *    returns false otherwise
     */
    public boolean isOnTo()
    {
        if (!isFunction()) return false;
        Set<String> mappedYValues = new HashSet<>();
        for (OrderedPair pair : relation) {
            mappedYValues.add(pair.getY());
        }
        return mappedYValues.containsAll(coDomain);
    }

    /*
     *     returns true if the array of order Pairs is a function and the function is bijective
     *              that is both one to one and onto
     *     returns false otherwise
     */
    public boolean isBijective()
    {
        return isFunction() && is1To1() && isOnTo();
    }

    /*
     *   precondition:  getRelation() and op (the parameter) are both functions.  
     *                  Domain of op is a subset of coDomain of getRelation()
     *  
     *   returns a new FunctionsChapter3Style Object.
     *   The domain of new FunctionsChapter3Style Object is this.domain
     *   The coDomain is opCoDomain (the paramenter)
     *  
     *   The new function is the composition op( this.getRelation (this.domain) )
     */
    public FunctionsChapter3Style getComposition(Set<OrderedPair> op, Set<String> opCoDomain)
    {
        Set<OrderedPair> composedRelation = new HashSet<>();

        for (OrderedPair a : relation) {
            for (OrderedPair as : op) {
                if (a.getY().equals(as.getX())) {
                    composedRelation.add(new OrderedPair(a.getX(), as.getY()));
                }
            }
        }

        return new FunctionsChapter3Style(domain, opCoDomain, composedRelation);
    }

    /*
     *   precondition:  rel is a function.
     *   rel does not have to be both 1-1 and onto
     *   the inverse does not need to be a function
     */
    public OrderedPair[] getInverse()
    {
        OrderedPair[] f = new OrderedPair[relation.size()];
        int x = 0;
        for (OrderedPair jh : relation) {
            f[x] = new OrderedPair(jh.getY(), jh.getX());
            x++;
        }
        return f;
    }

    /*
     * A relation is reflexive if (x, x) in R for every x in X. X is the domain
     *
     *       returns true if the current relation is reflexive
     *       returns false otherwise
     */
    public boolean isReflexive()
    {
        for (String x : domain) {
            boolean e = false;
            for (OrderedPair pair : relation) {
                if (pair.getX().equals(x) && pair.getY().equals(x)) {
                    e = true;
                    break;
                }
            }
            if (!e) {
                return false;
            }
        }
        return true;
    }

    /*
     *       A relation is symmetric if
     *       for all x, y in X, if (x,y) in R, then (y,x) in R
     *
     *       returns true if the current relation is symmetric
     *       returns false otherwise
     */
    public boolean isSymmetric()
    {
        for (OrderedPair  b: relation) {
            OrderedPair inv = new OrderedPair(b.getY(), b.getX());
            if (!relation.contains(inv)) {
                return false;
            }
        }
        return true;
    }

    /*
     *       A relation is Antisymmetric if
     *       for all x, y in X, if (x,y) in R, and (y,x) in R, then x = y
     *
     *    returns true if the current relation is Antisymmetric
     *    returns false otherwise
     */
    public boolean isAntiSymmetric()
    {
        for (OrderedPair x : relation) {
            for (OrderedPair y : relation) {
                if (!x.equals(y)) {
                    if (x.getX().equals(y.getY()) && x.getY().equals(y.getX())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
     *       A relation is transitive:
     *       if (a,b) and (b,c) then (a,c)
     *
     *       returns true if the current relation is transitive
     *       returns false otherwise
     */
    public boolean isTransitive()
    {
        for (OrderedPair pair1 : relation) {
            for (OrderedPair pair2 : relation) {
                if (pair1.getY().equals(pair2.getX())) {
                    OrderedPair transitivePair = new OrderedPair(pair1.getX(), pair2.getY());
                    if (!relation.contains(transitivePair)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*
     *    returns true is the relation is an Equivalence Relation
     *    returns false otherwise
     */
    public boolean isEquivalenceRelation()
    {
        if (isReflexive() && isSymmetric() && isTransitive()) return true;
        return false;
    }

    /*
     *    
     *    returns true is the relation is an Partially Order
     *    returns false otherwise
     */
    public boolean isPartiallyOrder()
    {
        if (isReflexive() && isAntiSymmetric() && isTransitive()) return true;
        return false;
    }

    /*
     *      return a Function with the same domain as getRelation,
     *       with getY().equals(s)
     */
    public FunctionsChapter3Style getConstant(String s)
    {
        Set<OrderedPair> constantRelation = new HashSet<>();
        for (String bv : domain) {
            constantRelation.add(new OrderedPair(bv, s));
        }
        return new FunctionsChapter3Style(domain, Collections.singleton(s), constantRelation);
    }

    /*
     *      not tested.
     *      Not sure why it is here.  I think I needed/used this functionality more than once,
     *      and therefore created a helper method-
     */
    public ArrayList<OrderedPair> getRel(String s)
    {
        ArrayList<OrderedPair> ed = new ArrayList<>();
        for (OrderedPair pair : relation) {
            if (pair.getX().equals(s) || pair.getY().equals(s)) {
                ed.add(pair);
            }
        }
        return ed;
    }
}
