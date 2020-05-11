package geometries;

//import elements.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Sphere extends RadialGeometry {
    /**
     * Represents a sphere, with a center point and a radius
     */
    Point3D p;

    /**
     * ctor with 1 Point3D and 1 double parameter
     *
     * @param _p
     * @param r
     */
    public Sphere(Point3D _p, double r) {
        super(r);
        p = _p;

    }

    /**
     * copy ctor
     *
     * @param r
     */
    public Sphere(Sphere r) {
        super(r);
        p = r.p;

    }

    /**
     * returns the normal to the sphere in specific point
     *
     * @param point
     * @return normal
     */

    public Vector getNormal(Point3D point) {

        Vector vnew = new Vector(point.subtract(p));
        return vnew.normalized();
    }

    public List<Point3D> findIntersections(Ray ray) {
        Point3D p0 = ray.getP();
        Vector v = ray.getV();
        Vector u;
        try {
            u = p.subtract(p0);   // p0 == _center
        } catch (IllegalArgumentException e) {
            return List.of(new Point3D((ray.getTargetPoint(_radius))));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = (tm == 0) ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = alignZero(_radius * _radius - dSquared);

        if (thSquared <= 0) return null;

        double th = alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;

        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) {
            return List.of(
                    new Point3D((ray.getTargetPoint(t1)))
                    , new Point3D((ray.getTargetPoint(t2)))); //P1 , P2
        }
        if (t1 > 0)
            return List.of(new Point3D((ray.getTargetPoint(t1))));
        else
            return List.of(new Point3D((ray.getTargetPoint(t2))));

    }

}

