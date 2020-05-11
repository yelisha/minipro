package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Cylinder extends RadialGeometry
{
    /**
     * Represents a cylinder with a height, ray and radius
     */

    double h;
    /**
     * ctor with 2 double parameters
     * @param _h
     * @param r
     */
    public Cylinder(double _h,double r)
    {
        super(r);
        h=_h;

    }
    /**
     * ctor with Cylinder parameter
     * @param t
     */
    public Cylinder(Cylinder t)
    {
        super(t);
        h=t.h;

    }
    /**
     * meanwhile doesnt in use
     * @param point
     * @return null
     */
    public Vector getNormal(Point3D point) {
        return null;
    }
    public List<Point3D> findIntersections(Ray ray)
    {return null;}

}
