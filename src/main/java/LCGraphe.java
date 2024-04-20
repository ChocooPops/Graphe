
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class LCGraphe { 
    
    class MaillonGrapheSec {
        private double fiabilite; 
        private double distance; 
        private double duree;
        private String dest;
        private String nomB; 
        private MaillonGrapheSec suiv; 
        //CLASS DES ARRETES; 
    public MaillonGrapheSec(double f, double dis, double dur, String des, String nomB){
            this.fiabilite = f;
            this.distance = dis;
            this.duree = dur;
            this.dest = des;
            this.suiv = null;  
            this.nomB = nomB;  
        } 
    }
        //CLASSE DES SOMMETS; 
    class MaillonPrincipal{
        private String nom; 
        private String type;
        private MaillonGrapheSec voisin; 
        private MaillonPrincipal suiv; 
        
     public MaillonPrincipal(String n,String t){
            this.nom= n;
            this.type = t;
            this.voisin = null;
            this.suiv = null;  
        }
    }
    private MaillonPrincipal premier;
    
    public LCGraphe(){
        this.premier = null;
    }
    
    public void ajoutMaillonP(String ori, String t)
    {
        MaillonPrincipal nouv = new MaillonPrincipal(ori ,t);
        nouv.suiv = this.premier;
        this.premier = nouv;
    }
    
    public void ajoutMaillonSec(String nom, String des, double f, double dis, double dur, String nomB){
        MaillonGrapheSec nouv = new MaillonGrapheSec(f, dis, dur, des, nomB);
        MaillonPrincipal tmp = this.premier;
        while (!tmp.nom.equals(nom)){
            tmp = tmp.suiv; 
        }
        nouv.suiv = tmp.voisin; 
        tmp.voisin = nouv;  
        
        MaillonGrapheSec nouv2 = new MaillonGrapheSec(f, dis, dur, nom, nomB); 
        tmp = this.premier; 
        while (!tmp.nom.equals(des)){
            tmp = tmp.suiv; 
        }
        nouv2.suiv = tmp.voisin; 
        tmp.voisin = nouv2; 
        
    }
    
    public String toString(){
        String s =""; 
        MaillonPrincipal tmp = this.premier;
        while (tmp != null){
            s=s + tmp.nom + "_" + tmp.type + " --> "; 
            MaillonGrapheSec tmp2 = tmp.voisin;
            while (tmp2 != null){
                s = s + tmp2.dest + "(Fiabilite : " + tmp2.fiabilite +", distance : "+ tmp2.distance + ", duree : " + tmp2.duree + ", NomArête : " + tmp2.nomB + "); "; 
                tmp2 = tmp2.suiv; 
            }
            s = s + '\n'; 
            tmp = tmp.suiv; 
        }
        return s;
    }
    //F4_Modifier la fiabilité des trajets à partir d’une interface de saisie;
        //Méthode pour chercher le sommet principale avec le nom;  
    public MaillonPrincipal ChercherSommetPrincipal(String nom){
        boolean op = false; 
        MaillonPrincipal tmp = this.premier; 
        MaillonPrincipal sommet = null; 
        while(tmp != null && sommet == null){
            if(tmp.nom.equals(nom)){
                sommet = tmp; 
            }else{
                tmp = tmp.suiv; 
            }
        }
        return sommet; 
    }
    
//===================================================================================================================================
    //METHODE utilisé pour l'affichage du graphe dans la classe PanneauDessin;
        //SERVIRA A CREER TOUS LES SOMMETS DU GRAPHE; 
    public String getNomSommet(){
        MaillonPrincipal sommet = this.premier; 
        String s = ""; 
        if(sommet != null){
            while(sommet != null){
                if(sommet.suiv == null){
                    s = s.concat(sommet.nom); 
                }else{
                    s = s.concat(sommet.nom).concat(";"); 
                }
                sommet = sommet.suiv; 
            }
        }
        return s; 
    }
    //SERVIRA A RELIE LES SOMMMETS A SES VOISINS; 
    public String getNomVoisin(String nom1){
        String s = ""; 
        MaillonPrincipal sommet = ChercherSommetPrincipal(nom1); 
        if(sommet != null){
            MaillonGrapheSec sommet2 = sommet.voisin; 
            while(sommet2 != null){
                if(sommet2.suiv == null){
                    s = s.concat(sommet2.dest);  
                }else{
                    s = s.concat(sommet2.dest).concat(";"); 
                }
                sommet2 = sommet2.suiv; 
            }
        }
        return s; 
    }
        //SERVIRA A DEFINIR LA COULEUR DES SOMMETS SELON LEUR TYPE; 
    public String getType(String nom1){
        MaillonPrincipal sommet = ChercherSommetPrincipal(nom1); 
        return sommet.type; 
    }
    public String getNomArete(String nom1){
        MaillonPrincipal sommet1 = ChercherSommetPrincipal(nom1); 
        MaillonGrapheSec sommet2 = sommet1.voisin; 
        String s = ""; 
        while (sommet2 != null){
            if(sommet2.suiv == null){
                    s = s + sommet2.nomB;  
                }else{
                    s = s + sommet2.nomB + ";"; 
                }
                sommet2 = sommet2.suiv; 
        }
        return s; 
    }
    public String getCara(){
        MaillonPrincipal sommet1 = this.premier; 
        String s= "";
        while (sommet1 != null){
            MaillonGrapheSec sommet2 = sommet1.voisin; 
            s = s + sommet1.nom + ";" + sommet1.type; 
            while(sommet2 != null){
                s = s + ";" + sommet2.fiabilite +", " + sommet2.distance + ", " + sommet2.duree; 
                sommet2 = sommet2.suiv; 
            }
            sommet1 = sommet1.suiv;
            s = s + '\n'; 
        }
        return s; 
    }
//===================================================================================================================================    
        
        //Méthode : Savoir si deux sommets données sont voisins à 1 de distance;  
    public boolean Savoir_Si_2Sommets_Relié(String nom1, String nom2){
        MaillonPrincipal sommet1 = ChercherSommetPrincipal(nom1); 
        boolean op = false;
        MaillonGrapheSec sommet2 = null;
        if (sommet1 != null){
            MaillonGrapheSec tmp2 = sommet1.voisin; 
            while(tmp2 != null && sommet2 == null){
                if(tmp2.dest.equals(nom2)){
                    sommet2 = tmp2; 
                    op = true; 
                }
                tmp2 = tmp2.suiv;
            }
        }
        return op; 
    }    
        //Methode privé pour changer une des caractéristques parmi la fiabilité, la distance et la durée; 
    private void Changer_Caractéristique(MaillonGrapheSec sommet, int cara, double nb){
        if(cara == 1){
            nb = nb/10; 
            sommet.fiabilite = nb; 
        }else if(cara == 2){
            sommet.distance = nb; 
        }else{
            sommet.duree = nb; 
        }
    }
    public String Modifier_Fiabilite(double nb, int cara, String nomSom, String nomDest){ 
        String s = ""; 
        if(Savoir_Si_2Sommets_Relié(nomSom, nomDest)){ 
            MaillonPrincipal sommet;  
            sommet = ChercherSommetPrincipal(nomSom);
            if(sommet != null){
                MaillonGrapheSec tmp2 = sommet.voisin; 
                MaillonGrapheSec sommet2 = null; 
                while(tmp2 != null && sommet2 == null){
                    if(tmp2.dest.equals(nomDest)){
                        sommet2 = tmp2; 
                        Changer_Caractéristique(sommet2, cara, nb); 
                    }else{
                        tmp2 = tmp2.suiv; 
                    }
                }
                if(sommet2 != null){
                     sommet = ChercherSommetPrincipal(nomDest);
                     sommet2 = null; 
                     tmp2 = sommet.voisin;
                     while(tmp2 != null && sommet2 == null){
                        if(tmp2.dest.equals(nomSom)){ 
                            sommet2 = tmp2;
                            Changer_Caractéristique(sommet2, cara, nb);
                            s = "Changement effectué"; 
                    }else{
                        tmp2 = tmp2.suiv; 
                    }
                }
                }else{
                    s = "Le sommet destinataire indiqué est n'existe pas (Ex de format valide : S24), ou n'est pas voisin du sommet principal."; 
                }
            }else{
                s = "Le sommet principal est introuvabel (Ex de format valide : S13)."; 
            }
        }else if(ChercherSommetPrincipal(nomSom) == null || ChercherSommetPrincipal(nomDest) == null){
            s = "Le ou les noms des dispensaires indiqués sont introuvables"; 
        }else{
             s = "Le nom des dispensaires choisis ne sont pas voisins."; 
        }
        return s; 
    }
    
    //Type de Sommet_F5;
        //Afficher dispensaires de type Maternité; 
    public String printMaternité(){
        String s = "";  
        MaillonPrincipal tmp = this.premier; 
        while (tmp != null){
            if (tmp.type.equals("M")) {
                s = s + tmp.nom + " - ";
            }
            tmp=tmp.suiv;
        }
        s = s.replaceAll(" - $", ""); //Effacer le caractère " - " pour une meilleure visibilité; 
        return s;
    }
        //Afficher dispensaires de type Hopital; 
    public String printBloc(){
        String s = ""; 
        MaillonPrincipal tmp = this.premier;
        while (tmp != null){
            if (tmp.type.equals("O")) {
                s = s + tmp.nom + " - ";
            }
            tmp=tmp.suiv;
        }
        s = s.replaceAll(" - $", "");
        return s; 
    }
        //Afficher dispensaires de type Bloc Opératpoire; 
    public String printNutrition(){
        String s = ""; 
        MaillonPrincipal tmp = this.premier; 
        while (tmp != null){
            if (tmp.type.equals("N")) {
                s = s + tmp.nom + " - ";
            }
            tmp=tmp.suiv;
        }
        s = s.replaceAll(" - $", "");
        return s;
    }
        //Décompte les noeuds du graphe par type; 
    public String DécompteNoeud(){
        int o = 0; 
        int n = 0; 
        int m = 0; 
        MaillonPrincipal tmp = this.premier; 
        while(tmp != null){
            if (tmp.type.equals("O")){
                o++; 
            }else if (tmp.type.equals("N")){
                n++; 
            }else{
                m++; 
            }
            tmp = tmp.suiv; 
        }
        String s = "Parmi tous les dispensaires, il y a " + o + " blocs opératoires, " + n + " centres de nutritons, et " + m + " Maternités."; 
        return s; 
    }
        //F5-2_Afficher les trajets les plus risqués du graphe (au-delà d’un seuil saisi auprès de l’utilisateur); 
    public String Lister_Trajet_LePlus_Risqué(double fiabilité){
        ArrayList<String> nomArrete = new ArrayList<>(); 
        fiabilité = fiabilité / 10; 
        MaillonPrincipal tmp = this.premier; 
        String s = ""; 
        int i = 0;
        int nb = 0; 
        while(tmp != null){
            MaillonGrapheSec tmp2 = tmp.voisin;
            while(tmp2 != null){
                if (tmp2.fiabilite <= fiabilité && !nomArrete.contains(tmp2.nomB)){ //Regarde si la fiabilite de l'arete est inférieur ou égale à celle mentionné et si le nom de l'arete n'a pas déjà été traité; 
                    s = s + tmp.nom + " <--" + tmp2.nomB + "--> " + tmp2.dest + "(" + tmp2.fiabilite + " "+ tmp2.distance + " " + tmp2.duree + ")   "; 
                    nomArrete.add(tmp2.nomB); //Ajoute le nom de l'arrete dont la fiabilite est inférieur pour ne pas traité deux fois la même arrete; 
                    i = i+1;
                    nb = nb + 1; 
                }
                tmp2 = tmp2.suiv; 
                if(i==4){
                    s = s+ '\n';
                    i=0;
                }
            }
            tmp = tmp.suiv; 
        }
        if(nb != 0){
            s = "Il y a " + nb + " arêtes qui ont une fiabilité inférieure ou égale à " + fiabilité*10 + "% : " + '\n' + s; 
        }else{
            s = "Il n'y a aucune arête qui a une fiabilité inférieure ou égale à " + fiabilité*10 + "%."; 
        }
        return s; 
    }
    
    //Arete_F6; 
        //Lister le nombre d'arêtes dans le graphe; 
    public String nbArete(){
        int i =0;  
        MaillonPrincipal tmp = this.premier; 
        while(tmp != null){
            MaillonGrapheSec tmp2 = tmp.voisin;
            while(tmp2 != null){
                i++; 
                tmp2 = tmp2.suiv; 
            }
            tmp = tmp.suiv; 
        }
        return "Il y a " + i/2 + " arêtes/trajets au total."; 
    }
        //Lister toutes les arêtes; 
    public String ListerArete(){
        ArrayList<String> nomArrete = new ArrayList<>(); 
        String s = "";  
        MaillonPrincipal tmp = this.premier; 
        int ligne = 0; 
        while(tmp != null){
            MaillonGrapheSec tmp2 = tmp.voisin; 
            ligne=0;
            while(tmp2 != null){
                if(!nomArrete.contains(tmp2.nomB)){ //REGARDE SI la liste ne contient pas le nom d'une arrete déjç traité; 
                    s = s + tmp.nom + " <--" + tmp2.nomB + "--> " + tmp2.dest + "(" + tmp2.fiabilite + "-" + tmp2.distance+ "-" + tmp2.duree + ") "; 
                    nomArrete.add(tmp2.nomB);
                    ligne = 1; 
                }
                tmp2 = tmp2.suiv; 
            }
            if(ligne == 1){
                s = s + '\n'; 
            }
            tmp = tmp.suiv; 
        }
        return s;
    }
    
        //F7_Pour un sommet donné, lister les voisins directs(noeuds à 1-distance);  
    public String Lister_Sommet_1_Distance(String nom){ 
        MaillonPrincipal sommet = null; 
        sommet = ChercherSommetPrincipal(nom); 
        String s = ""; 
        if(sommet != null){
            MaillonGrapheSec tmp2 = sommet.voisin;
            while(tmp2 != null){
                s = s + tmp2.dest + "-"; 
                tmp2 = tmp2.suiv; 
            }
            s = s.replaceFirst("-$", "");
        }else{
            s = "Ce sommet n'existe pas."; 
        }
        return s;
    }
    public String Lister_Sommet_1_Distance1(String nom){ 
        MaillonPrincipal sommet = null; 
        sommet = ChercherSommetPrincipal(nom); 
        String s = ""; 
        if(sommet != null){
            MaillonGrapheSec tmp2 = sommet.voisin;
            while(tmp2 != null){
                s = s + tmp2.dest +"_" + getType(tmp2.dest) + " - "; 
                tmp2 = tmp2.suiv; 
            }
            s = s.replaceFirst(" - $", "");
        }else{
            s = "Ce sommet n'existe pas."; 
        }
        return s;
    }
    
    
        //F8_Pour une arête donnée, lister les sommets qu'elle relie; 
        //Methode 1 : seulement avec le nom; 
    public String Lister_Sommet_PourUne_Arete_Donné2(String nomA){
        String s = ""; 
        MaillonPrincipal tmp = this.premier; 
        MaillonGrapheSec arete = null; 
        while(tmp != null && arete == null){
            MaillonGrapheSec tmp2 = tmp.voisin; 
            while(tmp2 != null && arete == null){
                if(tmp2.nomB.equals(nomA)){
                    arete = tmp2; 
                }else{
                    tmp2 = tmp2.suiv; 
                }
            }if(arete == null){
                tmp = tmp.suiv;
            }
        }
        if(arete != null){
            
            MaillonPrincipal sommet1 = tmp; 
            MaillonPrincipal sommet2 = ChercherSommetPrincipal(arete.dest);
            s = "L'arête " + nomA + " relie le sommet " + sommet1.nom + " de type " + sommet1.type + " au sommet " + sommet2.nom + " de type " + sommet2.type + "."; 
        }else{
            s = "L'arête/Le trajet donné est introuvable."; 
        }
        return s; 
    }
    
        //F9_Pour un sommet donnée, lister les voisins directs d'un type donnée(noeuds à 1-distances);  
    //Methode privé pour rechercher plus facilement le type d'un sommet dont l'information est un nom appartenant à la class du Maillon Secondaire; 
    private String ChercherType(String nom){
        MaillonPrincipal sommet = this.premier;
        String s = ""; 
        while (sommet != null){
            if(sommet.nom.equals(nom)){
                s = sommet.type; 
            }
            sommet = sommet.suiv; 
        }
        return s;
    }
    //Méthode principale; 
    public String Lister_Sommet_1_Distance_Type(String nom, String type){
        MaillonPrincipal sommet = null; 
        sommet = ChercherSommetPrincipal(nom); 
        String s = ""; 
        int nb = 0; 
        if(sommet != null){
            MaillonGrapheSec tmp2 = sommet.voisin;
            while(tmp2 != null){
                if(ChercherType(tmp2.dest).equals(type)){
                    s = s + tmp2.dest + "-";
                    nb++;
                } 
                tmp2 = tmp2.suiv; 
            }
        }else{
            s = "Ce sommet n'existe pas."; 
        }
        if(nb == 0){
            s = "Le dispensaire ".concat(nom).concat(" n'a aucun voisin de type ").concat(type).concat(".");
        }else{
            s = "Les dispensaires voisins de type ".concat(type).concat(" du dispensaire ").concat(nom).concat( " sont : ").concat(s);
            s = s.replaceFirst("-$", "");
        }
        return s;
    }
    
    //F10__Pour 2 sommets donnés, lister les sommets voisins d'un type donné;  
        //Methode privé pour simplifier l'obtention de donnée; 
    private String Sommet_1_Distance(String nom, String type){
        MaillonPrincipal tmp = this.premier; 
        MaillonPrincipal sommet = null; 
        String str = ""; 
        if (type.equals("M") || type.equals("O") || type.equals("N")){
            sommet = ChercherSommetPrincipal(nom);  
            if(sommet != null){
                MaillonGrapheSec tmp2 = sommet.voisin; 
                while(tmp2 != null){
                    if(ChercherType(tmp2.dest).equals(type)){
                        str = str + tmp2.dest + " ";
                    }
                    tmp2 = tmp2.suiv; 
                }
            }else{
                str = "1"; 
            }
        }else{
            str = "1"; 
        }
        str = str.trim(); 
        return str; 
    }
    //Méthode principale;
    public String Lister_Sommet_Voisins_de_Deux_Sommet_Donnés_Selon_Type(String nomSommet1, String nomSommet2, String type){
        String ListeAdj1 = Sommet_1_Distance(nomSommet1, type); 
        String ListeAdj2 = Sommet_1_Distance(nomSommet2, type);
        int nb = 0; 
        String s = ""; 
        if(!ListeAdj1.equals("1") && !ListeAdj1.equals("1")){
            String [] successeur1 = ListeAdj1.split(" "); 
            String [] successeur2 = ListeAdj2.split(" "); 
            for(int i=0; i<successeur1.length; i++){
                for(int j=0; j<successeur2.length; j++){
                    if (successeur1[i].equals(successeur2[j])){
                        nb ++; 
                        s = s + successeur1[i] + " ";
                    }
                }
            }
            if(nb == 0){
                s = "Il n'existe aucun sommet qui à pour voisin " + nomSommet1 + " et "+ nomSommet2 + " et dont le type est " + type; 
            }else{
                s = nomSommet1 + " et " + nomSommet2 + " ont " + nb + " sommets en commun de type " + type + " : " + s; 
            }
        }else{
            s = "Le ou les sommets indiqués n'existent pas, ou le type indiqué est incorrect.";
        }
        return s; 
    }
    
    //F11_Étant donné 2 nœuds, dire s’ils sont à 2-distance ou pas;
        //Methode privé pour simplifier l'obtention de donnée; 
    public void Remplir(String[] sommet, LinkedList liste){
        for(int i=0; i<sommet.length; i++){
            liste.add(sommet[i]); 
        }
    }
        //Methode principal; 
    public String Savoir_Si_Sommet_2_Distance(String nom1, String nom2){
        //Utilise la fonction privé ChercherSommetPrincipal() pour trouver les deux sommets donnés; 
        MaillonPrincipal sommet1 = ChercherSommetPrincipal(nom1); 
        MaillonPrincipal sommet2 = ChercherSommetPrincipal(nom2); 
        String s = ""; 
        List<String> liste = new LinkedList<>(); 
        LinkedList<String> liste1 = new LinkedList<>();
        LinkedList<String> liste2 = new LinkedList<>();
        
        if(sommet1 != null && sommet2 != null){
            String [] sommet_voisin1 = Lister_Sommet_1_Distance(nom1).split("-"); 
            String [] sommet_voisin2 = Lister_Sommet_1_Distance(nom2).split("-"); 
            
            Remplir(sommet_voisin1, liste1); 
            Remplir(sommet_voisin2, liste2);
            
            for(int i = 0; i<sommet_voisin1.length; i++){
                for(int g = 0; g<sommet_voisin2.length; g++){
                    if(sommet_voisin1[i].equals(sommet_voisin2[g])){
                        liste.add(sommet_voisin1[i]);
                    }
                }
            }
            if(liste.size() != 0){
                for(int i = 0; i<liste.size(); i++){
                    s = s + liste.get(i) + "-"; 
                }
                s = s.replaceFirst("-$", "");
                if(!liste1.contains(nom2) && !liste2.contains(nom1)){
                    s = "Les sommets " + nom1 + " et " + nom2 + " sont à 2 de distance, ils sont reliés par l'intermédiare des sommets : " + s; 
                }else{
                    s = "Les sommets " + nom1 + " et " + nom2 + " sont voisins, mais ils sont aussi à 2 de distance par l'intermédiare des sommets : " + s; 
                }
            }else{
                s = "Les sommets " + nom1 + " et " + nom2 + " ne sont pas à 2 de distance."; 
            }   
        }else{
            s = "Le ou les dispensiares mentionnés sont introuvables."; 
        }
        if(nom1.equals(nom2)){
            s = "Le nom des sommets mentionnés sont les mêmes."; 
        }
        return s; 
    }
    
        //F12 Comparer 2 villes sur différents critères; 
    //Methode privée pour ajouter tout les sommets voisins à la liste; 
    private void Trouver_Sommet(String nom, LinkedList liste){
        MaillonPrincipal sommet = ChercherSommetPrincipal(nom); 
        MaillonGrapheSec arete = sommet.voisin; 
            while(arete != null){
                if(!liste.contains(arete.dest)){
                   liste.add(arete.dest); 
                } 
                arete = arete.suiv; 
            }
    }
    public String Comparer_2_Sommets(String nom1, String nom2){
        String s = ""; 
        MaillonPrincipal sommet1 = null; 
        MaillonPrincipal sommet2 = null; 
        sommet1 = ChercherSommetPrincipal(nom1); 
        sommet2 = ChercherSommetPrincipal(nom2); 
        //Une liste pour chaque sommet qui contiendra tous les sommets à 2 de distance; 
        LinkedList<String> liste1 = new LinkedList<String>(); 
        LinkedList<String> liste2 = new LinkedList<String>(); 
        //Compteur de dispensaire pur chaque sommet; 
        //nb1[0] = Compteur de Maternité; nb1[1] = Compteur de Nutrition; nb1[2] = Compteur de bloc opératoire; 
        int [] nb1 = new int[3]; 
        int [] nb2 = new int[3]; 
        
            //Traitement du sommet1; 
        String [] voisin1 = Lister_Sommet_1_Distance(nom1).split("-"); 
        for(String i : voisin1){
            Trouver_Sommet(i, liste1); 
        }
        //SUPPRIME LES VOISINS A <1_DISTANCE DU SOMMET1; 
        for(int i=0; i<voisin1.length; i++){
            if(liste1.contains(voisin1[i])){
                liste1.remove(voisin1[i]); 
            } 
        }
        
        liste1.remove(nom1); //Supprime le sommet analysé dans sa prorpe liste;
        for (String i : liste1){
            //Appelle la méthode ChercherType(ligne : 383; déja utiliser pour la méthode "Lister_Sommet_1_Distance_Type"; 
            if(ChercherType(i).equals("M")){
                nb1[0] = nb1[0]+1; 
            }else if(ChercherType(i).equals("N")){
                nb1[1] = nb1[1]+1; 
            }else{
                nb1[2] = nb1[2]+1; 
            }  
            s = s + i + " - "; 
        }
        s = s.replaceAll(" - $", ""); 
        s = "Les dispensaires à 2-distance de "+ nom1 + " sont : " + s; 
        s = s + '\n';
        s = s + "Le sommet " + nom1 + " possède " + nb1[0] + " Maternité, " + nb1[1] + " secteur de Nutrition, et "+ nb1[2] + " Bloc Opératoire à deux de distance."; 
        s = s + '\n'; 
        
            //Traitement du sommet2; 
        String [] voisin2 = Lister_Sommet_1_Distance(nom2).split("-");  
        for(String i : voisin2){
            Trouver_Sommet(i, liste2); 
        }
        //SUPPRIME LES VOISINS A <1_DISTANCE DU SOMMET2; 
        for(int i=0; i<voisin2.length; i++){
            if(liste2.contains(voisin2[i])){
                liste2.remove(voisin2[i]);
            }
        }
        String s2 = ""; 
        liste2.remove(nom2); //Supprime le sommet analysé dans sa prorpe liste;
        for(String i : liste2){
            if(ChercherType(i).equals("M")){
                nb2[0] = nb2[0]+1; 
            }else if(ChercherType(i).equals("N")){
                nb2[1] = nb2[1]+1; 
            }else{
                nb2[2] = nb2[2]+1; 
            }  
            s2 = s2 + i + " - "; 
        }
        s2 = s2.replaceAll(" - $", ""); 
        s = s + "Les dispensaires à 2-distance de "+ nom2 + " sont : " + s2; 
        s = s + '\n';
        s = s + "Le sommet " + nom2 + " possède " + nb2[0] + " Maternité, " + nb2[1] + " secteur de Nutrition, et "+ nb2[2] + " Bloc Opératoire à deux de distance."; 
        s = s + '\n'; 
            
            //COMPARATEUR; 
        //Comparateur de centre de Maternité; 
        if(nb1[0] > nb2[0]){
            s = s + "Le dispensaire qui a le plus de MATERNITE est : " + nom1; 
        }else if(nb1[0] < nb2[0]){
            s = s + "Le dispensaire qui a le plus de MATERNITE est : " + nom2; 
        }else{
            s = s + "Les dispensaires ont le même nombre de MATERNITE disponible."; 
        }
        s = s + '\n'; 
        //Comparateur de centre de Nutriton; 
        if(nb1[1] > nb2[1]){
            s = s + "Le dispensaire le plus NUTRITIF est : " + nom1; 
        }else if(nb1[1] < nb2[1]){
            s = s + "Le dispensaire qui a le plus de NUTRITIF est : " + nom2; 
        }else{
            s = s + "Les dispensaires ont le même nombre de centre de NUTRITION."; 
        }
        s = s + '\n'; 
        //Comparateur de Bloc d'opération; 
        if(nb1[2] > nb2[2]){
            s = s + "Le dispensaire le plus OPERATOIRE est : " + nom1; 
        }else if(nb1[2] < nb2[2]){
            s = s + "Le dispensaire le plus OPERATOIRE est : " + nom2;
        }else{
            s = s + "Les dispensaires ont le même nombre de BLOC OPERATOIRE à 2 de distance."; 
        }
        return s; 
    }
    
    //DIJISTRA; 
        //CHEMIN LE PLUS COURT EN DISTANCE ENTRE DEUX SOMMETS; 
    public String Chemin_LePlus_Court_Distance(String sommetDepart, String sommetArrivee) {
        HashMap<String, Double> distances = new HashMap<>();
        HashMap<String, String> predecesseurs = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        String resultat = ""; 
            //On commence par mettre toute les distance à l'infinie sauf celle du sommet de départ;  
        MaillonPrincipal courant = premier;
        while (courant != null) {
            if (courant.nom.equals(sommetDepart)) {
                distances.put(courant.nom, 0.0); //Sommet de départ; 
            } else {
                distances.put(courant.nom, Double.POSITIVE_INFINITY); //autre sommet; 
            }
            predecesseurs.put(courant.nom, null); //Ajout de tout les sommets avec leurs prédecesseurs null, 
            queue.add(courant.nom); //Stock tout les sommets croissants par rapport à leur distance (le sommet de départ sera donc le premier; 
            courant = courant.suiv;
        }

        // Boucle principale de l'algorithme pour traiter tout les sommets; 
        while (!queue.isEmpty()) {
            String sommetCourant = queue.poll(); //Extrait et supprime le sommet en tete de la liste pour ne plus le visité; 
            double distanceCourante = distances.get(sommetCourant);

            if (sommetCourant.equals(sommetArrivee)) {
                break; //Sort de la boucle le sommet d'arrivée est visité; 
            }

            //Parcour les sommets voisins du sommets courant; 
            MaillonPrincipal sommet = ChercherSommetPrincipal(sommetCourant);
            MaillonGrapheSec voisinCourant = sommet.voisin;
            while (voisinCourant != null) {
                double distanceVoisin = distanceCourante + voisinCourant.distance; //Ajoute la distance initiale à celle du sommet visité; 
                if (distanceVoisin < distances.get(voisinCourant.dest)) {       //Si cette distance est inférieur; 
                   distances.put(voisinCourant.dest, distanceVoisin);       //Ajoute la distance la plus basse et avec le nom du sommet pour etre comparé avec les suivants dans la boucle; 
                    predecesseurs.put(voisinCourant.dest, sommetCourant);   //Ajoute le sommet avec la plus basse distance et son prédécesseurs pour avoir un suivit sur le chemin à emprunté; 
                    // Mise à jour de la priorité du voisin dans la PriorityQueue
                    queue.remove(voisinCourant.dest); //Supprime le Voisin Courant et sa distance; 
                    queue.add(voisinCourant.dest);    //Ajoute le Voisin Courant et sa nouvelle distance pour mettre à jour la priorité, ce sommet sera donc le suivant à etre traité; 
                }
                voisinCourant = voisinCourant.suiv;     //Passage au sommet voisin suivante; 
            }
        }
        //Chemin le plus fiable dans une liste à partir de la liset prédécesseurs; 
        List<String> chemin = new ArrayList<>();
        String sommet = sommetArrivee;
        while (sommet != null) {
            chemin.add(0, sommet);
            sommet = predecesseurs.get(sommet);
        }
        //Chemin le plus fiable dans un String à partir de la liset chemin; 
        for(int i=0; i<chemin.size(); i++){
            if(i == chemin.size()-1){
                resultat = resultat.concat(chemin.get(i));
            }else{
                resultat = resultat.concat(chemin.get(i).concat(" --> "));
            }
        }
        return resultat;
    }
    
        //CHEMIN LE PLUS COURT EN DUREE ENTRE DEUX SOMMETS; 
    public String Chemin_LePlus_Court_Duree(String sommetDepart, String sommetArrivee) {
        HashMap<String, Double> duree = new HashMap<>();
        HashMap<String, String> predecesseurs = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(duree::get));
        String resultat = ""; 
            //On commence par mettre toute les distance à l'infinie sauf celle du sommet de départ;  
        MaillonPrincipal courant = premier;
        while (courant != null) {
            if (courant.nom.equals(sommetDepart)) {
                duree.put(courant.nom, 0.0);
            } else {
                duree.put(courant.nom, Double.POSITIVE_INFINITY);
            }
            predecesseurs.put(courant.nom, null);
            queue.add(courant.nom);
            courant = courant.suiv;
        }

        while (!queue.isEmpty()) {
            String sommetCourant = queue.poll();
            double dureeCourante = duree.get(sommetCourant);

            if (sommetCourant.equals(sommetArrivee)) {
                break;
            }

            MaillonPrincipal sommet = ChercherSommetPrincipal(sommetCourant);
            MaillonGrapheSec voisinCourant = sommet.voisin;
            while (voisinCourant != null) {
                double distanceVoisin = dureeCourante + voisinCourant.duree;
                if (distanceVoisin < duree.get(voisinCourant.dest)) {
                    duree.put(voisinCourant.dest, distanceVoisin);
                    predecesseurs.put(voisinCourant.dest, sommetCourant);
                    queue.remove(voisinCourant.dest);   //Mise à jour de la file d'attente; 
                    queue.add(voisinCourant.dest);
                }
                voisinCourant = voisinCourant.suiv;
            }
        }
        List<String> chemin = new ArrayList<>();
        String sommet = sommetArrivee;
        while (sommet != null) {
            chemin.add(0, sommet);
            sommet = predecesseurs.get(sommet);
        }
        //Chemin le plus fiable dans un String à partir de la liset chemin;
        for(int i=0; i<chemin.size(); i++){
            if(i == chemin.size()-1){
                resultat = resultat.concat(chemin.get(i));
            }else{
                resultat = resultat.concat(chemin.get(i).concat(" --> "));
            }
        }
        return resultat;
    }
        //CHEMIN LE PLUS FIABLE EN DUREE ENTRE DEUX SOMMETS; 
    public String Chemin_LePlus_Fiable(String sommetDepart, String sommetArrivee) {
        HashMap<String, Double> fiable = new HashMap<>();
        HashMap<String, String> predecesseurs = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>(Comparator.comparingDouble(fiable::get).reversed());
        String resultat = ""; 
        //On commence par mettre toute les fiabilité à 0 sauf celle du sommet de départ où elle sera à 100%;  
        MaillonPrincipal courant = premier;
        while (courant != null) {
            if (courant.nom.equals(sommetDepart)) {
                fiable.put(courant.nom, 10.0);
            } else {
                fiable.put(courant.nom, 0.0);
            }
            predecesseurs.put(courant.nom, null);
            queue.add(courant.nom);
            courant = courant.suiv;
        }

        while (!queue.isEmpty()) {
            String sommetCourant = queue.poll();
            double fiableCourante = fiable.get(sommetCourant);

            if (sommetCourant.equals(sommetArrivee)) {
                break;
            }

            MaillonPrincipal sommet = ChercherSommetPrincipal(sommetCourant);
            MaillonGrapheSec voisinCourant = sommet.voisin;
            while (voisinCourant != null) {
                double fiableVoisin = fiableCourante * voisinCourant.fiabilite/10;
                if (fiableVoisin > fiable.get(voisinCourant.dest)) {
                    fiable.put(voisinCourant.dest, fiableVoisin);
                    predecesseurs.put(voisinCourant.dest, sommetCourant);
                    queue.remove(voisinCourant.dest);
                    queue.add(voisinCourant.dest);
                }
                voisinCourant = voisinCourant.suiv;
            }
        }
        List<String> chemin = new ArrayList<>();
        String sommet = sommetArrivee;
        while (sommet != null) {
            chemin.add(0, sommet);
            sommet = predecesseurs.get(sommet);
        }
        //Chemin le plus fiable dans un String à partir de la liset chemin;
        for(int i=0; i<chemin.size(); i++){
            if(i == chemin.size()-1){
                resultat = resultat.concat(chemin.get(i));
            }else{
                resultat = resultat.concat(chemin.get(i).concat(" --> "));
            }
        }
        return resultat;
    }
    
        //CHEMIN LE PLUS FIABLE EN DUREE ENTRE DEUX SOMMETS; 
    public String Complexite(String sommetDepart, String sommetArrivee) {
        int V = 0; //Nombre de Sommet; 
        int E = 0; //Nombre d'Arete; 
        MaillonPrincipal sommet = this.premier; 
        while (sommet != null){
            MaillonGrapheSec voisin = sommet.voisin; 
            while(voisin != null){
                E ++; 
                voisin = voisin.suiv; 
            }
            V++; 
            sommet = sommet.suiv; 
        }
        E = E/2; 
        int complexite = E + V; 
        return "Complexité : O((" + complexite + ") log " + V + ")"; 
    }
}

/*
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
==========================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================
*/
