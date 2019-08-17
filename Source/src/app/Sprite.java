package app1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Sprite extends JPanel {
    private int xpos, ypos;
    private int height, width;
    private BufferedImage spriteimg;
    private boolean bVisible;
    static final long serialVersionUID = 20;


    public Sprite() {
        super();
        xpos = ypos = 0;
        height = width = 1;
        spriteimg = null;
        bVisible = false;
    }

    public Sprite(BufferedImage imgarg) {
        super();
        xpos = ypos = 0;
        height = width = 1;
        spriteimg = imgarg;
        bVisible = true;
    }


    public Sprite(String filepath) throws IOException {
        super();
        spriteimg = ImageIO.read(new File(filepath));
        setFocusable(true);
       
        xpos = ypos = 0;
        //setAlignmentX(xpos);
        //setAlignmentY(ypos);

        height = width = 1;
        //setSize(65 * height, 65 * width);
        bVisible = true;
    }

   
    
    public void drawSprite(Graphics g)
    {   
        if(bVisible == true){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING  , RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(spriteimg ,xpos, ypos, (int)width, (int)height, this);
        }
        
        
    }

    public void paint(Graphics g)
    {
        //super.paint(g);
        if(bVisible == true){
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING  , RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawImage(spriteimg ,xpos, ypos, (int)width, (int)height, this);
            }
    }

    public void move(int xarg, int yarg)
    {
        xpos = xarg; ypos = yarg;
        //setAlignmentX(xpos);
        //setAlignmentY(ypos);
    }

    public void setScale(int warg, int harg)
    {
        width = warg; height = harg;
        setSize(width, height);
    }

    public void setVisibility( boolean arg)
    {
        bVisible = arg;
    }
}