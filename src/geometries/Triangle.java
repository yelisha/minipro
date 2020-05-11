package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 *
 *  @author Liel Lugasi 211327804, Yael Elisha 207486358
 */
public class Triangle extends Polygon
{
    /**
     * A class represent a triangle, which is a polygon with 3 points
     * @param p1
     * @param p2
     * @param p3
     */

    public Triangle(Point3D p1,Point3D p2, Point3D p3)
    {
        super(p1,p2,p3);
    }
    @Override
    public List<Point3D> findIntersections(Ray ray) {
      /*  List<Point3D> intersections = _plane.findIntersections(ray);
        if (intersections == null) return null;

        Point3D p0 = ray.getP();
        Vector v = ray.getV();

        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0);
        Vector v3 = _vertices.get(2).subtract(p0);

        double s1 = v.dotProduct(v1.crossProduct(v2));
        if (isZero(s1)) return null;
        double s2 = v.dotProduct(v2.crossProduct(v3));
        if (isZero(s2)) return null;
        double s3 = v.dotProduct(v3.crossProduct(v1));
        if (isZero(s3)) return null;
        return ((s1 > 0 && s2 > 0 && s3 > 0) || (s1 < 0 && s2 < 0 && s3 < 0)) ? intersections : null;
*/
        // TODO Auto-generated method stub

        //We will find all Ray's intersection points with triangle's plane
        List<Point3D> intersec = _plane.findIntersections(ray);

        //if their are no intersection points with plane-their are no with triangle
        if (intersec == null)
            return null;

        Point3D p0 = ray.getP();
        Vector v = ray.getV();

        Vector v1 = _vertices.get(0).subtract(p0);
        Vector v2 = _vertices.get(1).subtract(p0);
        Vector v3 = _vertices.get(2).subtract(p0);

        //(p-p0)*N
        double sign1 = v.dotProduct(v1.crossProduct(v2));
        double sign2 = v.dotProduct(v2.crossProduct(v3));
        double sign3 = v.dotProduct(v3.crossProduct(v1));

        return ((sign1 > 0 && sign2 > 0 && sign3 > 0) || (sign1 < 0 && sign2 < 0 && sign3 < 0)) ? intersec : null; //if sign==0-->return null

    }
}

