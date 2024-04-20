import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class Ecran_3 extends JFrame {
    private int x = 1000; 
    private int y = 1025; 
    private Color [] c;
    private JMenuItem [] item1;
    private JMenuItem [] item2;
    private JButton chemin_fiable; 
    private JButton chemin_court; 
    private JButton complexite; 
    private JButton [] confirmation; 
    private JPanel panel_centre; 
    private JTextArea sommet1;
    private JTextArea sommet2;
    private JLabel titre_bouton; 
    private LCGraphe graphe; 
  
    public Ecran_3(){
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
        item1[0].setEnabled(true);
        for(int i=0; i<item2.length; i++){
            onglet2.add(item2[i]); 
        } 
        item2[4].setEnabled(false);
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
            //Creation de l'image titre; 
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/Ecran_3/analyse_3.png"); 
        Image image = imageIcon.getImage().getScaledInstance(475, 55, Image.SCALE_SMOOTH);
        JLabel titre = new JLabel(new ImageIcon(image)); 
        titre.setAlignmentX(Component.CENTER_ALIGNMENT); 
            //Ajout dans un panel; 
        panel_nord.add(panel_menu);
        panel_nord.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_nord.add(titre); 
        panel_nord.add(Box.createRigidArea(new Dimension(0, 40))); 
        
        //PANEL SOUTH PRINCIPAL; 
        JPanel panel_sud = new JPanel(); 
        panel_sud.setLayout(new BoxLayout(panel_sud, BoxLayout.Y_AXIS));
        panel_sud.setBackground(c[0]);
            //CONFIGURATION DES BOUTON; 
        chemin_fiable = new JButton(); 
            chemin_fiable.setBackground(c[0]);
            chemin_fiable.setBorder(new LineBorder(c[0]));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_3/chemin_fiable.png"); 
            image = imageIcon.getImage().getScaledInstance(54*4, 34*4, Image.SCALE_SMOOTH);
            chemin_fiable.setIcon(new ImageIcon(image));
        chemin_court = new JButton(); 
            chemin_court.setBackground(c[0]);
            chemin_court.setBorder(new LineBorder(c[0])); 
            imageIcon = new ImageIcon("src/main/java/image/Ecran_3/chemin_court.png"); 
            image = imageIcon.getImage().getScaledInstance(63*4, 34*4, Image.SCALE_SMOOTH);
            chemin_court.setIcon(new ImageIcon(image));
        complexite = new JButton(); 
            complexite.setBackground(c[0]);
            complexite.setBorder(new LineBorder(c[0])); 
            imageIcon = new ImageIcon("src/main/java/image/Ecran_3/complexite.png"); 
            image = imageIcon.getImage().getScaledInstance(52*4, 20*4, Image.SCALE_SMOOTH);
            complexite.setIcon(new ImageIcon(image));    
            //AJOUT DES PANELS POUR LES CENTRES; 
        JPanel bouton_ligne1 = new JPanel(new GridLayout(1, 2)); 
            bouton_ligne1.setBackground(c[0]);
            bouton_ligne1.add(chemin_fiable); 
            bouton_ligne1.add(chemin_court); 
        JPanel bouton_ligne2 = new JPanel(new GridLayout(1, 1)); 
            bouton_ligne2.setBackground(c[0]);
            JPanel panel_complexite = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel_complexite.add(complexite); 
            panel_complexite.setBackground(c[0]);
            bouton_ligne2.add(panel_complexite); 
        JLabel [] texte_descriptif = new JLabel[3]; 
            texte_descriptif[0]= new JLabel("Connaitre le chemin le plus fiable entre deux dispensaires."); 
            texte_descriptif[1]= new JLabel("Connaitre le chemin le plus court en distance et en durée."); 
            texte_descriptif[2]= new JLabel("Connaitre la complexité du chemin le plus fiable."); 
            for(int i=0; i<texte_descriptif.length; i++){
                texte_descriptif[i].setFont(new Font("Arial", Font.BOLD, 12));
                texte_descriptif[i].setHorizontalAlignment(SwingConstants.CENTER);
            }
            //TEXTE DESCRIPTIF DES BOUTONS; 
        JPanel texte_ligne1 = new JPanel(new GridLayout(1, 2)); 
            texte_ligne1.setBackground(c[0]);
            texte_ligne1.add(texte_descriptif[0]); 
            texte_ligne1.add(texte_descriptif[1]); 
        JPanel texte_ligne2 = new JPanel(new GridLayout(1, 2)); 
            texte_ligne2.setBackground(c[0]);
            texte_ligne2.add(texte_descriptif[2]);     
            //AJOUT DANS LE PANEL PRINCIPALE SUD; 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 15))); 
        panel_sud.add(texte_ligne1); 
        panel_sud.add(bouton_ligne1); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(texte_ligne2);
        panel_sud.add(bouton_ligne2); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 15))); 
          
        //PANEL CENTRE DE L'ECRAN; 
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
        //AJOUT DE TOUS LES PANEL (NORD, CENTRE, SUD) DANS LE PANEL PRINCIPAL DE L'ECRAN; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_nord, BorderLayout.NORTH);
        getContentPane().add(panel_sud, BorderLayout.SOUTH);
        getContentPane().add(panel_centre, BorderLayout.CENTER); 
        getContentPane().setBackground(c[0]);
        
        Bouton(); 
    }
    public void Bouton(){
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
        item2[5].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_Bonus().setVisible(true);
                setVisible(false); 
            }
        }); 
        chemin_fiable.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                Panel_bouton(0); 
                titre_bouton.setText("Connaitre le chemin le plus fiable entre deux dispensaires : ");
            }
        }); 
        chemin_court.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                Panel_bouton(1); 
                titre_bouton.setText("Connaitre le chemin le plus court entre deux dispensaires : ");
            }
        }); 
        complexite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                Panel_bouton(2); 
                titre_bouton.setText("Connaitre la complexité de l'algorithme du chemin le plus fiable : ");
            }
        }); 
    }
    public void Panel_bouton(int operation){
        panel_centre.removeAll();
        panel_centre.setBorder(new LineBorder(Color.BLACK));
            //PANEL NORD SECONDAIRE; 
        JPanel nord = new JPanel(new GridLayout(3, 1)); 
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
                JLabel resultat2 = new JLabel(); 
                    resultat.setFont(new Font ("Arial", Font.BOLD, 30)); 
                    resultat.setAlignmentX(Component.CENTER_ALIGNMENT);
                    resultat.setAlignmentY(Component.CENTER_ALIGNMENT);
                    resultat2.setFont(new Font ("Arial", Font.BOLD, 30)); 
                    resultat2.setAlignmentX(Component.CENTER_ALIGNMENT);
                    resultat2.setAlignmentY(Component.CENTER_ALIGNMENT); 
                if(graphe.ChercherSommetPrincipal(sommet1.getText()) == null || graphe.ChercherSommetPrincipal(sommet2.getText()) == null){
                    resultat.setText("Le ou les dispensaires mentionnés sont introuvables.");
                    centre.add(resultat); 
                }else if(sommet1.getText().equals(sommet2.getText())){
                    resultat.setText("Les dispensaires indiqués sont identiques.");
                    centre.add(resultat); 
                }else{
                    if(operation == 0){
                        String str = "Le chemin le plus fiable est : ".concat(graphe.Chemin_LePlus_Fiable(sommet1.getText(), sommet2.getText())); 
                        resultat.setText(str); 
                        JPanel panel = new JPanel(); 
                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                            panel.setBackground(c[0]);
                            panel.add(resultat);
                        JScrollPane jsp = new JScrollPane(panel); 
                        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        jsp.setBackground(c[0]);
                        jsp.setBorder(new LineBorder(c[0]));
                        centre.add(jsp); 
                    }else if(operation == 1){
                        String str1 = "Chemin le plus court en distance : ".concat(graphe.Chemin_LePlus_Court_Distance(sommet1.getText(), sommet2.getText()));
                        String str2 = "Chemin le plus court en durée : ".concat(graphe.Chemin_LePlus_Court_Duree(sommet1.getText(), sommet2.getText()));
                        resultat.setText(str1);
                        resultat2.setText(str2);
                        JPanel panel = new JPanel(); 
                            panel.setBackground(c[0]);
                            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                        panel.add(resultat); 
                        panel.add(resultat2); 
                        JScrollPane jsp = new JScrollPane(panel); 
                        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                        jsp.setBackground(c[0]);
                        jsp.setBorder(new LineBorder(c[0]));
                        centre.add(jsp); 
                    }else{
                        resultat.setText(graphe.Complexite(sommet1.getText(), sommet2.getText()));  
                        centre.add(resultat); 
                    }
                } 
                panel_centre.add(centre, BorderLayout.CENTER); 
                panel_centre.revalidate(); 
                panel_centre.repaint(); 
            }
        });     
    }
}