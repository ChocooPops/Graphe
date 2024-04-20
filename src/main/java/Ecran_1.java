import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_1 extends JFrame {
    private int x = 1000; 
    private int y = 1025; 
    private Color [] c;
    private JMenuItem [] item1;
    private JMenuItem [] item2;
    private JButton voisin_noeud; 
    private JButton SavoirSiSommetRelie; 
    private JButton voisins_communs;
    private JButton voisin_avec_type; 
    private JButton arete_dispensaires; 
    private JButton [] confirmation; 
    
    private JPanel panel_centre; 
    private JTextArea sommet1;
    private JTextArea sommet2;
    private JTextArea type;
    
    private LCGraphe graphe; 
  
    public Ecran_1(){
        //COULEUR              gris clair, gris    bleu clair  bleu foncé   beige
        String [] couleur = {"#dcdcdc", "#C6C6C6", "#cbdbfc", "#7D929E", "#D3CBBE"}; 
        c = new Color[couleur.length]; 
        for (int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
        getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, c[3]));
        setTitle("Ecran_1 : Analyse des élèments à 1 de distance"); 
        setSize(x, y);
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //RECUPERATION DU GRAPHE;  
        graphe = new Ecran_0().getGraphe(); 
        
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
        item1[0].setEnabled(true);
        for(int i=0; i<item2.length; i++){
            onglet2.add(item2[i]); 
        } 
        item2[2].setEnabled(false);
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
            //Creation de l'image titre; 
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/Ecran_1/analyse_1.png"); 
        Image image = imageIcon.getImage().getScaledInstance(440, 55, Image.SCALE_SMOOTH);
        JLabel titre = new JLabel(new ImageIcon(image)); 
        titre.setAlignmentX(Component.CENTER_ALIGNMENT); 
            //Ajout dans un panel; 
        panel_nord.add(panel_menu);
        panel_nord.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_nord.add(titre); 
        panel_nord.add(Box.createRigidArea(new Dimension(0, 40))); 
        
        //PANEL SOUTH DE L'ECRAN;  
        JPanel panel_sud = new JPanel(); 
        panel_sud.setLayout(new BoxLayout(panel_sud, BoxLayout.Y_AXIS)); 
        panel_sud.setBackground(c[0]);
            //INSTANCIATION DES BOUTON;
        voisin_noeud = new JButton(); 
            voisin_noeud.setBackground(c[0]);
            voisin_noeud.setBorder(new LineBorder(c[0]));
        SavoirSiSommetRelie = new JButton(); 
            SavoirSiSommetRelie.setBackground(c[0]);
            SavoirSiSommetRelie.setBorder(new LineBorder(c[0]));
        voisins_communs = new JButton(); 
            voisins_communs.setBackground(c[0]);
            voisins_communs.setBorder(new LineBorder(c[0]));
        voisin_avec_type = new JButton();
            voisin_avec_type.setBackground(c[0]);
            voisin_avec_type.setBorder(new LineBorder(c[0]));
        arete_dispensaires = new JButton(); 
            arete_dispensaires.setBackground(c[0]);
            arete_dispensaires.setBorder(new LineBorder(c[0]));
            //CREATION DES IMAGE POUR LES BOUTONS; 
                //Bouton lister les sommets voisin d'un noeuds; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_1/voisin_d'un_noeud.png"); 
        image = imageIcon.getImage().getScaledInstance(153, 81, Image.SCALE_SMOOTH); 
        voisin_noeud.setIcon(new ImageIcon(image));
                //Savoir si deux sommets sont reliés;  
        imageIcon = new ImageIcon("src/main/java/image/Ecran_1/SavoirSiSommetRelie.png"); 
        image = imageIcon.getImage().getScaledInstance(105, 81, Image.SCALE_SMOOTH); 
        SavoirSiSommetRelie.setIcon(new ImageIcon(image));
                //Bouton lister les sommets voisins entre deux sommets; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_1/voisins_communs.png"); 
        image = imageIcon.getImage().getScaledInstance(129, 81, Image.SCALE_SMOOTH); 
        voisins_communs.setIcon(new ImageIcon(image));
                //Bouton lister les sommets voisin d'un noeuds selon le type; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_1/voisin_avec_type.png"); 
        image = imageIcon.getImage().getScaledInstance(150, 102, Image.SCALE_SMOOTH); 
        voisin_avec_type.setIcon(new ImageIcon(image));
                //Bouton lister les sommets que relie une arete donné; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_1/dispensaire_arete.png"); 
        image = imageIcon.getImage().getScaledInstance(159, 102, Image.SCALE_SMOOTH); 
        arete_dispensaires.setIcon(new ImageIcon(image));
            //Creation du texte descriptif des boutons; 
        JLabel [] description = new JLabel[5]; 
        description[0] = new JLabel("Connaitre les voisins direct d'un dispensaire."); 
        description[1] = new JLabel("Savoir si deux dispensaires sont voisins."); 
        description[2] = new JLabel("Lister les voisins communs entre deux centres par type."); 
        description[3] = new JLabel("Connaitre les voisins d'un type donnée pour un dispensaire."); 
        description[4] = new JLabel("Lister les dispensaires que relie une arete donnée."); 
        for(int i=0; i<description.length; i++){
            description[i].setFont(new Font ("Arial", Font.BOLD, 13));
            description[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
            //Creation du panel contenant les boutons : VOISIN_NOEUD, SAVOISISOMMETRELIE, VOISINS_COMMUNS; 
        JPanel panel_ligne1 = new JPanel(new GridLayout(1, 3)); 
        panel_ligne1.setBackground(c[0]);
        panel_ligne1.add(voisin_noeud); 
        panel_ligne1.add(SavoirSiSommetRelie); 
        panel_ligne1.add(voisins_communs); 
            //Creation du panel contenant les boutons : VOISINS_AVEC_TYPE, ARETE_DISPENSAIRE; 
        JPanel panel_ligne3 = new JPanel(new GridLayout(1, 2)); 
        panel_ligne3.setBackground(c[0]);
        panel_ligne3.add(voisin_avec_type); 
        panel_ligne3.add(arete_dispensaires); 
            //Creation du panel contenant les description 0 à 2 y compris; 
        JPanel panel_ligne2 = new JPanel(new GridLayout(1, 3)); 
        panel_ligne2.setBackground(c[0]);
        panel_ligne2.add(description[0]);
        panel_ligne2.add(description[1]);
        panel_ligne2.add(description[2]);
            //Creation du panel contenant les description 3 à 4 y compris; 
        JPanel panel_ligne4 = new JPanel(new GridLayout(1, 2)); 
        panel_ligne4.setBackground(c[0]);
        panel_ligne4.add(description[3]);
        panel_ligne4.add(description[4]);
            //AJOUT DE TOUS LES PANELS ET DONC DES BOUTONS DANS LE PANEL_NORD; 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(panel_ligne1); 
        panel_sud.add(panel_ligne2);
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(panel_ligne3);
        panel_sud.add(panel_ligne4);
        panel_sud.add(Box.createRigidArea(new Dimension(0, 15))); 
        
        //PANEL CENTRE DE L'ECRAN; 
        panel_centre = new JPanel(new BorderLayout()); 
        panel_centre.setBackground(c[0]);
        
        //BOUTON SUPPLEMENTAIRE QUI SERA IMPLEMENTER DANS LES ACTIONS DES AUTRES BOUTONS; 
        confirmation = new JButton[5]; 
        for(int i=0; i<confirmation.length; i++){
            confirmation[i] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/image/confirmation.png"); 
            image = imageIcon.getImage().getScaledInstance(248, 80, Image.SCALE_SMOOTH);
            confirmation[i].setIcon(new ImageIcon(image)); 
            confirmation[i].setBackground(c[0]);
            confirmation[i].setBorder(new LineBorder(c[0]));
        }
            
        //AJOUT DE TOUS LES PANEL (NORD, CENTRE, SUD) DANS LE PANEL PRINCIPAL DE L'ECRAN; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_nord, BorderLayout.NORTH);
        getContentPane().add(panel_centre, BorderLayout.CENTER); 
        getContentPane().add(panel_sud, BorderLayout.SOUTH); 
        getContentPane().setBackground(c[0]);
        
        Bouton(); 
    }
    public void Bouton(){
        voisin_noeud.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                    panel_centre.removeAll();
                    panel_centre.setBorder(new LineBorder(Color.BLACK));

                        //Panel NORD SECONDAIRE; 
                    JPanel nord = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30)); 
                    nord.setBackground(c[0]);
                    sommet1 = new JTextArea(); 
                        sommet1.setColumns(25);
                        sommet1.setBorder(new LineBorder(Color.BLACK));
                        sommet1.setFont(new Font("Arial", Font.BOLD, 20));
                    JLabel titre = new JLabel("Saisissez le nom d'un dispensaire : ");
                    titre.setFont(new Font("Arial", Font.BOLD, 20));
                    nord.add(titre);
                    nord.add(sommet1); 
                        //Panel SUD SECONDAIRE; 
                    JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                    sud.setBackground(c[0]);
                    sud.add(confirmation[0]); 
                        //PANEL CENTRE SECONDAIRE : AFFICHER LES DISPENSAIRES VOISINS; 
                    JPanel centre = new JPanel(); 
                    centre.setLayout(new GridLayout(2, 1,0 ,0));
                    centre.setBackground(c[0]);
                    
                    panel_centre.add(nord, BorderLayout.NORTH); 
                    panel_centre.add(sud, BorderLayout.SOUTH); 
                    panel_centre.revalidate(); 
                    panel_centre.repaint();

                confirmation[0].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();

                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) != null){
                            JLabel str = new JLabel("Les dispensaires voisins de ".concat(sommet1.getText()).concat(" sont : "));
                                str.setFont(new Font ("Arial", Font.BOLD, 30)); 
                                str.setHorizontalAlignment(SwingConstants.CENTER);
                                str.setVerticalAlignment(SwingConstants.CENTER);
                            centre.add(str); 
                        }
                        JLabel resultat = new JLabel(graphe.Lister_Sommet_1_Distance1(sommet1.getText())); 
                            resultat.setFont(new Font ("Arial", Font.BOLD, 30));  
                            resultat.setHorizontalAlignment(SwingConstants.CENTER);
                            resultat.setVerticalAlignment(SwingConstants.CENTER);
                        centre.add(resultat);  
 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });
            }
        }); 
        SavoirSiSommetRelie.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_centre.removeAll();
                panel_centre.setBorder(new LineBorder(Color.BLACK));
                
                //PANEL NORD SECONDAIRE; 
                JPanel nord = new JPanel(new GridLayout(2, 1)); 
                nord.setBackground(c[0]);
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
                JPanel panel_sommet2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
                    panel_sommet2.setBackground(c[0]);
                    panel_sommet2.add(titre2); 
                    panel_sommet2.add(sommet2);
                    //AJOUT DANS LE PANEL NORD; 
                nord.add(panel_sommet1); 
                nord.add(panel_sommet2); 
                //PANEL SUD SECONDAIRE; 
                JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                sud.setBackground(c[0]);
                sud.add(confirmation[1]); 
                //PANEL CENTRE SECONDAIRE; 
                JPanel centre = new JPanel(new GridLayout( 1, 1)); 
                centre.setBackground(c[0]);
                
                //AJOUT; 
                panel_centre.add(nord, BorderLayout.NORTH);  
                panel_centre.add(sud, BorderLayout.SOUTH); 
                panel_centre.revalidate(); 
                panel_centre.repaint(); 
                
                confirmation[1].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();
                        JLabel resultat = new JLabel(); 
                        resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                        resultat.setHorizontalAlignment(SwingConstants.CENTER);
                        resultat.setVerticalAlignment(SwingConstants.CENTER);
                        
                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) != null && graphe.ChercherSommetPrincipal(sommet2.getText()) != null){
                            if(graphe.Savoir_Si_2Sommets_Relié(sommet1.getText(), sommet2.getText())){
                                resultat.setText("Les dispensaires ".concat(sommet1.getText()).concat(" et ").concat(sommet2.getText()).concat(" sont voisins."));
                            }else{
                               resultat.setText("Les dispensaires ".concat(sommet1.getText()).concat(" et ").concat(sommet2.getText()).concat(" ne sont pas voisins."));
                            }
                        }else{
                            resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                        }
                        centre.add(resultat); 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });  
            }
        }); 
        voisins_communs.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_centre.removeAll();
                panel_centre.setBorder(new LineBorder(Color.BLACK));
                
                //PANEL NORD SECONDAIRE; 
                JPanel nord = new JPanel(); 
                    nord.setLayout(new BoxLayout(nord, BoxLayout.Y_AXIS));
                    nord.setBackground(c[0]);
                JPanel panel_dispensaire = new JPanel(new GridLayout(1, 2)); 
                panel_dispensaire.setBackground(c[0]);
                sommet1 = new JTextArea(); 
                    sommet1.setColumns(10);
                    sommet1.setBorder(new LineBorder(Color.BLACK));
                    sommet1.setFont(new Font("Arial", Font.BOLD, 15));
                sommet2 = new JTextArea(); 
                    sommet2.setColumns(10);
                    sommet2.setBorder(new LineBorder(Color.BLACK));
                    sommet2.setFont(new Font("Arial", Font.BOLD, 15));
                JLabel titre1 = new JLabel("Saisissez le nom d'un dispensaire : "); 
                    titre1.setFont(new Font("Arial", Font.BOLD, 16));
                JLabel titre2 = new JLabel("Saisissez le nom d'un autre dispensaire : ");
                    titre2.setFont(new Font("Arial", Font.BOLD, 16));
                    //PANEL SOMMET1 ET SOMMET2; 
               JPanel panel_sommet1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
                    panel_sommet1.setBackground(c[0]);
                    panel_sommet1.add(titre1); 
                    panel_sommet1.add(sommet1);
                JPanel panel_sommet2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
                    panel_sommet2.setBackground(c[0]);
                    panel_sommet2.add(titre2); 
                    panel_sommet2.add(sommet2);
                panel_dispensaire.add(panel_sommet1); 
                panel_dispensaire.add(panel_sommet2); 
                    //PANEL TYPE;
                JPanel panel_type = new JPanel(new GridLayout(1, 1)); 
                panel_type.setBackground(c[0]);
                JPanel position_type = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                position_type.setBackground(c[0]);
                JLabel titre3 = new JLabel("Saisissez le type de dispensaires (M, N, ou O) : ");
                    titre3.setFont(new Font("Arial", Font.BOLD, 16));
                type = new JTextArea();
                    type.setColumns(20);
                    type.setBorder(new LineBorder(Color.BLACK));
                    type.setFont(new Font("Arial", Font.BOLD, 15));
                position_type.add(titre3); 
                position_type.add(type); 
                panel_type.add(position_type); 
                    //AJOUT DANS LE PANEL NORD; 
                nord.add(panel_dispensaire); 
                nord.add(Box.createRigidArea(new Dimension(0, 20)));
                nord.add(panel_type); 
                //PANEL SUD SECONDAIRE; 
                JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                sud.setBackground(c[0]);
                sud.add(confirmation[2]); 
                //PANEL CENTRE SECONDAIRE; 
                JPanel centre = new JPanel(new GridLayout( 1, 1)); 
                centre.setBackground(c[0]);
                
                    
                panel_centre.add(nord, BorderLayout.NORTH);
                panel_centre.add(sud, BorderLayout.SOUTH); 
                panel_centre.revalidate(); 
                panel_centre.repaint();  
               
                confirmation[2].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();
                        JLabel resultat = new JLabel(); 
                        resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                        resultat.setHorizontalAlignment(SwingConstants.CENTER);
                        resultat.setVerticalAlignment(SwingConstants.CENTER);
                        type.setText(type.getText().toUpperCase());
                        
                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null || graphe.ChercherSommetPrincipal(sommet2.getText()) == null){
                            resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                        }else if(!type.getText().equals("M") && !type.getText().equals("N") && !type.getText().equals("O")){
                            resultat.setText("Le type de dispensaire choisis est incorrect.");
                        }else{
                            resultat.setText(graphe.Lister_Sommet_Voisins_de_Deux_Sommet_Donnés_Selon_Type(sommet1.getText(), sommet2.getText(), type.getText()));
                            resultat.setFont(new Font ("Arial", Font.BOLD, 20)); 
                        }
                        centre.add(resultat); 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });  
            }
        }); 
        voisin_avec_type.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_centre.removeAll();
                panel_centre.setBorder(new LineBorder(Color.BLACK));
                
                //PANEL NORD SECONDAIRE; 
                JPanel nord = new JPanel(new GridLayout(2, 1)); 
                nord.setBackground(c[0]);
                sommet1 = new JTextArea(); 
                    sommet1.setColumns(20);
                    sommet1.setBorder(new LineBorder(Color.BLACK));
                    sommet1.setFont(new Font("Arial", Font.BOLD, 15));
                type = new JTextArea(); 
                    type.setColumns(20);
                    type.setBorder(new LineBorder(Color.BLACK));
                    type.setFont(new Font("Arial", Font.BOLD, 15));
                JLabel titre1 = new JLabel("Saisissez le nom d'un dispensaire : "); 
                    titre1.setFont(new Font("Arial", Font.BOLD, 20));
                JLabel titre2 = new JLabel("Saisissez le type de dispensaires (M, N, O) : ");
                    titre2.setFont(new Font("Arial", Font.BOLD, 20));
                    //PANEL SOMMET1; 
                JPanel panel_sommet1 = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25)); 
                    panel_sommet1.setBackground(c[0]);
                    panel_sommet1.add(titre1); 
                    panel_sommet1.add(sommet1);
                JPanel panel_type = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
                    panel_type.setBackground(c[0]);
                    panel_type.add(titre2); 
                    panel_type.add(type); 
                nord.add(panel_sommet1); 
                nord.add(panel_type); 
                
                JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                sud.setBackground(c[0]);
                sud.add(confirmation[3]); 
                //PANEL CENTRE SECONDAIRE; 
                JPanel centre = new JPanel(new GridLayout( 1, 1)); 
                centre.setBackground(c[0]);
                
                panel_centre.add(nord, BorderLayout.NORTH);
                panel_centre.add(sud, BorderLayout.SOUTH); 
                panel_centre.revalidate(); 
                panel_centre.repaint();
                
                confirmation[3].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();
                        JLabel resultat = new JLabel(); 
                        resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                        resultat.setHorizontalAlignment(SwingConstants.CENTER);
                        resultat.setVerticalAlignment(SwingConstants.CENTER);
                        type.setText(type.getText().toUpperCase());
                        
                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null){
                            resultat.setText("Le dispensaire mentionné est introuvable.");
                        }else if(!type.getText().equals("M") && !type.getText().equals("N") && !type.getText().equals("O")){
                            resultat.setText("Le type de dispensaire choisis est incorrect.");
                        }else{
                            resultat.setText(graphe.Lister_Sommet_1_Distance_Type(sommet1.getText(), type.getText()));
                            resultat.setFont(new Font ("Arial", Font.BOLD, 22)); 
                        }
                        centre.add(resultat); 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });     
            }
        }); 
        arete_dispensaires.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_centre.removeAll();
                panel_centre.setBorder(new LineBorder(Color.BLACK));

                    //Panel NORD SECONDAIRE; 
                JPanel nord = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30)); 
                nord.setBackground(c[0]);
                sommet1 = new JTextArea(); 
                    sommet1.setColumns(25);
                    sommet1.setBorder(new LineBorder(Color.BLACK));
                    sommet1.setFont(new Font("Arial", Font.BOLD, 20));
                JLabel titre = new JLabel("Saisissez le nom d'une arête/d'un trajet : ");
                titre.setFont(new Font("Arial", Font.BOLD, 20));
                nord.add(titre);
                nord.add(sommet1); 
                    //Panel SUD SECONDAIRE; 
                JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                sud.setBackground(c[0]);
                sud.add(confirmation[4]); 
                    //PANEL CENTRE SECONDAIRE : AFFICHER LES DISPENSAIRES VOISINS; 
                JPanel centre = new JPanel(); 
                centre.setLayout(new GridLayout(1, 1));
                centre.setBackground(c[0]);
                    
                panel_centre.add(nord, BorderLayout.NORTH); 
                panel_centre.add(sud, BorderLayout.SOUTH); 
                panel_centre.revalidate(); 
                panel_centre.repaint();
                
                confirmation[4].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();
                        JLabel resultat = new JLabel(); 
                        resultat.setFont(new Font ("Arial", Font.BOLD, 25)); 
                        resultat.setHorizontalAlignment(SwingConstants.CENTER);
                        resultat.setVerticalAlignment(SwingConstants.CENTER);
                        
                        resultat.setText(graphe.Lister_Sommet_PourUne_Arete_Donné2(sommet1.getText()));
                        centre.add(resultat);
                                
                        centre.add(resultat); 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });     
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
                new Ecran_1().setVisible(true);
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
        item2[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_Bonus().setVisible(true);
                setVisible(false); 
            }
        }); 
    }
}
