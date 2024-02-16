import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Ecran_0 extends JFrame {
    private int x = 1000; 
    private int y = 1025; 
    private Color [] c; 
    private JButton maternite; 
    private JButton nutrition; 
    private JButton operatoire; 
    private JButton fiabilite; 
    private JButton distance;
    private JButton duree;
    private JButton modification; 
    private JButton decompte; 
    private JButton risque; 
    private JButton afficher_arete; 
    private JButton nb_arete; 
    private JButton [] confirmation; 
    private JMenuItem [] item1; 
    private JMenuItem [] item2; 
    
    private JPanel panel_centre;
    private JTextArea reader;
    private JTextArea nb_risque; 
    private JTextArea nb_valeur; 
    private int choix; 
    private static LCGraphe graphe; 
    
    public Ecran_0(){
        graphe = new Ecran_Accueil().getGraphe();

        //COULEUR              gris clair, gris    bleu clair  bleu foncé   beige
        String [] couleur = {"#dcdcdc", "#C6C6C6", "#cbdbfc", "#7D929E", "#D3CBBE"}; 
        c = new Color[couleur.length]; 
        for (int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
        getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, c[3]));
        setTitle("Ecran_0 : Analyse des élèments à 0 de distance"); 
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
        item2 = new JMenuItem[5]; 
        item1[0]= new JMenuItem("Fermer"); 
        item1[1]= new JMenuItem("Actualiser"); 
        item2[0] = new JMenuItem("Ecran d'accueil");
        item2[1] = new JMenuItem("Ecran_0");
        item2[2] = new JMenuItem("Ecran_1");
        item2[3] = new JMenuItem("Ecran_2");
        item2[4] = new JMenuItem("Ecran_3");
        for(int i=0; i<item1.length; i++){
            onglet1.add(item1[i]); 
        } 
        item1[0].setEnabled(true);
        for(int i=0; i<item2.length; i++){
            onglet2.add(item2[i]); 
        } 
        item2[1].setEnabled(false);
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
            //Creation de l'image titre; 
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/Ecran_0/analyse_0.png"); 
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
            //Instanciation des boutons; 
        maternite = new JButton(); 
            maternite.setBackground(c[0]);
            maternite.setBorder(new LineBorder(c[0]));
        nutrition = new JButton(); 
            nutrition.setBackground(c[0]);
            nutrition.setBorder(new LineBorder(c[0]));
        operatoire = new JButton(); 
            operatoire.setBackground(c[0]);
            operatoire.setBorder(new LineBorder(c[0]));
        decompte = new JButton();
            decompte.setBackground(c[0]);
            decompte.setBorder(new LineBorder(c[0]));
        modification = new JButton(); 
            modification.setBackground(c[0]);
            modification.setBorder(new LineBorder(c[0]));
        risque = new JButton(); 
            risque.setBackground(c[0]);
            risque.setBorder(new LineBorder(c[0]));
        afficher_arete = new JButton(); 
            afficher_arete.setBackground(c[0]);
            afficher_arete.setBorder(new LineBorder(c[0]));
        nb_arete = new JButton(); 
            nb_arete.setBackground(c[0]);
            nb_arete.setBorder(new LineBorder(c[0]));
            
            //Creation des images sur les boutons; 
                //Bouton maternite; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/maternite.png"); 
        image = imageIcon.getImage().getScaledInstance(153, 60, Image.SCALE_SMOOTH);
        maternite.setIcon(new ImageIcon(image));
                //Bouton nutrition; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/nutrition.png"); 
        image = imageIcon.getImage().getScaledInstance(138, 60, Image.SCALE_SMOOTH);
        nutrition.setIcon(new ImageIcon(image));
                //Bouton maternite; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/operatoire.png"); 
        image = imageIcon.getImage().getScaledInstance(183, 60, Image.SCALE_SMOOTH);
        operatoire.setIcon(new ImageIcon(image));
                //Bouton decompte; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/decompte.png"); 
        image = imageIcon.getImage().getScaledInstance(150, 102, Image.SCALE_SMOOTH);
        decompte.setIcon(new ImageIcon(image));
                //Bouton modification; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/modification.png"); 
        image = imageIcon.getImage().getScaledInstance(198, 102, Image.SCALE_SMOOTH);
        modification.setIcon(new ImageIcon(image));
                //Bouton risque; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/risque_trajet.png"); 
        image = imageIcon.getImage().getScaledInstance(126, 102, Image.SCALE_SMOOTH);
        risque.setIcon(new ImageIcon(image));
                //Bouton afficher toutes les artes; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/aretes.png"); 
        image = imageIcon.getImage().getScaledInstance(150, 102, Image.SCALE_SMOOTH);
        afficher_arete.setIcon(new ImageIcon(image));
                //Bouton afficher le nombre d'aretes; 
        imageIcon = new ImageIcon("src/main/java/image/Ecran_0/nb_aretes.png"); 
        image = imageIcon.getImage().getScaledInstance(144, 102, Image.SCALE_SMOOTH);
        nb_arete.setIcon(new ImageIcon(image));
        
            //Creation du panel de la ligne 1 des boutons : Va contenir le bouton maternite, nutrition, operatoire; 
        JPanel ligne1 = new JPanel(new GridLayout(1, 3)); 
        ligne1.add(maternite); 
        ligne1.add(nutrition); 
        ligne1.add(operatoire); 
            //Creation du panel de la ligne 2 des boutons : Va contenir le bouton decompte, modification, risque; 
        JPanel ligne3 = new JPanel(new GridLayout(1, 3)); 
        ligne3.add(decompte); 
        ligne3.add(risque); 
        ligne3.add(modification); 
            //Creation du panel de la ligne 5 des boutons : Afficher 
        JPanel ligne5 = new JPanel(new GridLayout(1,2)); 
        ligne5.add(afficher_arete); 
        ligne5.add(nb_arete); 
            //Creation du texte descriptif; 
        JLabel [] texte = new JLabel[8]; 
        texte[0] = new JLabel("Afficher les dispensaires de type maternité."); 
        texte[1] = new JLabel("Afficher les dispensaires de type nutrition."); 
        texte[2] = new JLabel("Afficher les dispensaires de type bloc opératoire."); 
        texte[3] = new JLabel("Afficher le décompte des dispensaires par type."); 
        texte[4] = new JLabel("Afficher les trajets les plus risquées du graphe."); 
        texte[5] = new JLabel("Modifier une caractéristiques d'un trajet."); 
        texte[6] = new JLabel("Afficher tous les trajets du graphe."); 
        texte[7] = new JLabel("Afficher le nombre de trajet disponible."); 
        for(int i=0; i<texte.length; i++){
            texte[i].setFont(new Font ("Arial", Font.BOLD, 13));
            texte[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
            //Creation des panels pour les boutons; 
        JPanel ligne2 = new JPanel(new GridLayout(1, 3)); 
        ligne2.setBackground(c[0]);
        ligne2.add(texte[0]); 
        ligne2.add(texte[1]); 
        ligne2.add(texte[2]); 
        JPanel ligne4 = new JPanel(new GridLayout(1, 3)); 
        ligne4.setBackground(c[0]);
        ligne4.add(texte[3]); 
        ligne4.add(texte[4]); 
        ligne4.add(texte[5]); 
        JPanel ligne6 = new JPanel(new GridLayout(1, 2)); 
        ligne6.setBackground(c[0]);
        ligne6.add(texte[6]); 
        ligne6.add(texte[7]); 
            //Ajout de tout les boutons dans le panel sud; 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(ligne1); 
        panel_sud.add(ligne2); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(ligne3);
        panel_sud.add(ligne4);
        panel_sud.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_sud.add(ligne5); 
        panel_sud.add(ligne6); 
        panel_sud.add(Box.createRigidArea(new Dimension(0, 15))); 
        
        //PANEL CENTRE DE L'ECRAN; 
        panel_centre = new JPanel(); 
        panel_centre.setBackground(c[0]);
        reader = new JTextArea(); 
        reader.setBackground(c[0]);
        reader.setColumns(10);
        reader.setEditable(false);
        reader.setLineWrap(true);       //Passage automatique à la ligne; 
        reader.setWrapStyleWord(true);  //Mots entiersur une nouvelle ligne; 
        
        //PANEL PRINCIPAL; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_nord, BorderLayout.NORTH); 
        getContentPane().add(panel_sud, BorderLayout.SOUTH); 
        getContentPane().add(panel_centre, BorderLayout.CENTER);
        getContentPane().setBackground(c[0]);
        
        //BOUTON SUPPLEMENTAIRE; 
        confirmation = new JButton[2]; 
        for(int i=0; i<confirmation.length; i++){
            imageIcon = new ImageIcon("src/main/java/image/confirmation.png"); 
            image = imageIcon.getImage().getScaledInstance(186, 60, Image.SCALE_SMOOTH);
            confirmation[i] = new JButton(); 
            confirmation[i].setIcon(new ImageIcon(image)); 
            confirmation[i].setBackground(c[0]);
            confirmation[i].setBorder(new LineBorder(c[0]));
        }
        fiabilite = new JButton(); 
            fiabilite.setBackground(c[0]);
            fiabilite.setBorder(new LineBorder(c[0]));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_0/fiabilite.png"); 
            image = imageIcon.getImage().getScaledInstance(129, 60, Image.SCALE_SMOOTH);
            fiabilite.setIcon(new ImageIcon(image));
        distance = new JButton(); 
            distance.setBackground(c[0]);
            distance.setBorder(new LineBorder(c[0]));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_0/distance.png"); 
            image = imageIcon.getImage().getScaledInstance(132, 60, Image.SCALE_SMOOTH);
            distance.setIcon(new ImageIcon(image));
        duree = new JButton(); 
            duree.setBackground(c[0]);
            duree.setBorder(new LineBorder(c[0]));
            imageIcon = new ImageIcon("src/main/java/image/Ecran_0/duree.png"); 
            image = imageIcon.getImage().getScaledInstance(96, 60, Image.SCALE_SMOOTH);
            duree.setIcon(new ImageIcon(image));
            
        Bouton(); 
    }
    
    public void Bouton(){
        maternite.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS)); 
                panel_centre.setBorder(new LineBorder(c[0])); 
    
                JLabel texte = new JLabel("Le nom des dispensaires de type Maternité sont : ");
                reader.setText(graphe.printMaternité());
                reader.setBorder(new LineBorder(c[0]));
                texte.setAlignmentX(Component.CENTER_ALIGNMENT);  
                reader.setAlignmentX(Component.CENTER_ALIGNMENT); 
                reader.setFont(new Font ("Arial", Font.BOLD, 30));
                texte.setFont(new Font ("Arial", Font.BOLD, 30));
                
                panel_centre.add(Box.createRigidArea(new Dimension(0, 100))); 
                panel_centre.add(texte); 
                panel_centre.add(Box.createRigidArea(new Dimension(0, 30))); 
                panel_centre.add(reader);
                panel_centre.revalidate(); 
                panel_centre.repaint();
            }
        }); 
        nutrition.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS)); 
                panel_centre.setBorder(new LineBorder(c[0])); 
    
                JLabel texte = new JLabel("Le nom des dispensaires de type Nutrition sont : ");
                reader.setText(graphe.printNutrition());
                reader.setBorder(new LineBorder(c[0]));
                texte.setAlignmentX(Component.CENTER_ALIGNMENT);  
                reader.setAlignmentX(Component.CENTER_ALIGNMENT); 
                reader.setFont(new Font ("Arial", Font.BOLD, 30));
                texte.setFont(new Font ("Arial", Font.BOLD, 30));
                
                panel_centre.add(Box.createRigidArea(new Dimension(0, 100))); 
                panel_centre.add(texte); 
                panel_centre.add(Box.createRigidArea(new Dimension(0, 30))); 
                panel_centre.add(reader);
                panel_centre.revalidate(); 
                panel_centre.repaint();
            }
        }); 
        operatoire.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS)); 
                panel_centre.setBorder(new LineBorder(c[0])); 
    
                JLabel texte = new JLabel("Le nom des dispensaires de type Bloc Opératoire sont : ");
                reader.setText(graphe.printBloc());
                reader.setBorder(new LineBorder(c[0]));
                texte.setAlignmentX(Component.CENTER_ALIGNMENT);  
                reader.setAlignmentX(Component.CENTER_ALIGNMENT); 
                reader.setFont(new Font ("Arial", Font.BOLD, 30));
                texte.setFont(new Font ("Arial", Font.BOLD, 30));
                
                panel_centre.add(Box.createRigidArea(new Dimension(0, 100))); 
                panel_centre.add(texte); 
                panel_centre.add(Box.createRigidArea(new Dimension(0, 30))); 
                panel_centre.add(reader);
                panel_centre.revalidate(); 
                panel_centre.repaint();
            }
        });
        decompte.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new GridLayout(1, 1)); 
                panel_centre.setBorder(new LineBorder(c[0])); 
    
                JLabel reader = new JLabel(graphe.DécompteNoeud());
                reader.setHorizontalAlignment(JLabel.CENTER);
                reader.setFont(new Font ("Arial", Font.BOLD, 20));
                reader.setHorizontalAlignment(SwingConstants.CENTER);
                reader.setVerticalAlignment(SwingConstants.CENTER);

                panel_centre.add(reader);
                panel_centre.revalidate(); 
                panel_centre.repaint();
            }
        });
        risque.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BorderLayout()); 
                panel_centre.setBorder(new LineBorder(Color.BLACK)); 
                JLabel erreur = new JLabel(); //Message d'erreur si un la valeur rentrer n'est pas un nombre; 
                
                JPanel BoxSud = new JPanel(); 
                BoxSud.setLayout(new BoxLayout(BoxSud, BoxLayout.Y_AXIS)); 
                BoxSud.setBackground(c[0]);
                JPanel sud = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                sud.setBackground(c[0]);
                nb_risque = new JTextArea(); 
                nb_risque.setColumns(25);
                nb_risque.setBorder(new LineBorder(Color.BLACK));
                JLabel texte = new JLabel("Saisissez une fiabilité (entre 0% et 100%) : ");
                texte.setFont(new Font ("Arial", Font.BOLD, 20));
                sud.add(texte); 
                sud.add(nb_risque); 
                BoxSud.add(sud); 
                JPanel nord = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10)); 
                nord.setBackground(c[0]);
                nord.add(confirmation[0]);
                panel_centre.add(BoxSud, BorderLayout.NORTH);
                panel_centre.add(nord, BorderLayout.SOUTH);
                panel_centre.revalidate(); 
                panel_centre.repaint();
                
                JPanel centre = new JPanel(new BorderLayout());
                JScrollPane scrolleur = new JScrollPane();
                scrolleur.setBorder(new LineBorder(c[2]));
                
                confirmation[0].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){ 
                        panel_centre.remove(centre);
                        centre.remove(reader);
                        try{
                            erreur.setText("");
                            int num = Integer.parseInt(nb_risque.getText()); 
                            if(num>=0 && num <=100){
                                reader.setFont(new Font ("Arial", Font.BOLD, 15));
                                reader.setText(graphe.Lister_Trajet_LePlus_Risqué(num));
                                reader.setBorder(new LineBorder(Color.BLACK)); 
                                scrolleur.setViewportView(reader);
                                centre.add(scrolleur, BorderLayout.CENTER);
                            }else{
                                reader.setText("Valeur de la fiabilité incorrect." + '\n' + "Les valeurs admisent sont entre 0% et 100%.");
                                reader.setFont(new Font ("Arial", Font.BOLD, 40));
                            }
                            panel_centre.add(centre, BorderLayout.CENTER); 
                            panel_centre.revalidate(); 
                            panel_centre.repaint();
                        }catch (NumberFormatException pb){
                            erreur.setText(("ERREUR : La valeur choisis est incorrect."));
                            JPanel panel = new JPanel(new GridLayout(1, 1)); 
                            erreur.setFont(new Font ("Arial", Font.BOLD, 20));
                            erreur.setHorizontalAlignment(SwingConstants.CENTER);
                            erreur.setVerticalAlignment(SwingConstants.CENTER);
                            panel_centre.add(erreur, BorderLayout.CENTER); 
                            panel_centre.revalidate(); 
                            panel_centre.repaint();
                        }
                    }
                 });
            }
        });
        modification.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BorderLayout()); 
                panel_centre.setBorder(new LineBorder(Color.BLACK)); 
                choix = 0; 
                JLabel resultat = new JLabel(""); 
                    resultat.setFont(new Font ("Arial", Font.BOLD, 20));
                    resultat.setHorizontalAlignment(SwingConstants.CENTER);
                    resultat.setVerticalAlignment(SwingConstants.CENTER);

                //PANEL SUD; 
                JPanel panel_sud = new JPanel(); 
                panel_sud.setLayout(new BoxLayout(panel_sud, BoxLayout.Y_AXIS));
                panel_sud.setBackground(c[0]);
                JLabel texte_choix = new JLabel("Choisissez une caractéristique à changer."); 
                texte_choix.setFont(new Font ("Arial", Font.BOLD, 14));
                texte_choix.setAlignmentX(Component.CENTER_ALIGNMENT);
                JPanel panel_bouton = new JPanel(new GridLayout(1, 3)); 
                panel_bouton.add(fiabilite); 
                panel_bouton.add(distance); 
                panel_bouton.add(duree); 
                panel_sud.add(texte_choix);
                panel_sud.add(Box.createRigidArea(new Dimension(0, 10)));
                panel_sud.add(panel_bouton); 
                panel_sud.add(Box.createRigidArea(new Dimension(0, 30)));
                JPanel panel_confirmation = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panel_confirmation.setBackground(c[0]);
                panel_confirmation.add(confirmation[1]);
                panel_sud.add(panel_confirmation); 
                panel_sud.add(Box.createRigidArea(new Dimension(0, 5))); 
                
                //PANEL NORD; 
                JPanel panel_nord = new JPanel(); 
                panel_nord.setLayout(new BoxLayout(panel_nord, BoxLayout.Y_AXIS));
                panel_nord.setBackground(c[0]);
                JTextArea sommet1 = new JTextArea(); 
                    sommet1.setColumns(10);
                    sommet1.setBorder(new LineBorder(Color.BLACK));
                JTextArea sommet2 = new JTextArea(); 
                    sommet2.setColumns(10);
                    sommet2.setBorder(new LineBorder(Color.BLACK));
                JLabel nom1 = new JLabel("Saisissez le nom d'un dispensaire : "); 
                    nom1.setFont(new Font ("Arial", Font.BOLD, 14));
                JLabel nom2 = new JLabel("Saisissez le nom d'un autre dispensaire : "); 
                    nom2.setFont(new Font ("Arial", Font.BOLD, 14));
                JPanel panel_sommet1 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                    panel_sommet1.add(nom1); 
                    panel_sommet1.add(sommet1); 
                    panel_sommet1.setBackground(c[0]);
                JPanel panel_sommet2 = new JPanel(new FlowLayout(FlowLayout.CENTER)); 
                    panel_sommet2.add(nom2); 
                    panel_sommet2.add(sommet2); 
                    panel_sommet2.setBackground(c[0]);
                JPanel panel_nombre = new JPanel(new FlowLayout(FlowLayout.CENTER));
                panel_nombre.setBackground(c[0]);
                    JLabel choix_nb = new JLabel("Saisisez une valeur : "); 
                    choix_nb.setFont(new Font ("Arial", Font.BOLD, 14));
                    nb_valeur = new JTextArea(); 
                    nb_valeur.setColumns(10);
                    nb_valeur.setBorder(new LineBorder(Color.BLACK));
                    panel_nombre.add(choix_nb); 
                    panel_nombre.add(nb_valeur);
                JPanel panel_sommet = new JPanel(new GridLayout(1, 2)); 
                    panel_sommet.add(panel_sommet1); 
                    panel_sommet.add(panel_sommet2);
                    panel_nord.add(panel_sommet); 
                    panel_nord.add(Box.createRigidArea(new Dimension(0, 15)));
                    panel_nord.add(panel_nombre); 
                
                //PANEL CENTRE; 
                panel_centre.add(resultat, BorderLayout.CENTER); 
                panel_centre.add(panel_sud, BorderLayout.SOUTH);
                panel_centre.add(panel_nord, BorderLayout.NORTH);
                panel_centre.revalidate(); 
                panel_centre.repaint();
                
                fiabilite.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        choix = 1;
                        resultat.setText("");
                        texte_choix.setText("Vous voulez modifier la fiabilité. (Cliquez sur Confirmation pour valider l'opération)");
                    }
                 });
                distance.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        choix = 2;
                        resultat.setText("");
                        texte_choix.setText("Vous voulez modifier la distance. (Cliquez sur Confirmation pour valider l'opération)");
                    }
                 });
                duree.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        choix = 3;
                        resultat.setText("");
                        texte_choix.setText("Vous voulez modifier la durée. (Cliquez sur Confirmation pour valider l'opération)");
                    }
                 });
                confirmation[1].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        try{
                           int num = Integer.parseInt(nb_valeur.getText()); 
                        if(choix == 0){
                            resultat.setText("Selectionnez d'abord une caractéristique à modifier.");
                        }else if (nb_valeur.getText().equals("") || sommet1.getText().equals("") || sommet2.getText().equals("")){
                             resultat.setText("Veuillez d'abord remplir tous les champs ci-dessus.");
                        }else{
                            resultat.setText(graphe.Modifier_Fiabilite(num, choix, sommet1.getText(), sommet2.getText()));
                        } 
                        }catch(NumberFormatException pb){
                           resultat.setText("ERREUR : La valeur choisis est incorrect.");
                        }  
                    }
                 });
            }
        });
       afficher_arete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){       
                panel_centre.removeAll();
                panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS)); 
                panel_centre.setBorder(new LineBorder(c[0])); 

                JLabel texte = new JLabel("Affichage de toutes les arêtes : ");
                texte.setFont(new Font ("Arial", Font.BOLD, 25));
                
                JPanel panel_reader = new JPanel(new BorderLayout()); 
                panel_reader.setBorder(new LineBorder(Color.BLACK));
                reader.setText(graphe.ListerArete());
                texte.setAlignmentX(Component.CENTER_ALIGNMENT);  
                reader.setFont(new Font ("Arial", Font.BOLD, 15)); 
                JScrollPane scrolleur = new JScrollPane(reader);
                scrolleur.setBorder(new LineBorder(c[2]));
                panel_reader.add(scrolleur, BorderLayout.CENTER); 
                
                panel_centre.add(Box.createRigidArea(new Dimension(0, 10))); 
                panel_centre.add(texte); 
                panel_centre.add(Box.createRigidArea(new Dimension(0, 15))); 
                panel_centre.add(panel_reader);
                panel_centre.revalidate(); 
                panel_centre.repaint();
            }
        }); 
       nb_arete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_centre.removeAll();
                panel_centre.setLayout(new BoxLayout(panel_centre, BoxLayout.Y_AXIS));  
                
                //DEFINITION DU NOUVEAU PANEL CONTENANT LE NOMBRE D'ARETE; 
                JPanel panel_resultat = new JPanel(new GridLayout(1, 1)); 
                panel_resultat.setBackground(c[0]);
                JLabel resultat = new JLabel(graphe.nbArete()); 
                resultat.setFont(new Font ("Arial", Font.BOLD, 50)); 
                resultat.setHorizontalAlignment(SwingConstants.CENTER);
                resultat.setVerticalAlignment(SwingConstants.CENTER);
                panel_resultat.add(resultat); 
                
                panel_centre.add(panel_resultat); 
                panel_centre.revalidate(); 
                panel_centre.repaint();
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
                new Ecran_0().setVisible(true);
            }
        }); 
       item2[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_Accueil().setVisible(true);
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
    public LCGraphe getGraphe(){
        return this.graphe; 
    }
}
   
