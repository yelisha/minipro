/**
 *
 */
package primitives;

import java.util.Objects;

/**
 * @author  Liel Lugasi 211327804, Yael Elisha 207486358
 *
 */
public class Vector {

    /**
     * class of Vector contains point3D
     */
    Point3D p;
    /**
     * copy ctor
     * @param vec
     */
    public Vector(Vector vec)
    {
        // TODO Auto-generated constructor stub
        p=vec.p;
    }
    /**
     * ctor with 1 Point3D parameter
     * @param otherp
     */
    public Vector(Point3D otherp)
    {
        // TODO Auto-generated constructor stub
        if(otherp.equals(Point3D.Zero))
        {
            throw new IllegalArgumentException ("Error! Vector's value can not be 0");
        }
        else
        {
            p=otherp;
        }

    }
    /**
     * ctor with 3 coordinate parametars
     * @param _x
     * @param _y
     * @param _z
     */
   /* public Vector(Coordinate _x, Coordinate _y, Coordinate _z)
    {
        // TODO Auto-generated constructor stub
        Point3D myp=new Point3D(_x,_y,_z);

        if(myp.equals(Point3D.Zero))
        {
            throw new IllegalArgumentException ("Error! Vector's value can not be 0");
        }
        else
        {
            p=myp;
        }
    }*/
    /**
     * ctor with 3 double parametars
     * @param _x
     * @param _y
     * @param _z
     */
    public Vector(double _x, double _y, double _z) {
        // TODO Auto-generated constructor stub
        Point3D myp=new Point3D(_x,_y,_z);
        if(myp.equals(Point3D.Zero))
        {
            throw new IllegalArgumentException ("Error! Vector's value can not be 0");
        }
        else
        {
            p=myp;
        }
    }
    /**
     *
     * @param v
     * @return true if the 2 vector equal and false if they don't
     */
    //public boolean equals(Object o)
    //{
    //return p.equals(o.p);

    //}

    /**
     * @return the p
     */
    public Point3D getP() {
        return p;
    }
    @Override
    public int hashCode() {
        return Objects.hash(p);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector other = (Vector) obj;
        return Objects.equals(p, other.p);
    }
    /**
     * gets a vector and returns a new one, Minus a vector from the current one
     * @param v
     * @return
     */
    public Vector subtract(Vector v)
    {
        return p.subtract(v.p);
    }
    /**
     * gets a vector and returns a new one, adds a vector to the current one
     * @param v
     * @return Vector
     */
    public Vector add(Vector v)
    {
        if(v==null)
        { throw new IllegalArgumentException("Vector can not be null"); }

        Point3D np=p.add(v);
        Vector nv=new Vector(np);
        return nv;


    }
    /**
     * gets a number and return a new vector that become from the current vector mult by the input number
     * @param d
     * @return Vector
     */
    public Vector scale(double d)
    {
        double a=p.x.get()*d;
        double b=p.y.get()*d;
        double c=p.z.get()*d;
        Point3D np=new Point3D(a,b,c);
        Vector v=new Vector(np);
        return v;
    }
    /**
     * dot product-gets a vector and returns the dot product of the input vector and the current one
     * @param v
     * @return double
     */
    public double dotProduct(Vector v)
    {
       return this.p.x.get() * v.p.x.get() + this.p.y.get() * v.p.y.get() + this.p.z.get() * v.p.z.get();

    }


    /**
     * gets a vector and returns the cross product vector between the input vector and the current one
     * @param v
     * @return Vector
     */
    public Vector crossProduct(Vector v)
    {
        return new Vector (p.y.get()*v.p.z.get()-p.z.get()*v.p.y.get(),
                -( p.x.get()*v.p.z.get()-p.z.get()*v.p.x.get()),
                p.x.get()*v.p.y.get()-p.y.get()*v.p.x.get());
    }
    /**
     * calculate the squared length of the current vector and returns it
     * @return double
     */
    public double lengthSquared()
    {
        return p.x.get()*p.x.get()+p.y.get()*p.y.get()+p.z.get()*p.z.get();
    }
    /**
     * returns the length of the current vector, using the lengthSquared func
     * @return double
     */
    public double length()
    {
        double a=this.lengthSquared();
        return Math.sqrt(a);
    }
    /**
     * normalizes the current vector
     * @return Vector
     */
    public Vector normalize()
    {
        double l=length();
        Vector v=new Vector(p.x.get()/l,p.y.get()/l,p.z.get()/l);
        this.p.x=v.p.x;
        this.p.y=v.p.y;
        this.p.z=v.p.z;
        return this;
    }
    /**
     * normalizes the current vector and returns the normal vector, using the normalize func
     * @return
     */
    public Vector normalized()
    {
        Vector v=new Vector(this);
        v.normalize();
        return v;
    }


    @Override
    public String toString() {
        return "Vector [p=" + p + "]";
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
