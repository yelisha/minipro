/**
 *
 */
package primitives;
/**
 *
 * @author Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Point3D {

    /**
     * class Point3D. contains 3 coordinates
     */
    Coordinate x;
    Coordinate y;
    Coordinate z;
    public static Point3D Zero=new Point3D(0.0,0.0,0.0);
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        // TODO Auto-generated constructor stub
        /**
         *ctor with 3 coordinate parameters
         *@param x
         *@param y
         *@param z
         */
        x=_x;
        y=_y;
        z=_z;
    }
    public Point3D(double _x, double _y, double _z) {
        // TODO Auto-generated constructor stub
        /**
         * ctor with 3 double parameters
         *@param x
         *@param y
         *@param z
         */
        x=new Coordinate(_x);
        y=new Coordinate(_y);
        z=new Coordinate(_z);
    }
    public Point3D(Point3D other)
    {
        /**
         * copy ctor with Point3D paremeter
         *@param x
         *@param y
         *@param z
         */
        x=other.x;
        y=other.y;
        z=other.z;
    }

    /**
     * @return the x
     */
    public Coordinate getX() {
        return x;
    }
    /**
     * @return the y
     */
    public Coordinate getY() {
        return y;
    }
    /**
     * @return the z
     */
    public Coordinate getZ() {
        return z;
    }
    /**
     * @return hasshCode of Point3D
     */
    /**
     * @param point
     * @return true if the points equal and false if they don't
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Point3D))
            return false;
        Point3D oth = (Point3D) obj;
        return x.equals(oth.x) && y.equals(oth.y) && z.equals(oth.z);
    }

    /**
     * substracts between 2 points
     * @param p
     * @return new vector
     */
    public Vector subtract(Point3D p)
    {
        double a=p.x.get()-x.get();
        double b=p.y.get()-y.get();
        double c=p.z.get()-z.get();
        Point3D np=new Point3D(-a,-b,-c);
        Vector v=new Vector(np);
        return v;
    }

    public Point3D subtract(Vector v) {
        return new Point3D(this.x._coord - v.p.x._coord,
                this.y._coord - v.p.y._coord,
                this.z._coord - v.p.z._coord);
    }

    /**
     * add vector to point
     * @param v
     * @return new point
     */
    public Point3D add(Vector v)
    {
        if(v==null)
        { throw new IllegalArgumentException("Vector can not be null"); }
        double a=x.get()+v.p.x.get();
        double b=y.get()+v.p.y.get();
        double c=z.get()+v.p.z.get();
        Point3D np=new Point3D(a,b,c);
        return np;
    }
    /**
     * @param p
     * @return the squared distance between 2 points
     */
    public double distanceSquared(Point3D p)
    {
        return (x.get()-p.x.get())*(x.get()-p.x.get())+
                (y.get()-p.y.get())*(y.get()-p.y.get())+
                (z.get()-p.z.get())*(z.get()-p.z.get());
    }
    /**
     * @param p
     * @return the squared root of the distance between 2 points
     */
    public double distance(Point3D p)
    {
        double a=this.distanceSquared(p);
        return Math.sqrt(a);
    }

    /**
     * print the Point3D parameters
     * @param args
     */
    @Override
    public String toString() {
        return "Point3D [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }


}
