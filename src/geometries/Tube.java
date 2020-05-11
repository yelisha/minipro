package geometries;
import primitives.*;

import java.util.List;

/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Tube extends RadialGeometry
{
    /**
     * Represents a tube with a ray and a radius
     */
    Ray r;
    /**
     * ctor with 1 Ray and 1 double parameter
     * @param _r
     * @param d
     */
    public Tube(Ray _r,double d)
    {
        super(d);
        r=_r;
    }
    /**
     * copy ctor
     * @param t
     */
    public Tube(Tube t)
    {
        super(t);
        r=t.r;
    }
    /**
     * returns the normal for the tube in specific point
     * @param point
     * @return normal
     */
    public Vector getNormal(Point3D point)
    {
        Vector temp=new Vector(point.subtract(r.getP()));
        double t=r.getV().dotProduct(temp);
        Point3D o=new Point3D(r.getP().add(r.getV().scale(t)));
        Vector normal=new Vector(point.subtract(o));
        return normal;
    }
    public List<Point3D> findIntersections(Ray ray)
    {return null;}
}
