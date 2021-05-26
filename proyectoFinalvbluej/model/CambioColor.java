package model;
import java.awt.*;
import java.applet.Applet;

public class CambioColor extends Applet {

    public static void main( String args[] ) {
        Frame fr = new Frame( "Cambio de Color" );
        CambioColor cc = new CambioColor(); 

        fr.setBackground( Color.red );
        fr.setLayout( new FlowLayout() );
        Button b = new Button( "Hola" );
        fr.add( b );
        Checkbox cb = new Checkbox( "Púlsame" );
        fr.add( cb );
        TextArea ta = new TextArea();
        fr.add( ta );

        fr.pack();
        fr.show();
        }
    }