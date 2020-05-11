package geometries;
/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public abstract class RadialGeometry implements Geometry
{
    /**
     * An abstract class that represents all the geometries with a radius
     */
    double _radius;
    /**
     * ctor with 1 double paarameter
     * @param r
     */
    public    RadialGeometry(double r)
    {
        _radius=r;
    }
    /**
     * copy ctor
     * @param r
     */
    public    RadialGeometry(RadialGeometry r)
    {
        _radius=r._radius;
    }
    /**
     * @return
     */
    public double get_radius()
    {
        return _radius;
    }
}
