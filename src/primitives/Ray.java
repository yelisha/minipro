/**
 *
 */
package primitives;
import static primitives.Util.isZero;
/**
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Ray {

    /**
     * A class that represent a ray with Point3D, start in a point and goes to a specific direction
     */
    Vector v;
    Point3D p;
    /**
     * ctor with 1 Vector and 1 Point3D parameters
     * @param _v
     * @param _p
     */
    public Ray(Vector _v,Point3D _p)
    {
        // TODO Auto-generated constructor stub

        v=_v.normalize();
        p=_p;
    }
    /**
     * copy ctor
     * @param r
     */
    public Ray(Ray r) {
        // TODO Auto-generated constructor stub
        v=r.v.normalize();
        p=r.p;
    }

    /**
     * @return the v
     */
    public Vector getV() {
        return v;
    }
    /**
     * @return the p
     */
    public Point3D getP() {
        return p;
    }
    /**
     *
     * @param r
     * @return true if the 2 rays equal and false if they don't
     */
    public boolean equals(Object obj)
    {
        if (this == obj) {
            return true;
        }
        if (obj == null) return false;
        if (!(obj instanceof Ray)) {
            return false;
        }
        Ray other = (Ray) obj;
        return p.equals(other.p) && v.equals(other.v);
    }
    /**
     * @param args
     */



    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * @author  Liel Lugasi 211327804, Yael Elisha 207486358
     * @param length
     * @return new Point3D
     */
    public Point3D getTargetPoint(double length) {
        return isZero(length ) ? p : p.add(v.scale(length));
    }

    @Override
    public String toString() {
        return "Ray [v=" + v + ", p=" + p + "]";
    }

}
