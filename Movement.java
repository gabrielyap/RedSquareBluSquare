import processing.core.PApplet;

public abstract class Movement
{
    protected PApplet applet;
    protected int myRed, myBlu, myGreen;
    protected double myCenterX, myCenterY; //center coords
    protected int corners;
    protected int[] xCorners, yCorners;
    protected double myPointDirection;
    protected float myVelocityX, myVelocityY;
    public Movement(PApplet applet_)
    {
        applet = applet_;
    }
    //
    abstract public void setX(int x);
    
    abstract public int getX();
    
    abstract public void setY(int y);
    
    abstract public int getY();
    
    abstract public void setVelocityX(float x);   

    abstract public float getVelocityX();   

    abstract public void setVelocityY(float y);   

    abstract public float getVelocityY();   

    abstract public void setPointDirection(int degrees);   
    abstract public double getPointDirection();
    
    public void setRed(int r)
    {
        myRed = r;
    }
    public void setBlu(int b)
    {
        myBlu = b;
    }
    public void setGreen(int g)
    {
        myGreen = g;
    }
    public int getRed()
    {
        return myRed;
    }
    public int getBlu()
    {
        return myBlu;
    }
    public int getGreen()
    {
        return myGreen;
    }
    public void moveLR (double speed)
    {
        myVelocityX += speed;
    }
    public void moveUD (double speed)
    {
        myVelocityY += speed;
    }
    public void rotate (int nDegreesOfRotation)   
    {     
        myPointDirection += nDegreesOfRotation;   
    }   
    public void move()
    {
        myCenterX += myVelocityX;
        myCenterY += myVelocityY;
        if (myCenterX > applet.width)
        {
            myCenterX = applet.width;
        }   
        else if (myCenterX < 0)
        {
            myCenterX = 0;
        }
        if (myCenterY > applet.height)
        {
            myCenterY = applet.height;
        }
        else if (myCenterY < 0)
        {
            myCenterY = 0;
        }
    }   
    public void show()
    {
        applet.fill(myRed, myGreen, myBlu);
        applet.stroke(myRed, myGreen, myBlu);
        double dRadians = myPointDirection * (Math.PI / 180); 
        int xRotatedTranslated, yRotatedTranslated;  
        applet.beginShape();
        for(int nI = 0; nI < corners; nI++)    
        {     
            xRotatedTranslated = (int)((xCorners[nI] * Math.cos(dRadians)) - (yCorners[nI] * Math.sin(dRadians)) + myCenterX);     
            yRotatedTranslated = (int)((xCorners[nI] * Math.sin(dRadians)) + (yCorners[nI] * Math.cos(dRadians)) + myCenterY);      
            applet.vertex(xRotatedTranslated, yRotatedTranslated);    
        }        
        applet.endShape(applet.CLOSE);
    }
}