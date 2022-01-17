import processing.core.PApplet;
public class PowerShot extends Movement
{
    private PApplet app;
    public PowerShot(PApplet app, Player p)
    {
        super(app);
        myCenterX = p.getX();
        myCenterY = p.getY();
        //myPointDirection = p.getAngle(p2);
        myVelocityX = (float) (8 * p.getVelocityX());
        myVelocityY = (float) (8 * p.getVelocityY());
        myRed = p.getRed();
        myBlu = p.getBlu();
        myGreen = p.getGreen();
        corners = 3;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -20;
        yCorners[0] = 0;
        xCorners[1] = 20;
        yCorners[1] = 0;
        xCorners[2] = 0;
        yCorners[2] = 20;
    }
    //
    public void setX(int x)
    {
        myCenterX = x;
    }
    public int getX()
    {
        return (int)myCenterX;
    }
    public void setY(int y)
    {
        myCenterY = (double)(y);
    }
    public int getY()
    {
        return (int)myCenterY;
    }
    public void setVelocityX(float x)
    {
        myVelocityX = x;
    }
    public float getVelocityX()
    {
        return myVelocityX;
    }
    public void setVelocityY(float y)
    {
        myVelocityY = y;
    }
    public float getVelocityY()
    {
        return myVelocityY;
    }
    public void setPointDirection(int degrees)
    {
        myPointDirection = (double)(degrees);
    }
    public double getPointDirection()
    {
        return myPointDirection;
    }
    
}