package unittests;
import geometries.Plane;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
public class PlaneTest {
    @Test
    public void get_normal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Plane p = new Plane(new Point3D(1, 2, 3), new Vector(new Point3D(1, 0, 0)));
        Vector v = new Vector(new Point3D(1, 0, 0));
        double d = p.getNormal(new Point3D(1, 2, 3)).length();

        assertEquals("Wrong normal for plan", v, p.get_normal());
        // assertEquals("Wrong normal to plane", new Vector(new Point3D(1, 0, 0)), p.getNormal(new Point3D(1, 2, 3)));

    }

    @Test
    public void findIntersectionsTest() {

        Plane p = new Plane(new Point3D(2, 1, 1), new Vector(1, 0, 0));
        // ============ Equivalence Partitions Tests ==============

        //Ray's linen either orthogonal nor parallel

// TC01: Ray's line intersects the plane (1 point)
        assertEquals("Ray's line intersects the plane triangle", List.of(new Point3D(2, 1, 2)), p.findIntersections(new Ray(new Vector(-1, -1, 2), new Point3D(3, 2, 0))));
        // TC02: Ray's line doesn't intersects the plane (0 point)
        assertNull("Ray's line  not intersects the plane triangle", p.findIntersections(new Ray(new Vector(0.32, -0.75, 0.33), new Point3D(2.29, -0.92, 0))));

        // =============== Boundary Values Tests ==================

        // TC03: Ray is neither orthogonal nor parallel to and begins at the plane
        assertEquals("Ray's line in the plane triangle", null, p.findIntersections(new Ray(new Vector(-4, 1.39, -1.2), new Point3D(-0.2, 0.6, 1.2))));

        // TC04: Ray's line  parallel to the plane and  not included in the plane
        assertNull("Ray's line intersects the plane triangle",p.findIntersections(new Ray(new Vector(-0.69,-0.32,-0.65),new Point3D(0.59,2.38,0))));


    }
}

