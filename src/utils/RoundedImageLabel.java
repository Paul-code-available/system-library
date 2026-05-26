package utils;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class RoundedImageLabel extends JPanel {

    private Image image;

    public RoundedImageLabel(String path) {

        ImageIcon icon = new ImageIcon(
                getClass().getResource(path)
        );

        image = icon.getImage();

        setPreferredSize(new Dimension(160, 210));
        setMaximumSize(new Dimension(160, 210));
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        Shape clip = new RoundRectangle2D.Double(
                0,
                0,
                getWidth(),
                getHeight(),
                20,
                20
        );

        g2.setClip(clip);

        g2.drawImage(
                image,
                0,
                0,
                getWidth(),
                getHeight(),
                this
        );

        g2.dispose();
    }
}


