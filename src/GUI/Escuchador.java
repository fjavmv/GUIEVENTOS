package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Escuchador extends Frame {
    private Button boton, boton2, boton3;
    //private TextArea textArea;
    public Escuchador()
    {
        super("Nombre de la ventana");
        setLayout(new FlowLayout());
        //Intancia para cada botón
        boton = new Button("Click en botón");

        boton2 = new Button("Mover");

        // agrego un listener al boton
        boton.addActionListener(new EscuchaBoton());
        add(boton);
        boton2.addActionListener(new EscuchaBoton2());
        add(boton2);
        // quien genera el evento es el Frame
        addMouseMotionListener(new EscuchaMouse());
        boton3 = new Button("Escucha mouse");
        add(boton3);

        setSize(200,150);
        setVisible(true);
    }
    //clase interna que implementa interface ActionListener
    // y se sobre escribe el metood  actionPerformed
    static class EscuchaBoton implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Se presiono el boton...");
        }
    }
    class EscuchaBoton2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            // dimension de la ventana
            Dimension dimVentana = getSize();
            // dimension de la pantalla
            Dimension dimScreen = getToolkit().getScreenSize();
            // nuevas coordenadas (aleatorias) para reubicar la ventana
            int x= (int)(Math.random()* (dimScreen.width-dimVentana.width));
            int y = (int)(Math.random()* (dimScreen.height-dimVentana.height));
            // cambio la ubicacion de la ventana
            setLocation(x,y);
        }
    }

    class EscuchaMouse implements MouseMotionListener
    {
        public void mouseMoved(MouseEvent e)
        {
            int distancia = 10;
            Point pMouse = e.getPoint();
            Dimension dimBoton=boton.getSize();
            Point pBoton = boton.getLocation();
            int difX1 = Math.abs(pBoton.x-pMouse.x);
            int difX2 = Math.abs((pBoton.x+dimBoton.width)-pMouse.x);
            int difY1 = Math.abs(pBoton.y-pMouse.y);
            int difY2 = Math.abs((pBoton.y+dimBoton.height)-pMouse.y);
            if( difX1<distancia || difX2 <distancia ||
                    difY1<distancia || difY2 <distancia)
            {
                // dimension de la ventana
                Dimension dimVentana = getSize();
                // dimension de la pantalla
                Dimension dimScreen = getToolkit().getScreenSize();
                // nuevas coordenadas para la ventana
                int y = (int) (Math.random()*
                        (dimScreen.height-dimVentana.height));
                int x= (int) (Math.random()*
                        (dimScreen.width-dimVentana.width));
                // cambio la ubicacion de la ventana
                setLocation(x,y);
            }
        }
        public void mouseDragged(MouseEvent e) {

        }
    }
}


