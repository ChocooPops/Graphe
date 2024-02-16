
import javax.swing.*;
import java.awt.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class Ecran_Accueil extends JFrame {
    private JPanel ecran; 
    private JPanel panel_graphe; 
    private static LCGraphe graphe; 
    private JButton [] option; 
    private int x = 1000; 
    private int y = 1025; 
    private JButton chargement; 
    private JButton [] bouton_ecran; 
    private JLabel confirmation_chargement; 
    private JPanel ligne3; 
    private JMenuItem [] item1; 
    private JMenuItem [] item2;
    private String lien_fichier_succ; 
    private String lien_fichier_adj; 
    
    public Ecran_Accueil() {
        //COULEUR              gris clair, gris    bleu clair  bleu foncé   beige
        String [] couleur = {"#dcdcdc", "#C6C6C6", "#cbdbfc", "#7D929E", "#D3CBBE"}; 
        Color [] c = new Color[couleur.length]; 
        for (int i=0; i<c.length; i++){
            c[i] = Color.decode(couleur[i]); 
        }
        getRootPane().setBorder(BorderFactory.createMatteBorder(15, 15, 15, 15, c[3]));
        setTitle("Ecran d'accueil"); 
        setSize(x, y);
        setLocationRelativeTo(null); 
        setResizable(true); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        //CREATION DU MENU; 
        JPanel panel_menu = new JPanel(new BorderLayout());
        JMenuBar menuBar1 = new JMenuBar(); 
        JMenu onglet1 = new JMenu("Edit"); 
        JMenu onglet2 = new JMenu("Choix de l'écran"); 
        item1 = new JMenuItem[4]; 
        item2 = new JMenuItem[5]; 
        item1[0]= new JMenuItem("Fermer"); 
        item1[1]= new JMenuItem("Actualiser"); 
        item1[2]= new JMenuItem("Ajouter la liste des successeurs"); 
        item1[3]= new JMenuItem("Ajouter la liste adjacences"); 
        item2[0] = new JMenuItem("Ecran d'accueil");
        item2[1] = new JMenuItem("Ecran_0");
        item2[2] = new JMenuItem("Ecran_1");
        item2[3] = new JMenuItem("Ecran_2");
        item2[4] = new JMenuItem("Ecran_3");
        for(int i=0; i<item1.length; i++){
            onglet1.add(item1[i]); 
        } 
        for(int i=0; i<item2.length; i++){
            onglet2.add(item2[i]); 
            item2[i].setEnabled(false);
        } 
        menuBar1.add(onglet1); 
        menuBar1.add(onglet2);
        panel_menu.add(menuBar1); 
        panel_menu.setBackground(c[0]);
         
        //CREATION DE L'IMAGE DE BIENVENUE DANS UN PANEL; 
        JPanel panel_bienvenue = new JPanel(); 
        panel_bienvenue.setLayout(new BoxLayout(panel_bienvenue, BoxLayout.Y_AXIS));
        ImageIcon imageIcon = new ImageIcon("src/main/java/image/bienvenue.png"); 
        Image image = imageIcon.getImage().getScaledInstance(282, 66, Image.SCALE_SMOOTH);
        JLabel bienvenue = new JLabel(new ImageIcon(image)); 
        JLabel texte = new JLabel("Bienvenue dans cette aplication d'aide à la décision."); 
        texte.setFont(new Font ("Arial", Font.BOLD, 20));
        bienvenue.setAlignmentX(Component.CENTER_ALIGNMENT); 
        texte.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel_bienvenue.add(Box.createRigidArea(new Dimension(0, 15))); 
        panel_bienvenue.add(bienvenue); 
        panel_bienvenue.add(Box.createRigidArea(new Dimension(0, 15))); 
        panel_bienvenue.add(texte);
        panel_bienvenue.add(Box.createRigidArea(new Dimension(0, 20))); 
        panel_bienvenue.setBackground(c[0]);
            //BOUTON CHARGEMENT; 
        chargement = new JButton(); 
        imageIcon = new ImageIcon("src/main/java/image/bouton_chargement.png"); 
        image = imageIcon.getImage().getScaledInstance(255, 60, Image.SCALE_SMOOTH);
        chargement.setIcon(new ImageIcon(image));
        chargement.setBackground(c[0]);
        chargement.setBorder(new LineBorder(c[0]));
        chargement.setAlignmentX(Component.CENTER_ALIGNMENT); 
        panel_bienvenue.add(chargement); 
        panel_bienvenue.add(Box.createRigidArea(new Dimension(0, 30))); 

        //AJOUT DU MENU ET DE L'AFFICHE DE BIENVENU DANS UN UNIQUE PANEL; 
        JPanel panel_ligne1 = new JPanel(); 
        panel_ligne1.setLayout(new BoxLayout(panel_ligne1, BoxLayout.Y_AXIS));
        panel_ligne1.add(panel_menu); 
        panel_ligne1.add(panel_bienvenue); 
        panel_ligne1.setBackground(c[0]);
        
        //CREATION GRAPHE ET D'UN MESSAGE DE CHARGEMENT INCLUT DANS UN PANEL; 
        panel_graphe = new JPanel();
        panel_graphe.setLayout(new BoxLayout(panel_graphe, BoxLayout.Y_AXIS));
        panel_graphe.setBackground(c[0]);
        
        //AJOUT DES BOUTONS RENVOYANT SUR DIFFERENT ECRAN; 
        JPanel panel_bouton = new JPanel(new GridLayout(1, 4)); 
        panel_bouton.setBackground(c[0]);
        bouton_ecran = new JButton[4]; 
        for(int i=0; i<bouton_ecran.length; i++){
            bouton_ecran[i] = new JButton(); 
            bouton_ecran[i].setBackground(c[0]);
            bouton_ecran[i].setBorder(new LineBorder(c[0]));
        }
            //CREATION DU BOUTON 0; 
        imageIcon = new ImageIcon("src/main/java/image/ecran_0.png"); 
        image = imageIcon.getImage().getScaledInstance(132, 60, Image.SCALE_SMOOTH);
        bouton_ecran[0].setIcon(new ImageIcon(image));
            //CREATION DU BOUTON 1; 
        imageIcon = new ImageIcon("src/main/java/image/ecran_1.png"); 
        image = imageIcon.getImage().getScaledInstance(129, 60, Image.SCALE_SMOOTH);
        bouton_ecran[1].setIcon(new ImageIcon(image));
            //CREATION DU BOUTON 2; 
        imageIcon = new ImageIcon("src/main/java/image/ecran_2.png"); 
        image = imageIcon.getImage().getScaledInstance(132, 60, Image.SCALE_SMOOTH);
        bouton_ecran[2].setIcon(new ImageIcon(image));
            //CREATION DU BOUTON 2; 
        imageIcon = new ImageIcon("src/main/java/image/ecran_3.png"); 
        image = imageIcon.getImage().getScaledInstance(129, 60, Image.SCALE_SMOOTH);
        bouton_ecran[3].setIcon(new ImageIcon(image));
            //AJOUT DES BOUTONS DANS LE PANEL; 
        panel_bouton.add(bouton_ecran[0]); 
        panel_bouton.add(bouton_ecran[1]);
        panel_bouton.add(bouton_ecran[2]);
        panel_bouton.add(bouton_ecran[3]);
            //DESCRIPTION DES BOUTONS; 
        JPanel panel_description = new JPanel(new GridLayout(1, 4)); 
        panel_description.setBackground(c[0]);
        JLabel [] text = new JLabel[4]; 
        text[0] = new JLabel("Analyse à 0 de distance"); 
        text[1] = new JLabel("Analyse à 1 de distance"); 
        text[2] = new JLabel("Analyse à 2 de distance"); 
        text[3] = new JLabel("Analyse à >2 de distance"); 
        for(int i=0; i<text.length; i++){
            text[i].setFont(new Font ("Arial", Font.BOLD, 14));
            panel_description.add(text[i]); 
            text[i].setHorizontalAlignment(SwingConstants.CENTER);
        }
        
        //AJOUT DU PANEL_BOUTON ET DU PANEL_DESCRIPTION; 
        ligne3 = new JPanel(); 
        ligne3.setLayout(new BoxLayout(ligne3, BoxLayout.Y_AXIS));
        ligne3.add(panel_bouton); 
        ligne3.add(panel_description);
        ligne3.add(new JLabel(" ")); 
        ligne3.setVisible(false);
        ligne3.setBackground(c[0]);
        
        //AJOUT DE TOUS LES PANELS CREES PRECEDEMENT DANS LE PANEL PRINCIPAL; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_graphe, BorderLayout.CENTER);
        getContentPane().add(panel_ligne1, BorderLayout.NORTH); 
        getContentPane().add(ligne3, BorderLayout.SOUTH); 
        getContentPane().setBackground(c[0]);
        
        Bouton(); 
    }
    public void Bouton(){
        chargement.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                panel_graphe.removeAll();  
                
                try{
                    graphe = new LCGraphe(); 
                    Traitement_Fichier fic = new Traitement_Fichier(lien_fichier_adj, lien_fichier_succ); 
                    ligne3.setVisible(true);
                    fic.RemplirMaillonPrincip(graphe);
                    fic.RemplirMaillonSec(graphe);
                    PanneauDessin dessin_graphe = new PanneauDessin(graphe);
                    for(int i=1; i<item2.length; i++){
                        item2[i].setEnabled(true);
                    }
                    confirmation_chargement = new JLabel("Graphe chargé avec succès"); 
                    confirmation_chargement.setFont(new Font ("Arial", Font.BOLD, 14));
                    confirmation_chargement.setAlignmentX(Component.CENTER_ALIGNMENT); 
                    panel_graphe.add(confirmation_chargement);
                    panel_graphe.add(dessin_graphe); 
                    panel_graphe.revalidate(); 
                    panel_graphe.repaint();  
                }catch(RuntimeException pb){
                    JLabel erreur = new JLabel("ERREUR LORS DU CHARGEMENT DU GRAPHE"); 
                    JLabel conseil = new JLabel("Vérifier que le fichier d'adjacence et de succesion ont correctement été saisi dans le menu Edit."); 
                        erreur.setFont(new Font ("Arial", Font.BOLD, 30));
                        erreur.setAlignmentX(Component.CENTER_ALIGNMENT);
                        conseil.setFont(new Font ("Arial", Font.BOLD, 20));
                        conseil.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel_graphe.add(Box.createRigidArea(new Dimension(0, 200))); 
                    panel_graphe.add(erreur); 
                    panel_graphe.add(conseil); 
                    panel_graphe.revalidate(); 
                    panel_graphe.repaint();
                } 
            }
        }); 
        bouton_ecran[0].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_0().setVisible(true);
                setVisible(false); 
            }
        }); 
        bouton_ecran[1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_1().setVisible(true);
                setVisible(false); 
            }
        }); 
        bouton_ecran[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_2().setVisible(true);
                setVisible(false); 
            }
        }); 
        bouton_ecran[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                new Ecran_3().setVisible(true);
                setVisible(false); 
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
                new Ecran_Accueil().setVisible(true);
            }
        }); 
        item1[2].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_graphe.removeAll();
                File fle = new File("src\\main\\java\\document"); //Répertoire prédéfini; 
                JFileChooser chose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
                chose.setDialogTitle("Choisisez une liste de successeur : ");
                chose.setCurrentDirectory(fle);
                //Limiter la sélection des fichiers par type; 
                chose.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter accept = new FileNameExtensionFilter("Fichier CSV", "csv");
                chose.addChoosableFileFilter(accept); 
                chose.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int res = chose.showSaveDialog(null);
               
                if(res == JFileChooser.APPROVE_OPTION){
                    File file = chose.getSelectedFile();
                    lien_fichier_succ = file.getAbsolutePath();
                    System.out.println(lien_fichier_succ);
                    JLabel lien = new JLabel(lien_fichier_succ); 
                        lien.setFont(new Font("Arial", Font.BOLD, 20));
                        lien.setAlignmentX(Component.CENTER_ALIGNMENT);
                        JLabel choix = new JLabel("Vous avez choisis le fichier contenant la liste des successeurs :");   
                        choix.setFont(new Font("Arial", Font.BOLD, 25));
                        choix.setAlignmentX(Component.CENTER_ALIGNMENT);
                    panel_graphe.add(Box.createRigidArea(new Dimension(0, 150))); 
                    panel_graphe.add(choix); 
                    panel_graphe.add(lien);
               }
                panel_graphe.revalidate(); 
                panel_graphe.repaint();  
            }
        }); 
        item1[3].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){ 
                panel_graphe.removeAll();
                File fle = new File("src\\main\\java\\document"); //Répertoire prédéfini; 
                JFileChooser chose = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory()); 
                chose.setDialogTitle("Choisisez une liste d'adjacence : ");
                chose.setCurrentDirectory(fle);
                //Limiter la sélection des fichiers par type; 
                chose.setAcceptAllFileFilterUsed(false);
                FileNameExtensionFilter accept = new FileNameExtensionFilter("Fichier CSV", "csv");
                chose.addChoosableFileFilter(accept); 
                chose.setFileSelectionMode(JFileChooser.FILES_ONLY);
                int res = chose.showSaveDialog(null);
               
               if(res == JFileChooser.APPROVE_OPTION){
                    File file = chose.getSelectedFile();
                    lien_fichier_adj = file.getAbsolutePath();
                    JLabel lien = new JLabel(lien_fichier_adj); 
                        lien.setFont(new Font("Arial", Font.BOLD, 20));
                        lien.setAlignmentX(Component.CENTER_ALIGNMENT);
                    JLabel choix = new JLabel("Vous avez choisis le fichier contenant la liste d'adjacences : ");   
                        choix.setFont(new Font("Arial", Font.BOLD, 25));
                        choix.setAlignmentX(Component.CENTER_ALIGNMENT);
                   panel_graphe.add(Box.createRigidArea(new Dimension(0, 150))); 
                   panel_graphe.add(choix); 
                   panel_graphe.add(lien); 
                }
                panel_graphe.revalidate(); 
                panel_graphe.repaint();  
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
    public LCGraphe getGraphe(){
        return graphe; 
    }
    
}