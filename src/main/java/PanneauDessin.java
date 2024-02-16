
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class PanneauDessin extends JPanel {
        private final List<Cercle> lesCercles; 
        private LCGraphe sommet; 
        Traitement_Fichier fic; 
        private LinkedList<Integer> [] coordonnée; 
        private int taille_cercle = 20; 
        private Color [] c; 
        
        
    public PanneauDessin(LCGraphe new_graphe) { 
        this.sommet = new_graphe;
        Coordonnée();
        Couleur(); 
        this.lesCercles = new ArrayList<>();
        Remplir_Liste(); 
        initComponents();
    }
    public void Remplir_Liste(){
        
        String [] str = sommet.getNomSommet().split(";"); 
        Cercle [] cercle = new Cercle[str.length];
        int x = 50; 
        int y = 50; 
        for(int i=0; i<cercle.length; i++){
            int j = i+1; 
            String segment = ""; 
            if(sommet.getType(str[i]).equals("M")){
                cercle[i] = new Cercle(coordonnée[i].get(0), coordonnée[i].get(1), taille_cercle, c[3], str[i]); 
            }else if(sommet.getType(str[i]).equals("N")){
                cercle[i] = new Cercle(coordonnée[i].get(0), coordonnée[i].get(1), taille_cercle, c[2], str[i]);
            }else{
                cercle[i] = new Cercle(coordonnée[i].get(0), coordonnée[i].get(1), taille_cercle, c[1], str[i]);
            }
            
            lesCercles.add(cercle[i]); 
        } 
    }
    public void Couleur(){
        String [] couleur = {"#dcdcdc", "#cbdbfc", "#7d929e", "#53829d"}; 
        c = new Color[couleur.length]; 
        for(int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
    }
                
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.decode("#dcdcdc"));
            g2d.fillRect(0, 0, getWidth(), getHeight()); // Remplir le fond en beige
            g2d.setColor(Color.BLACK);
        for (int i = 0; i < lesCercles.size(); i++) {
            String [] str = sommet.getNomVoisin(lesCercles.get(i).getText()).split(";"); 
            String [] segment = sommet.getFiabilite(lesCercles.get(i).getText()).split(";"); 
            for(int j=0; j<str.length; j++){
                Cercle circle1 = lesCercles.get(i);
                Cercle circle2 = ChercherCercle(str[j]); 
                g2d.drawLine(circle1.getX(), circle1.getY(), circle2.getX(), circle2.getY());
                // Dessiner le texte du segment;
                g2d.drawString(segment[j], (circle1.getX() + circle2.getX()) / 2,
                (circle1.getY() + circle2.getY()) / 2);
            }
        }
        for (Cercle circle : lesCercles){
            g2d.setColor(circle.getColor());
            g2d.fillOval(circle.getX() - circle.getRadius(), circle.getY() - circle.getRadius(),
                circle.getRadius() * 2, circle.getRadius() * 2); 
            // Dessiner le texte au centre du cercle
            g2d.setColor(Color.BLACK);
            FontMetrics fm = g2d.getFontMetrics();
            int textWidth = fm.stringWidth(circle.getText());
            int textHeight = fm.getHeight();
            int textX = circle.getX() - (textWidth / 2);
            int textY = circle.getY() + (textHeight / 2);
            g2d.drawString(circle.getText(), textX, textY);
            repaint(); 
        }
        
    }
    //=====================================================================================
    public Cercle ChercherCercle(String nom1){
        Cercle c = null; 
        for(int i=0; i<lesCercles.size(); i++){
            if(lesCercles.get(i).getText().equals(nom1)){
                c = lesCercles.get(i); 
            }
        }
        return c; 
    }
                        
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 521, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 345, Short.MAX_VALUE)
        );
    }// </editor-fold>                        

    private void formMousePressed(java.awt.event.MouseEvent evt) {                                  
         for (Cercle circle : lesCercles) {
                    if (circle.contains(evt.getPoint())) {
                        circle.setDragging(true);
                        circle.setOffset(evt.getX() - circle.getX(), evt.getY() - circle.getY());
                    }
                }
    }                                 

    private void formMouseReleased(java.awt.event.MouseEvent evt) {                                   
        for (Cercle circle : lesCercles) {
                    circle.setDragging(false);
        }
    }                                  

    private void formMouseDragged(java.awt.event.MouseEvent evt) {                                  
        for (Cercle circle : lesCercles) {
                    if (circle.isDragging()) {
                        circle.move(evt.getX() - circle.getOffsetX(), evt.getY() - circle.getOffsetY());
                    }
        }
        repaint();
    }                                 
    public String getCoo(){
        String s = ""; 
        for(int i=0; i<lesCercles.size(); i++){
            int j=i+1; 
             s = s + lesCercles.get(i).getX() + "-" + lesCercles.get(i).getY();
             s = s +"___"; 
        }
        return s; 
    }

    public void Coordonnée(){
        coordonnée = new LinkedList[30]; 
        String str = "92-218___73-352___203-225___305-381___313-262___293-145___423-25___492-148___530-313___511-429___549-233___631-382___871-144___608-57___760-113___850-252___755-303___744-403___790-477___571-512___241-501___130-450___394-525___375-441___420-305___396-201___115-72___246-57___650-194___751-46"; 
        String [] position = str.split("___"); 
        for(int i=0; i<coordonnée.length; i++){
            String [] coo = position[i].split("-"); 
            coordonnée[i] = new LinkedList<>();
            int x = Integer. parseInt(coo[0]); 
            int y = Integer. parseInt(coo[1]);
            coordonnée[i].add(x); 
            coordonnée[i].add(y); 
        }
    }
}
