package geometries;
import primitives.Point3D;
import  primitives.Vector;
/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */

public interface Geometry extends Intersectable
/**
 * Geometry interface
 */
{
    public Vector getNormal (Point3D p);
}
