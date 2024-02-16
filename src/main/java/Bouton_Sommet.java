import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Bouton_Sommet extends JButton {
    private Color [] c; 
    public Bouton_Sommet(String nom){
        Couleur();
      
        this.setSize(200, 50); 
        this.setBackground(c[3]); 
        this.setForeground(c[1]);
        this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, c[3]));
        this.setFont(new Font("Arial", Font.BOLD, 14));
        this.setText(nom); 
     
    }
    public void Couleur(){
        String [] couleur = {"#dcdcdc", "#cbdbfc", "#7d929e", "#53829d", "#000000"}; 
        c = new Color[couleur.length]; 
        for(int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
    }   
}
