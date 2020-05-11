package unittests;

import org.junit.jupiter.api.Test;
import primitives.Vector;

import static org.junit.Assert.*;
//import primitives.Util..*;
/**
 * @author  Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class VectorTest {

    /**
     * Test method for {@link primitives.Vector#subtract(primitives.Vector)}.
     */
    @Test

    public void testSubtract() {

// ============ Equivalence Partitions Tests ==============

        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(1, -4, 3);
        Vector v3 = new Vector(0, 6, 0);
        assertEquals("wrong subtract",v3.length(),v1.subtract(v2).length(),0.0001);
//Vector r=new Vector(0, 1, 0);
//assertEquals("wrong subtract", new Vector(0,6,0),v1.subtract(v2));
        // assertEquals("Wrong Subtract", new Vector(0, 1, 0), v1.subtract(v2));
        // assertTrue("Wrong Subtract",isZero()
// =============== Boundary Values Tests ==================
        try {
            v3=new Vector(1,1,1);
            Vector v4=new Vector(1,1,1);
            v3.subtract(v4);
            fail("Vector (0,0,0) shouldnt be valid");
        }
        catch  (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!= null);
        }
    }


    /**
     * Test method for {@link primitives.Vector add(primitives.Vector)}.
     */

    @Test
    public void testAdd() {
// ============ Equivalence Partitions Tests ==============
        Vector v1= new Vector(1,1,1);
        Vector v2 = new Vector(2,2,2);
        Vector v3 = new Vector(3,3,3);
        assertEquals("Wrong Add",v3, v1.add(v2));
//assertTrue("Wrong Add",v3.length()==v1.add(v2).length());
/*double x=v3.getP().getX().get()-v1.getP().getX().get();
double y=v3.getP().getY().get()-v1.getP().getY().get();
double z=v3.getP().getZ().get()-v1.getP().getZ().get();
assertTrue("Wrong Subtract",(x+y+z)==0);*/
//assertEquals("Wrong Subtract",new Vector(2,-2,6), v1.add(v2));

// =============== Boundary Values Tests ==================
        try {
            v1= new Vector(1,1,1);
            Vector v4= new Vector(-1,-1,-1);
            v1.add(v4);
            fail("Vector (0,0,0) shouldn't valid");
        }
        catch (IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!=null);
        }
    }


//Test method for {@link primitives.Vector#scale(double)}.

    @Test
    public void testScale() {
// ============ Equivalence Partitions Tests ==============
        Vector v1 =new Vector(1,2,3);
        Vector v2 =new Vector(2,4,6);
//assertTrue("Wrong scale",v2.length()==v1.scale(2).length());
        assertEquals("Wrong scale", new Vector(2,4,6),v1.scale(2));
// =============== Boundary Values Tests ==================
        try {
            v1.scale(0);
            fail("Vector (0,0,0) not valid");
        }
        catch(IllegalArgumentException e)
        {
            assertTrue(e.getMessage()!=null);
        }
    }
    /**
     * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
     */
    @Test

    public void testDotProduct() {
// ============ Equivalence Partitions Tests ==============
        Vector v1= new Vector(1, 2, 3);
        Vector v2 = new Vector(0, 3, -2);

        assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", v1.dotProduct(v2)==0);

    }

    /**
     * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
     */
    @Test

    public void testCrossProduct() {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(-2, -4, -6);

        // ============ Equivalence Partitions Tests ==============
        Vector v3 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v3);

        // Test that length of cross-product is proper (orthogonal vectors taken for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v3.length(), vr.length(), 0.00001);

        // Test cross-product result orthogonality to its operands
        assertEquals("crossProduct() result is not orthogonal to 1st operand",0, vr.dotProduct(v1),0.00001);
        assertEquals("crossProduct() result is not orthogonal to 2nd operand",0, vr.dotProduct(v3),0.00001);

        // =============== Boundary Values Tests ==================
        // test zero vector from cross-productof co-lined vectors
        try {
            v1.crossProduct(v2);
            fail("crossProduct() for parallel vectors does not throw an exception");
        } catch (Exception e) {}
    }




    /**
     * Test method for {@link primitives.Vector#lengthSquared()}.
     */
    @Test
    public void testLengthSquared() {
// ============ Equivalence Partitions Tests ==============
        Vector v1=new Vector(1,2,3);
        assertEquals("Wrong lengthSqured",14,v1.lengthSquared(),0.00001);
        Vector v2=new Vector(-1,-2,-3);
        assertEquals("Wrong lengthSqured",14,v2.lengthSquared(),0.000001);

    }

    /**
     * Test method for {@link primitives.Vector#length()}.
     */
    @Test
    public void testLength()
    {
        Vector v1=new Vector(4,0,0);
        assertEquals("Wrong length",4,v1.length(),0.00001);
        Vector v2=new Vector(-4,0,0);
        assertEquals("Wrong length",4,v2.length(),0.000001);

    }

    /**
     * Test method for {@link primitives.Vector#normalize()}.
     */
    @Test
    public void testNormalize()
    {
        Vector v1=new Vector(4,0,0);
        v1.normalize();
        Vector v2=new Vector(1,0,0);
        assertEquals("Wrong Normalize",v1,v2);
    }

    /**
     * Test method for {@link primitives.Vector#normalized()}.
     */

    @Test
    public void testNormalized()
    {
        Vector v1=new Vector(4,0,0);
        Vector v2=v1.normalized();
        Vector v3=new Vector(1,0,0);
        assertEquals("Wrong Normalized",v2,v3);

    }

}

