package unittests;

import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;
public class TriangleTest {

    @Test
   public void findIntersections()
    {
        /*Triangle triangle =new Triangle(new Point3D(0,0,1),new Point3D(1,0,0), new Point3D(-1,0,0));

        Polygon t=new Polygon(new Point3D(1,1,0),new Point3D(1,3,0),new Point3D(1,2,1));
        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is Inside triangle (1 point)
        assertEquals("Ray's line Inside triangle", List.of(new Point3D(1,2,0.5)),t.findIntersections(new Ray(new Vector(1,0,0.5),new Point3D(0,2,0))));

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
*/
        Triangle triangle =new Triangle(new Point3D(0,0,1),new Point3D(1,0,0), new Point3D(-1,0,0));

        // ============ Equivalence Partitions Tests ==============

        //TC01 Inside triangle
        assertEquals("Ray Inside the triangle",List.of(new Point3D(0,0,0.5)),triangle.findIntersections((new Ray(new Vector(0, -1, 0),new Point3D(0, 2, 0.5)))));
        //TC02 Outside against edge
        assertEquals("Ray starts outside against edge",null,triangle.findIntersections((new Ray(new Vector(0, 1, 0),new Point3D(0.5, -2, -1) ))));
        //TC03 Outside against vertex
        assertEquals("Ray starts outside against vertex",null,triangle.findIntersections((new Ray(new Vector(0, 1, 0),new Point3D(1.5, -2, -0.2)))));
        // =============== Boundary Values Tests ==================
        //TC04 Point is on edge
        assertEquals("Ray's point is on the edge",null,triangle.findIntersections((new Ray(new Vector(0, 1, 0),new Point3D(0.5, -2, 0)))));
        //TC05 Point is in vertex
        assertEquals("Ray's point is in vertex",null,triangle.findIntersections((new Ray(new Vector(0, 1, 0),new Point3D(1, -1, 0)))));
        //TC06 Point is On edge's continuation
        assertEquals("Ray's point is On edge's continuation",null,triangle.findIntersections((new Ray(new Vector(0, 1, 0),new Point3D(2, -2, 0)))));

    }
}