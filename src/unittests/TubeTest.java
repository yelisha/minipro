package unittests;

//import org.junit.jupiter.api.Test;

import geometries.Tube;
import org.junit.Test;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import static org.junit.Assert.assertEquals;
public class TubeTest {

    @Test
    public void getNormal()
    {
        Ray r=new Ray(new Vector(0,0,1),new Point3D(0,0,0));
        Tube t=new Tube(r,1);
        Point3D p=new Point3D(1,0,1);
        Vector normal=t.getNormal(p);
        assertEquals("bad normal to tube",0,r.getV().dotProduct(normal),0.0001);
    }
}

