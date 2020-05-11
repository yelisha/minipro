package unittests;

import geometries.Geometries;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
public class GeometriesTest

{
    @Test
    public void findIntersectionsTest()
    {
        Plane plane=new Plane(new Point3D(0,1,0.5),new Vector(2,0,0));
        Triangle triangle=new Triangle(new Point3D(2,0,1.5),new Point3D(2.5,0,-1),new Point3D(2,1.5,0));
        Sphere sphere=new Sphere(new Point3D(4.5,0.5,0),1d);
        Geometries _geometries=new Geometries(plane,triangle, sphere);
        Geometries _geometries2=new Geometries();//an empty list of geometries
        // ============ Equivalence Partitions Tests ==============

        //TC01: Some geometries(but not all) have intersection points
        assertEquals("Some geometries have intersection points",1,
                _geometries.findIntersections(new Ray( new Vector(1.5, 0, 0),new Point3D(-1,2.5,0))).size());

        // =============== Boundary Values Tests ==================
        // TC02: An empty list ***
        assertEquals("An empty list",null,
                _geometries2.findIntersections(new Ray(new Vector(1.5, 0, 0),new Point3D(1,1.5,0))));
        // TC03: Non geometry has intersection points ***
        assertEquals("Non geometry has intersection points",null,
                _geometries.findIntersections(new Ray(new Vector(0,1.5, 0),new Point3D(-1.5,0,0))));
        // TC04: one geometry has intersection points***
        assertEquals("one geometry has intersection points", 2,_geometries.findIntersections(new Ray( new Vector(4.5,0,0),new Point3D(2.5,0.5,0))).size());
        // TC05: All geometries has intersection points
        assertEquals("All geometries has intersection points", 3,
                _geometries.findIntersections(new Ray( new Vector(1.5,0,0),new Point3D(-1.5,0,0))).size());

    }

}