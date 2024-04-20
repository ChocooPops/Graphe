import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_2 extends JFrame {
    private int x = 1000; 
    private int y = 1025; 
    private JMenuItem [] item1; 
    private JMenuItem [] item2;
    private Color [] c; 
    private JButton distance; 
    private JButton comparaison; 
    private JButton [] confirmation; 
    private JPanel panel_centre;
    
    private JTextArea sommet1;
    private JTextArea sommet2;
    
    private LCGraphe graphe; 
    
    public Ecran_2(){
        //COULEUR              gris clair, gris    bleu clair  bleu foncé   beige
        String [] couleur = {"#dcdcdc", "#C6C6C6", "#cbdbfc", "#7D929E", "#D3CBBE"}; 
        c = new Color[couleur.length]; 
        for (int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
        getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, c[3]));
        setTitle("Ecran_2 : Analyse des élèments à 2 de distance"); 
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
        item2[3].setEnabled(false);
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
            //Creation de l'image titre; 
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/Ecran_2/analyse_2.png"); 
        Image image = imageIcon.getImage().getScaledInstance(445, 55, Image.SCALE_SMOOTH);
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
        distance = new JButton(); 
            distance.setBackground(c[0]);
            distance.setBorder(new LineBorder(c[0]));
        comparaison = new JButton(); 
            comparaison.setBackground(c[0]);
            comparaison.setBorder(new LineBorder(c[0]));
        //CREATION DES IMAGES SUR LES BOUTONS;
            //BOUTON SAVOIR SI DEUX SOMMETS SONT A DEUX DE DISTANCE; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_2/dispensaire_2distance.png"); 
        image = imageIcon.getImage().getScaledInstance(212, 108, Image.SCALE_SMOOTH); 
        distance.setIcon(new ImageIcon(image));
            //BOUTON COMPARAISON DE DEUX DISPENSAIRES; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_2/comparer_dispensaire.png"); 
        image = imageIcon.getImage().getScaledInstance(256, 108, Image.SCALE_SMOOTH); 
        comparaison.setIcon(new ImageIcon(image));
            //CREATION DU TEXTE DESCRIPTIF DES BOUTONS; 
        JLabel [] description = new JLabel[2]; 
        description[0] = new JLabel("Savoir si deux dispensaires sont à 2-distance."); 
        description[1] = new JLabel("Comparer deux dispensaires.");
        for(int i=0; i<description.length; i++){
            description[i].setFont(new Font ("Arial", Font.BOLD, 15));
            description[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
            //PANEL DE LA LIGNE 1; 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        JPanel ligne1 = new JPanel(new GridLayout(1, 2)); 
            ligne1.setBackground(c[0]);
            ligne1.add(distance); 
            ligne1.add(comparaison); 
        JPanel ligne2 = new JPanel(new GridLayout(1, 2));
            ligne2.setBackground(c[0]);
            ligne2.add(description[0]); 
            ligne2.add(description[1]);
            //AJOUT DE TOUT LES PANELS DANS LE PANEL SUD PRINCIPAL; 
        panel_sud.add(ligne1); 
        panel_sud.add(ligne2); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 25))); 
            
         
        //PANEL CENTRE DE L'ECRAN; 
        panel_centre = new JPanel(new BorderLayout()); 
        panel_centre.setBackground(c[0]);
        
        //BOUTON SUPPLEMENTAIRE QUI SERA IMPLEMENTER DANS LES ACTIONS DES AUTRES BOUTONS; 
        confirmation = new JButton[2]; 
        for(int i=0; i<confirmation.length; i++){
            confirmation[i] = new JButton(); 
            imageIcon = new ImageIcon("src/main/java/image/confirmation.png"); 
            image = imageIcon.getImage().getScaledInstance(248, 80, Image.SCALE_SMOOTH);
            confirmation[i].setIcon(new ImageIcon(image)); 
            confirmation[i].setBackground(c[0]);
            confirmation[i].setBorder(new LineBorder(c[0]));
        }
            
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_nord, BorderLayout.NORTH); 
        getContentPane().add(panel_centre, BorderLayout.CENTER);
        getContentPane().add(panel_sud, BorderLayout.SOUTH); 
        getContentPane().setBackground(c[0]);
        
        Bouton(); 
    }
    
    public void Bouton(){
        distance.addActionListener(new ActionListener(){
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
                sud.add(confirmation[0]); 
                //PANEL CENTRE SECONDAIRE; 
                JPanel centre = new JPanel(new GridLayout( 1, 1)); 
                centre.setBackground(c[0]);
                
                //AJOUT; 
                panel_centre.add(nord, BorderLayout.NORTH);  
                panel_centre.add(sud, BorderLayout.SOUTH); 
                panel_centre.revalidate(); 
                panel_centre.repaint(); 
                
                confirmation[0].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        centre.removeAll();
                        JLabel resultat = new JLabel(); 
                        resultat.setFont(new Font ("Arial", Font.BOLD, 20)); 
                        resultat.setHorizontalAlignment(SwingConstants.CENTER);
                        resultat.setVerticalAlignment(SwingConstants.CENTER);
                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null || graphe.ChercherSommetPrincipal(sommet2.getText()) == null){
                            resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                            resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                        }else{
                            resultat.setText(graphe.Savoir_Si_Sommet_2_Distance(sommet1.getText(), sommet2.getText()));
                        }
                        
                        centre.add(resultat); 
                        panel_centre.add(centre, BorderLayout.CENTER); 
                        panel_centre.revalidate(); 
                        panel_centre.repaint(); 
                    }
                });  
            }
        }); 
        comparaison.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_centre.removeAll();
                panel_centre.setBorder(new LineBorder(Color.BLACK));
                
                //PANEL NORD SECONDAIRE; 
                JPanel nord = new JPanel(); 
                nord.setLayout(new BoxLayout(nord, BoxLayout.Y_AXIS));
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
                nord.add(Box.createRigidArea(new Dimension(0, 50))); 
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
                        if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null || graphe.ChercherSommetPrincipal(sommet2.getText()) == null){ 
                            JLabel resultat = new JLabel(); 
                            resultat.setHorizontalAlignment(SwingConstants.CENTER);
                            resultat.setVerticalAlignment(SwingConstants.CENTER);
                            resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                            resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                            centre.add(resultat); 
                        }else{
                            JTextArea resultat = new JTextArea(); 
                            resultat.setFont(new Font ("Arial", Font.BOLD, 20)); 
                            resultat.setBackground(c[0]);
                            resultat.setColumns(10);
                            resultat.setEditable(false);
                            resultat.setLineWrap(true);       //Passage automatique à la ligne; 
                            resultat.setWrapStyleWord(true);  //Mots entiersur une nouvelle ligne; 
                            resultat.setText(graphe.Comparer_2_Sommets(sommet1.getText(), sommet2.getText()));
                            centre.add(resultat); 
                        } 
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
