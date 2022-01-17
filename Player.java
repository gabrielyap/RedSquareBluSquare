import processing.core.PApplet;
public class Player extends Movement
{
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
    
    public Player(PApplet app)
    {
        super(app);
        corners = 4;
        xCorners = new int[corners];
        yCorners = new int[corners];
        xCorners[0] = -40;
        yCorners[0] = -40;
        xCorners[1] = 40;
        yCorners[1] = -40;
        xCorners[2] = 40;
        yCorners[2] = 40;
        xCorners[3] = -40;
        yCorners[3] = 40;
        myCenterX = 0;
        myCenterY = 0;
        myVelocityX = 0;
        myVelocityY = 0;
    }
}