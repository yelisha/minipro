package elements;

import primitives.*;
public class Camera {
    Point3D pos;
    Vector vTo;
    Vector vUp;
    Vector vRight;

    public Point3D getPos() {
        return new Point3D(pos);
    }

    public Vector getvTo() {
        return new Vector(vTo);
    }

    public Vector getvUp() {
        return new Vector(vUp);
    }

    public Vector getvRight() {
        return new Vector(vRight);
    }

    public Camera(Point3D _pos, Vector _vTo, Vector _vUp)
    {/*
        double z = _vTo.dotProduct(_vUp);
        if (z == 0)
        {
            Point3D pos = new Point3D(_pos);
             vTo = _vTo.normalized();
             vUp = _vUp.normalize();
            Vector vRight = new Vector(vUp.crossProduct(vTo).normalize());
        }
        else
            throw new IllegalArgumentException("The vectors must be orthogonal");
*/
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        pos = new Point3D(_pos);
        vTo = _vTo.normalized();
        vUp = _vUp.normalized();

        vRight = vTo.crossProduct(vUp).normalize();



    }


    public Ray constructRayThroughPixel (int nX, int nY, int j, int i, double screenDistance, double screenWidth, double screenHeight)
    {
        if (Util.isZero(screenDistance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D	Pc = pos.add(vTo.scale(screenDistance)); //the point in the center of the view plane -->Pc=P0+dVto

        double Ry = screenHeight/nY; //height of one pixel
        double Rx = screenWidth/nX;  //width of one pixel

        double yi = (i-nY/2d)*Ry + Ry/2d; //distance to go from Pc-left or right
        double xj = (j-nX/2d)*Rx + Rx/2d; //distance to go from Pc-up or down

        //Pi,j-where we hit the view plane with the ray from P0

        Point3D Pij = Pc;

        if (!Util.isZero(xj)) {
            Pij = Pij.add(vRight.scale(xj));
        }
        if (!Util.isZero(yi)) {
            Pij = Pij.subtract(vUp.scale(yi)); // Pij.add(_vUp.scale(-yi))
        }
        Vector vij = Pij.subtract(pos).normalize(); //direction vector

        return new Ray( vij,pos);
    }




}
