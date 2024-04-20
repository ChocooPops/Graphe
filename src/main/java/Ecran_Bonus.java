import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Ecran_Bonus extends JFrame {
    private int x = 1000; 
    private int y = 1025; 
    private Color [] c;
    private JMenuItem [] item1;
    private JMenuItem [] item2;
    private LCGraphe graphe; 
    private JButton chemin_fiable; 
    private JButton chemin_distance; 
    private JButton chemin_duree; 
    private JPanel panel_centre; 
    private JTextArea sommet1; 
    private JTextArea sommet2;
    private JLabel titre_bouton; 
    private JButton [] confirmation; 
    
    public Ecran_Bonus(){
        //COULEUR              gris clair, gris    bleu clair  bleu foncé   beige
        String [] couleur = {"#dcdcdc", "#C6C6C6", "#cbdbfc", "#7D929E", "#D3CBBE"}; 
        c = new Color[couleur.length]; 
        for (int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
        graphe = new Ecran_0().getGraphe();
        
        getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, c[3]));
        setTitle("Ecran_1 : Analyse des élèments à 1 de distance"); 
        setSize(x, y);
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               //PARTIE NORTH DE L'ECRAN;
        JPanel panel_nord = new JPanel(); 
        panel_nord.setLayout(new BoxLayout(panel_nord, BoxLayout.Y_AXIS)); 
        panel_nord.setBackground(c[0]);
            //Creation du menu; 
        JPanel panel_menu = new JPanel(new BorderLayout());
        JMenuBar menuBar1 = new JMenuBar(); 
        JMenu onglet1 = new JMenu("Edit"); 
        JMenu onglet2 = new JMenu("Choix de l'écran"); 
        item1 = new JMenuItem[2]; 
        item2 = new JMenuItem[6]; 
        item1[0]= new JMenuItem("Fermer"); 
        item1[1]= new JMenuItem("Actualiser"); 
        item2[0] = new JMenuItem("Ecran d'accueil");
        item2[1] = new JMenuItem("Ecran_0");
        item2[2] = new JMenuItem("Ecran_1");
        item2[3] = new JMenuItem("Ecran_2");
        item2[4] = new JMenuItem("Ecran_3");
        item2[5] = new JMenuItem("Ecran_Bonus");
        for(int i=0; i<item1.length; i++){
            onglet1.add(item1[i]); 
        } 
        for(int i=0; i<item2.length; i++){
            onglet2.add(item2[i]); 
        } 
        item2[5].setEnabled(false);
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
            //Creation de l'image titre; 
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/Ecran_Bonus/analyse_bonus.png"); 
        Image image = imageIcon.getImage().getScaledInstance(63*5, 11*5, Image.SCALE_SMOOTH);
        JLabel titre = new JLabel(new ImageIcon(image)); 
        titre.setAlignmentX(Component.CENTER_ALIGNMENT); 
            //Ajout dans un panel; 
        panel_nord.add(panel_menu);
        panel_nord.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_nord.add(titre); 
        panel_nord.add(Box.createRigidArea(new Dimension(0, 10))); 
        
        //PANEL SUD PRINCIPALE; 
        JPanel panel_sud = new JPanel(); 
            panel_sud.setBackground(c[0]);
            panel_sud.setLayout(new BoxLayout(panel_sud, BoxLayout.Y_AXIS));
        JPanel panel_bouton = new JPanel(new GridLayout(1, 3)); 
        panel_bouton.setBackground(c[0]);
        chemin_fiable = new JButton(); 
        chemin_distance = new JButton(); 
        chemin_duree = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/image/Ecran_Bonus/chemin_fiabilite.png"); 
            image = imageIcon.getImage().getScaledInstance(64*3, 20*3, Image.SCALE_SMOOTH);
            chemin_fiable.setIcon(new ImageIcon(image));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_Bonus/chemin_distance.png"); 
            image = imageIcon.getImage().getScaledInstance(73*3, 20*3, Image.SCALE_SMOOTH);
            chemin_distance.setIcon(new ImageIcon(image));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_Bonus/chemin_duree.png"); 
            image = imageIcon.getImage().getScaledInstance(61*3, 20*3, Image.SCALE_SMOOTH);
            chemin_duree.setIcon(new ImageIcon(image));
            chemin_fiable.setBackground(c[0]);
            chemin_distance.setBackground(c[0]);
            chemin_duree.setBackground(c[0]);
            chemin_fiable.setBorder(new LineBorder(c[0])); 
            chemin_distance.setBorder(new LineBorder(c[0])); 
            chemin_duree.setBorder(new LineBorder(c[0])); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_bouton.add(chemin_fiable);
        panel_bouton.add(chemin_distance);
        panel_bouton.add(chemin_duree); 
        panel_sud.add(panel_bouton); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        //PANEL CENTRE PRINCIPAL; 
        panel_centre = new JPanel(new BorderLayout()); 
        panel_centre.setBackground(c[0]);

        //BOUTON CONFIRMATION DE L'OPERATION; 
        imageIcon = new ImageIcon("src/main/java/image/confirmation.png"); 
        image = imageIcon.getImage().getScaledInstance(248, 80, Image.SCALE_SMOOTH);
        confirmation = new JButton[3]; 
        for(int i=0; i<confirmation.length; i++){
            confirmation[i] = new JButton();
            confirmation[i].setIcon(new ImageIcon(image)); 
            confirmation[i].setBackground(c[0]);
            confirmation[i].setBorder(new LineBorder(c[0]));
        }
        
        //PANEL ECRAN; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().setBackground(c[0]);
        getContentPane().add(panel_nord, BorderLayout.NORTH);
        getContentPane().add(panel_sud, BorderLayout.SOUTH);
        getContentPane().add(panel_centre, BorderLayout.CENTER);
        
        Bouton(); 
    }
     public void Bouton(){
        chemin_fiable.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){ 
                   Panel_bouton(0); 
                   titre_bouton.setText("Connaitre le chemin le plus fiable : ");
               }
           }); 
        chemin_distance.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){ 
                   Panel_bouton(1); 
                   titre_bouton.setText("Connaitre le chemin le plus court en distance : ");
               }
           }); 
        chemin_duree.addActionListener(new ActionListener(){
               public void actionPerformed(ActionEvent e){ 
                   Panel_bouton(2); 
                   titre_bouton.setText("Connaitre le chemin le plus court en duree : ");
               }
           }); 
        item1[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                System.exit(0); 
            }
        }); 
        item1[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                setVisible(false);
                new Ecran_2().setVisible(true);
            }
        }); 
        item2[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_Accueil().setVisible(true);
                setVisible(false); 
            }
        }); 
        item2[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_0().setVisible(true);
                setVisible(false); 
            }
        }); 
        item2[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_1().setVisible(true);
                setVisible(false); 
            }
        }); 
        item2[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_2().setVisible(true);
                setVisible(false); 
            }
        }); 
        item2[4].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_3().setVisible(true);
                setVisible(false); 
            }
        }); 
    }
    public void Panel_bouton(int operation){
        panel_centre.removeAll();
        panel_centre.setBorder(new LineBorder(Color.BLACK));
            //PANEL NORD SECONDAIRE; 
        JPanel nord = new JPanel(new GridLayout(4, 1)); 
        nord.setBackground(c[0]);
        titre_bouton = new JLabel(); 
        titre_bouton.setFont(new Font("Arial", Font.BOLD, 25));
        titre_bouton.setHorizontalAlignment(SwingConstants.CENTER);
        sommet1 = new JTextArea(); 
            sommet1.setColumns(20);
            sommet1.setBorder(new LineBorder(Color.BLACK));
            sommet1.setFont(new Font("Arial", Font.BOLD, 15));
        sommet2 = new JTextArea(); 
            sommet2.setColumns(20);
            sommet2.setBorder(new LineBorder(Color.BLACK));
            sommet2.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel titre1 = new JLabel("Saisissez le nom d'un dispensaire : "); 
            titre1.setFont(new Font("Arial", Font.BOLD, 20));
            JLabel titre2 = new JLabel("Saisissez le nom d'un autre dispensaire : ");
            titre2.setFont(new Font("Arial", Font.BOLD, 20));
            //PANEL SOMMET1; 
        JPanel panel_sommet1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
            panel_sommet1.setBackground(c[0]);
            panel_sommet1.add(titre1); 
            panel_sommet1.add(sommet1);
        JPanel panel_sommet2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0)); 
            panel_sommet2.setBackground(c[0]);
            panel_sommet2.add(titre2); 
            panel_sommet2.add(sommet2);
            //AJOUT DANS LE PANEL NORD; 
        nord.add(titre_bouton); 
        nord.add(panel_sommet1); 
        nord.add(panel_sommet2); 
        nord.add(new JLabel("")); 
            //PANEL SUD SECONDAIRE; 
        JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
            sud.setBackground(c[0]);
            sud.add(confirmation[operation]);
            //PANEL CENTRE SECONDAIRE; 
        JPanel centre = new JPanel();
            centre.setLayout(new BoxLayout(centre, BoxLayout.Y_AXIS)); 
            centre.setBackground(c[0]);
            //AJOUT; 
        panel_centre.add(nord, BorderLayout.NORTH);  
        panel_centre.add(sud, BorderLayout.SOUTH); 
        panel_centre.revalidate(); 
        panel_centre.repaint(); 
       
        confirmation[operation].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                centre.removeAll();
                JLabel resultat = new JLabel(); 
                    resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                    resultat.setAlignmentX(Component.CENTER_ALIGNMENT);
                    resultat.setAlignmentY(Component.CENTER_ALIGNMENT);
                if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null || graphe.ChercherSommetPrincipal(sommet2.getText()) == null){
                    resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                    centre.add(resultat); 
                }else if(sommet1.getText().equals(sommet2.getText())){
                    resultat.setText("Les sommets indiqués sont identiques.");
                    centre.add(resultat); 
                }else{
                    if(operation == 0){
                        String str = graphe.Chemin_LePlus_Fiable(sommet1.getText(), sommet2.getText()); 
                        centre.add(new DessinChemin(graphe, str)); 
                    }else if(operation == 1){
                        String str = graphe.Chemin_LePlus_Court_Distance(sommet1.getText(), sommet2.getText()); 
                        centre.add(new DessinChemin(graphe, str)); 
                    }else if(operation == 2){
                        String str = graphe.Chemin_LePlus_Court_Duree(sommet1.getText(), sommet2.getText()); 
                        centre.add(new DessinChemin(graphe, str)); 
                    }else{
                        resultat.setText("Complexité : ");  
                        centre.add(resultat); 
                    }
                } 
                panel_centre.add(centre, BorderLayout.CENTER); 
                panel_centre.revalidate(); 
                panel_centre.repaint(); 
            }
        });  
    }    
    public class DessinChemin extends JPanel {
        private final java.util.List<Cercle> lesCercles; 
        private LCGraphe sommet; 
        private LinkedList<Integer> [] coordonnée; 
        private int taille_cercle = 20; 
        private Color [] c; 
        private String [] chemin; 
        
    public DessinChemin(LCGraphe new_graphe, String liste_chemin) { 
        this.sommet = new_graphe;
        this.chemin = liste_chemin.split(" --> "); 
        Couleur(); 
        this.lesCercles = new ArrayList<>();
        Remplir_Liste(); 
        initComponents();
    }
    public void Remplir_Liste(){
        Cercle [] cercle = new Cercle[chemin.length];
        int x = 50; 
        int y = 50; 
        int nb=0; 
        for(int i=0; i<cercle.length; i++){
            if(sommet.getType(chemin[i]).equals("M")){
                cercle[i] = new Cercle(x, y, taille_cercle, c[3], chemin[i]); 
            }else if(sommet.getType(chemin[i]).equals("N")){
                cercle[i] = new Cercle(x, y, taille_cercle, c[2], chemin[i]);
            }else{
                cercle[i] = new Cercle(x, y, taille_cercle, c[1], chemin[i]);
            }
            x = x + 110; 
            if(nb == 0){
                y = 150;
                nb = 1; 
            }else{
                y = 50; 
                nb = 0; 
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
                
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(Color.decode("#dcdcdc"));
            g2d.fillRect(0, 0, getWidth(), getHeight()); 
            g2d.setColor(Color.BLACK);
        for (int i = 0; i < lesCercles.size()-1; i++) {
            Cercle circle1 = lesCercles.get(i);
            Cercle circle2 = lesCercles.get(i + 1);
            g2d.drawLine(circle1.getX(), circle1.getY(), circle2.getX(), circle2.getY());
            // Dessiner le texte du segment;
            g2d.drawString("", (circle1.getX() + circle2.getX()) / 2, (circle1.getY() + circle2.getY()) / 2);
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
}
 
     
     
     
     
     
     
     
     
     
}