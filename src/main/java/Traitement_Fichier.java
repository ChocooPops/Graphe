
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator; 

public class Traitement_Fichier {
    private Scanner fic1; 
    private Scanner fic2; 
    ArrayList<String> fichier1;
    ArrayList<String> fichier2;
    
    private void Réinitialise_Buffer(String lien1, String lien2){
        try{
            fic1 = new Scanner(new FileInputStream(lien1));
            fic2 = new Scanner(new FileInputStream(lien2)); 
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public Traitement_Fichier(String lien1, String lien2) {
            Réinitialise_Buffer(lien1, lien2); 
            fichier1 = new ArrayList<>(); 
            while(fic1.hasNext()){
                fichier1.add(fic1.nextLine()); 
            }
            fichier2 = new ArrayList<>(); 
            while(fic2.hasNext()){
                fichier2.add(fic2.nextLine()); 
            }
            Collections.reverse(fichier1); 
            Collections.reverse(fichier2); 
    }
    
    //Affichier le fichier de la liste d'adjacence-jeuEssai ligne par ligne; 
    public void AfficherFic1(){
        for(int i=0; i<fichier1.size(); i++){
            System.out.println(fichier1.get(i));
        }
    }
    //Affichier le fichier de la liste de successeur ligne par ligne; 
    public void AfficherFic2(){
        for(int i=0; i<fichier2.size(); i++){
            System.out.println(fichier2.get(i));
        }
    }
    
    //Méthode pour remplir le Graphe Principal; 
    public void RemplirMaillonPrincip(LCGraphe graphe){
        for(String str : fichier1){
            String [] s = str.split(";"); 
            graphe.ajoutMaillonP(s[0], s[1]);
        }
        //OU
        /*
        for(int i = 0; i<fichier1.size(); i++){
            String [] str = fichier.get(i).split(";"); 
            graphe.ajoutMaillonP(str[0], str[1]);
        }
        */
    }
 
    //Methode pour remplir le Second Maillon; 
    public String getNomSommet(int i){
        //La variable i correspond au numéro de la ligne pour récuppérer le nom du Sommet; 
        //Si i = 0, la collections du fichier1 va prendre la ligne 1 qui correspond au Sommet 1; 
        String [] s = fichier1.get(i).split(";"); 
        return s[0]; 
    }
    public String getNomVoisin(int nbligne, int nbSommet){
        //Le fichier 2 représente un sommmet unique sur chaques lignes, et ses sommets voisins sont dans les colonnes;
        //nbligne représente la ligne(ligne 1 (d'indice 0) indique qu'on traite le sommet 1);
        //nbSommet correspond à un sommet voisin de la la colonne de nbligne;
        ArrayList<String> classement = new ArrayList<>();
        String [] str = fichier2.get(nbligne).split(";");
        for(int i = 1; i<str.length; i++){
            classement.add(str[i]);
        }
        Collections.sort(classement, new Comparator<String>(){
            public int compare(String s1, String s2){
                int n1 = Integer.parseInt(s1); 
                int n2 = Integer.parseInt(s2); 
                return n1 - n2; 
            }
        });
        //Classe les sommets voisins d'une ligne par ordre croissant;
        return "S".concat(classement.get(nbSommet)); 
    }
    
    public void RemplirMaillonSec(LCGraphe graphe){
        int nb = 1; 
        //Boucle qui va traiter sommet par sommet, "S[i]", c'est-à-dire ligne par ligne (car les caractéristiques d'un sommet sont sur une ligne); 
        for(int i=0; i<fichier1.size(); i++){
            //Supprime la chaine de caractères ";0" dans à la ligne [i] du fichier d'adjacence;  
            String str = fichier1.get(i).replaceAll(";0", "");
            //Crée un tableau de String qui va diviser la chaine de caractère da la ligne[i], et va répartir une chaine dans un indice séparé lorsqu'un point virgule apparait; 
            String [] tmp = str.split(";"); 
            //instancie un int g qui servira à récupérer le Sommet voisin de i, selon la colonne g;  
            int g=0; 
            //Boucle qui va lire les caractèristiques d'une arretes sur la ligne en question (on commence à j=2 pour ne pas lire le nom du sommet et son type); 
            for (int j=2; j<tmp.length; j++){
                //Crée un tableau de String pour obtenir distinctement les information de l'arrete[j] qui sont séparé par une virgule; 
                String [] valeur = tmp[j].split(",");
                //Convertit les indices du tableau de String tab[0] tab[1] tab[2] en Double; 
                double fiabilite = Double.parseDouble(valeur[0]); 
                double distance = Double.parseDouble(valeur[1]); 
                double durée = Double.parseDouble(valeur[2]);
                String s = "A" + nb; 
                
                //Appel le fonction Savoir_Si_2Sommets_Relié() dans le classe LCGraphe; 
                //Vérifie si deux sommets sont déja relié avant d'ajouter un second maillon; 
                //Si deux sommets sont déjà la relié, la fonction renvoie true et n'ajoute pas de second maillon; 
                if(!graphe.Savoir_Si_2Sommets_Relié(getNomSommet(i), getNomVoisin(i, g))){
                    //Crée un Maillon Secondaire avec les informations obtenue; 
                    //Appelle la méthode getNomSommet pour récupérer le nom du Sommet selon la ligne[i], (Dépend de la poremière boucle, ex : la ligne 3 correspond au sommet 3 et i=2); 
                    //Appelle la méthode getNomVoisin pour récupérer le nom du Sommet Voisin dont l'information est présente dans le fichier2, et dépend de la colonne[g]; 
                    graphe.ajoutMaillonSec(getNomSommet(i), getNomVoisin(i, g), fiabilite, distance ,durée, s);
                    //Augmente de 1 pour changer le nom d'une arête en prenant le nombre qui lui précède; 
                    nb++; 
                }
                //Augmente de 1 pour prendre la colonne suivante de la ligne[i] pour y associé l'arrete suivante; 
                g = g+1;
            } 
        }
    }
}
