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
  
    public Ecran_3(){
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
        
        //PANEL CENTRE DE L'ECRAN; 
        panel_centre = new JPanel(new BorderLayout()); 
        panel_centre.setBackground(c[0]);
        
        //AJOUT DE TOUS LES PANEL (NORD, CENTRE, SUD) DANS LE PANEL PRINCIPAL DE L'ECRAN; 
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel_nord, BorderLayout.NORTH);
        getContentPane().add(panel_sud, BorderLayout.SOUTH);
        getContentPane().add(panel_centre, BorderLayout.CENTER); 
        getContentPane().setBackground(c[0]);
        
    }
}