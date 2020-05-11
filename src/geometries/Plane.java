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

public class Plane implements Geometry{
    /**
     * class Plane contains point3d and normal vector
     */
    Point3D _p;
    Vector _normal;

    /**
     * ctor with 3 point3d parameters
     *
     * @param p1
     * @param p2
     * @param p3
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        _p = p1;
        _normal=(p2.subtract(p1).crossProduct(p3.subtract(p1))).normalize();
    }

    /**
     * ctor with 1 Point3D and 1 Vector parameters
     *
     * @param p
     * @param n
     */
    public Plane(Point3D p, Vector n) {
        _p = p;
        _normal = n.normalized();
    }

    /**
     * @return Point3D
     */
    public Point3D get_p() {
        return _p;
    }

    /**
     * @return Vector
     */
    public Vector get_normal() {
        return _normal;
    }

    /**
     * meanwhile doesn't in use
     *
     * @param point
     * @return null
     */
    public Vector getNormal(Point3D point) {
        return _normal.normalized();
    }

    /**
     * meanwhile doesn't in use
     *
     * @return nO
     */
    public Vector getNormal() {
        return _normal;
    }

    public List<Point3D> findIntersections(Ray ray) {

        {
            // TODO Auto-generated method stub
            Point3D p0 = ray.getP();
            Vector v = ray.getV();

            if (_p.subtract(p0).length() == 0) //(Q0=P0)
                return null;

            double t = (_normal.dotProduct(_p.subtract(p0))) / (_normal.dotProduct(v));

            if (_normal.dotProduct(v) == 0)
                return null;

            if (t <= 0)
                return null;
            Point3D p = (ray.getTargetPoint(t));
            return List.of(p);
        }


    }
}
