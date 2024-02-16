                                                                                                                                                                                                                                                                                                                                                                                                                                                            import java.util.Random; 

public class TestGraphe {
    
    public static void main(String[] args){
        Ecran_Accueil ecran = new Ecran_Accueil(); 
        ecran.setVisible(true);
          
        LCGraphe graphe = new LCGraphe(); 
        for(int i=0; i<30; i++){
            String str = "S"; 
            int j = i+1; 
            str = "S"+j; 
            graphe.ajoutMaillonP(str, "M");
        }
        String [] sommet = graphe.getNomSommet().split(";");
        String [] sommet2 = graphe.getNomSommet().split(";");
        int arete = 1; 
        for(int i=0; i<sommet.length;i++){
            Random random = new Random(); 
            int nb = 1+ (random.nextInt(5));
            for(int j=0; j<nb; j++){
                double fiab = 1 + (random.nextDouble() *10); 
                double distance = 1 + (random.nextDouble() *49);  
                double durée = 1 + (random.nextDouble() *49); 
                fiab = Math.round(fiab *10)/10; 
                distance = Math.round(distance *10)/10; 
                durée = Math.round(durée *10)/10; 
                
                int indice_sommet2 = 1 + (random.nextInt(28));
                
                if(!graphe.Savoir_Si_2Sommets_Relié(sommet[0], sommet2[indice_sommet2]) && !sommet[i].equals(sommet2[indice_sommet2])){
                    String nom_arete = "A"+arete; 
                    graphe.ajoutMaillonSec(sommet[i],sommet2[indice_sommet2], fiab, distance, durée, nom_arete);
                    arete ++; 
                }else{
                    j--;
                }
            }
        }
        
        PanneauDessin p = new PanneauDessin(graphe); 
        System.out.println(graphe); 
        System.out.println(" "); 
        System.out.println(" "); 
        for(int i=0; i<sommet.length; i++){
            System.out.println(sommet[i] + ";" + graphe.getNomVoisin(sommet[i]).replace("S", "")); 
        }
        System.out.println(" "); 
        System.out.println(" "); 
        System.out.println(graphe.getCara());
        System.out.println(" "); 
        System.out.println(" "); 
        
        
        LCGraphe g = new LCGraphe(); 
        
       
        System.out.println(g.dijkstra("S1", "S5")); 
        
    }    
    
}
