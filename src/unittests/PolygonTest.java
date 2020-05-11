/**
 *
 */
package unittests;


import geometries.Polygon;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Testing Polygons
 * @author
 *
 */
public class PolygonTest {

    /**
     * Test method for {@link geometries.Polygon#Polygon(primitives.Point3D, primitives.Point3D, primitives.Point3D, primitives.Point3D)}.
     */
    @Test
    public void testConstructor() {
        // ============ Equivalence Partitions Tests ==============

        // TC01: Correct concave quadrangular with vertices in correct order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(-1, 1, 1));
        } catch (IllegalArgumentException e) {
            fail("Failed constructing a correct polygon");
        }

        // TC02: Wrong vertices order
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(0, 1, 0),
                    new Point3D(1, 0, 0), new Point3D(-1, 1, 1));
            fail("Constructed a polygon with wrong order of vertices");
        } catch (IllegalArgumentException e) {}

        // TC03: Not in the same plane
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 2, 2));
            fail("Constructed a polygon with vertices that are not in the same plane");
        } catch (IllegalArgumentException e) {}

        // TC04: Concave quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0.5, 0.25, 0.5));
            fail("Constructed a concave polygon");
        } catch (IllegalArgumentException e) {}

        // =============== Boundary Values Tests ==================

        // TC10: Vertix on a side of a quadrangular
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0.5, 0.5));
            fail("Constructed a polygon with vertix on a side");
        } catch (IllegalArgumentException e) {}

        // TC11: Last point = first point
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 0, 1));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

        // TC12: Collocated points
        try {
            new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0),
                    new Point3D(0, 1, 0), new Point3D(0, 1, 0));
            fail("Constructed a polygon with vertice on a side");
        } catch (IllegalArgumentException e) {}

    }

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point3D)}.
     */
    @Test
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Polygon pl = new Polygon(new Point3D(0, 0, 1), new Point3D(1, 0, 0), new Point3D(0, 1, 0),
                new Point3D(-1, 1, 1));
        double sqrt3 = Math.sqrt(1d / 3);
        assertEquals("Bad normal to triangle", new Vector(sqrt3, sqrt3, sqrt3), pl.getNormal(new Point3D(0, 0, 1)));
    }
    @Test
    public  void findIntersections()
    {

        Polygon triangle =new Polygon(new Point3D(0,0,1),new Point3D(1,0,0), new Point3D(-1,0,0));

        Polygon t=new Polygon(new Point3D(1,1,0),new Point3D(1,3,0),new Point3D(1,2,1));
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is Inside triangle (1 point)
        assertEquals("Ray's line Inside triangle", List.of(new Point3D(1,2,0.5),t.findIntersections(new Ray(new Vector(1,0,0.5),new Point3D(0,2,0)))));

        // TC02: Ray's line is Outside triangle, against vertex (0 point)
        assertNull("Ray's line Outside triangle",t.findIntersections(new Ray(new Vector(1,0,0.5),new Point3D(0,2,0))));

        // TC03: Ray's line is Outside triangle, against  edge (0 point)
        assertNull("Ray's line  Outside triangle",t.findIntersections(new Ray(new Vector(1,-1.5,0.5),new Point3D(0,2,0))));

        // =============== Boundary Values Tests ==================

        // TC04: Ray's line is on the triangle's edge (1 point)
        assertEquals("Ray's line on triangle",List.of(new Point3D(1,2,0),t.findIntersections(new Ray(new Vector(1,0,0),new Point3D(0,2,0)))));

        // TC05: Ray's line is in the triangle's vertex (1 point)
        assertEquals("Ray's line on triangle",List.of(new Point3D(1,1,0),t.findIntersections(new Ray(new Vector(1,-1,0),new Point3D(0,2,0)))));

        // TC06: Ray's line is On edge's continuation (0 point)
        assertNull("Ray's line Outside triangle",t.findIntersections(new Ray(new Vector(1,-2,0),new Point3D(0,2,0))));

    }
}
