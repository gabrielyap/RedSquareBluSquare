import processing.core.PApplet;
import java.util.ArrayList;
public class KataGame extends PApplet
{
    Player p;
    Player p2;
    Bullet b;
    ArrayList<Bullet> bltList1 = new ArrayList<Bullet>();
    ArrayList<Bullet> bltList2 = new ArrayList<Bullet>();
    ArrayList<PowerShot> pwr1 = new ArrayList<PowerShot>();
    ArrayList<PowerShot> pwr2 = new ArrayList<PowerShot>();
    int framelimiter, framelimiter2;
    int bulletLimiter, bulletLimiter2;
    int powerCount1, powerCount2;
    boolean redWin = false;
    boolean bluWin = false;
    public static void main(String[] args)
    {
        PApplet.main(new String[] {"KataGame"});
        MusicTest music = new MusicTest();
        music.playMusic("TimeLeaper.wav");
    }

    public void settings()
    {
        size(1600, 800);
    }

    public void setup()
    {
        p = new Player(this);
        p2 = new Player(this);
        p.setX(400);
        p.setY(600);
        p2.setX(1200);
        p2.setY(200);
        p.setRed(255);
        p2.setBlu(255);
        framelimiter = 0;
        framelimiter2 = 0;
        System.out.println("RED SQUARE BLU SQUARE");
        System.out.println("Weak bullets slow the enemy");
        System.out.println("Hit the enemy 3 times with weak bullets to gain PowerShot");
        System.out.println("Your square will turn a different color when PowerShot is charged");
        System.out.println("The PowerShot is much larger and faster than regular bullets");
        System.out.println("Hit the enemy with PowerShot to win");
        System.out.println("-----------------------------");
        System.out.println("Player 1 controls: W A S D for Movement");
        System.out.println("                   R for weak bullets");
        System.out.println("                   E for PowerShot");
        System.out.println("Player 2 controls: Arrow Keys for Movement");
        System.out.println("                   L for weak bullets");
        System.out.println("                   K for PowerShot");
    }

    public void draw()
    {
        framelimiter++;
        framelimiter2++;
        bulletLimiter++;
        bulletLimiter2++;
        background(10, 100, 10);
        p.show();
        p.move();
        p2.show();
        p2.move();
        if (redWin == true)
        {
            textSize(100); 
            fill(255, 0 , 0);
            text("Player 1 wins!", 400, 300);
        }
        if (bluWin == true)
        {
            textSize(100); 
            fill(0, 0 , 255);
            text("Player 2 wins!", 400, 300);
        }
        if (powerCount1 >= 3)
        {
            p.setGreen(200);
        }
        if (powerCount2 >= 3)
        {
            p2.setGreen(200);
        }
        //draws bullets, removes bullet when hits boundaries
        for (int i = 0 ; i < bltList1.size(); i++)
        {
            Bullet b = bltList1.get(i);
            if (b.getVelocityX() != 0 || b.getVelocityY() != 0)
            {
                b.show();
                b.move();
            }
            if (b.getX() <= 0 || b.getX() >= 1600 || b.getY() <= 0 || b.getY() >= 800)
            {
                bltList1.remove(i);
            }
            if (dist(b.getX(), b.getY(), p2.getX(), p2.getY()) <= 65)
            {
                bltList1.remove(i);
                powerCount1++;
                p2.setVelocityX(p2.getVelocityX() / 2);
                p2.setVelocityY(p2.getVelocityY() / 2);
            }
        }
        for (int i = 0; i < pwr1.size(); i++)
        {
            PowerShot pw = pwr1.get(i);
            if (p.getVelocityX() != 0 || p.getVelocityY() != 0)
            {
                pw.show();
                pw.move();
            }
            if (pw.getX() <= 0 || pw.getX() >= 1600 || pw.getY() <= 0 || pw.getY() >= 800)
            {
                pwr1.remove(i);
            }
            if (dist(pw.getX(), pw.getY(), p2.getX(), p2.getY()) <= 90)
            {
                pwr1.remove(i);
                p2.setRed(10);
                p2.setGreen(100);
                p2.setBlu(10);
                redWin = true;
                System.out.println("Player 1 wins!");
            }
        }
        //
        for (int i = 0 ; i < bltList2.size(); i++)
        {
            Bullet b = bltList2.get(i);
            if (b.getVelocityX() != 0 || b.getVelocityY() != 0)
            {
                b.show();
                b.move();
            }
            if (b.getX() <= 0 || b.getX() >= 1600 || b.getY() <= 0 || b.getY() >= 800)
            {
                bltList2.remove(i);
            }
            if (dist(b.getX(), b.getY(), p.getX(), p.getY()) <= 65)
            {
                bltList2.remove(i);
                powerCount2++;
                p.setVelocityX(p.getVelocityX() / 2);
                p.setVelocityY(p.getVelocityY() / 2);
            }
        }
        for (int i = 0; i < pwr2.size(); i++)
        {
            PowerShot pw = pwr2.get(i);
            if (p2.getVelocityX() != 0 || p2.getVelocityY() != 0)
            {
                pw.show();
                pw.move();
            }
            if (pw.getX() <= 0 || pw.getX() >= 1600 || pw.getY() <= 0 || pw.getY() >= 800)
            {
                pwr2.remove(i);
            }
            if (dist(pw.getX(), pw.getY(), p.getX(), p.getY()) <= 90)
            {
                pwr2.remove(i);
                p.setRed(10);
                p.setGreen(100);
                p.setBlu(10);
                bluWin = true;
                System.out.println("Player 2 wins!");
            }
        }
        // Player 1 controls
        if (keyPressed && framelimiter > 2)
        {
            framelimiter = 0;
            if (key == 'w')
            {                
                if (p.getVelocityY() >= -6)
                {
                    p.moveUD(-2);
                }
            }
            if (key == 'a')
            {
                if (p.getVelocityX() >= -6)
                {
                    p.moveLR(-2);
                }
            }
            if (key == 's')
            {
                if (p.getVelocityY() <= 6)
                {
                    p.moveUD(2);
                }
            }
            if (key == 'd')
            {
                if (p.getVelocityX() <= 6)
                {
                    p.moveLR(2);
                }
            }
            if (key == 'r' && bulletLimiter >= 30)
            {
                bltList1.add(new Bullet(this, p));
                bulletLimiter = 0;
            }
            if (key == 'e' && powerCount1 >= 3)
            {
                pwr1.add(new PowerShot(this, p));
                powerCount1 -= 3;
                p.setGreen(0);
            }
        }
        // Player 2 controls
        if (keyPressed && framelimiter2 > 2)
        {
            framelimiter2 = 0;
            if (key == CODED)
            {
                if (keyCode == UP)
                {                
                    if (p2.getVelocityY() >= -4)
                    {
                        p2.moveUD(-2);
                    }
                }
                if (keyCode == LEFT)
                {
                    if (p2.getVelocityX() >= -4)
                    {
                        p2.moveLR(-2);
                    }
                }
                if (keyCode == DOWN)
                {
                    if (p2.getVelocityY() <= 4)
                    {
                        p2.moveUD(2);
                    }
                }
                if (keyCode == RIGHT)
                {
                    if (p2.getVelocityX() <= 4)
                    {
                        p2.moveLR(2);
                    }
                }
            }
            if (key == 'l' && bulletLimiter2 >= 30)
            {
                bltList2.add(new Bullet(this, p2));
                bulletLimiter2 = 0;
            }
            if (key == 'k' && powerCount2 >= 3)
            {
                pwr2.add(new PowerShot(this, p2));
                powerCount2 -= 3;
                p2.setGreen(0);
            }
        }
    }
}