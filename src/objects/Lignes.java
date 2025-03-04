package objects;
public class Lignes {
    int numLignes;
    int EAN ;
    String description ;
    int Quantite ;
    int prixUnitaire ;
    int montantTotale;
    int Tva ;




    public Lignes(int numLignes, int eAN, String description, int quantite, int prixUnitaire, int montantTotale,
            int tva) {
        this.numLignes = numLignes;
        EAN = eAN;
        this.description = description;
        Quantite = quantite;
        this.prixUnitaire = prixUnitaire;
        this.montantTotale = montantTotale;
        Tva = tva;
    }




    @Override
    public String toString() {
        return "Lignes [numLignes=" + numLignes + ", EAN=" + EAN + ", description=" + description + ", Quantite="
                + Quantite + ", prixUnitaire=" + prixUnitaire + ", montantTotale=" + montantTotale + ", Tva=" + Tva
                + "]";
    }




    public int getNumLignes() {
        return numLignes;
    }


    public int getEAN() {
        return EAN;
    }



    public String getDescription() {
        return description;
    }


    public int getQuantite() {
        return Quantite;
    }


    public int getPrixUnitaire() {
        return prixUnitaire;
    }


    public int getMontantTotale() {
        return montantTotale;
    }




    public int getTva() {
        return Tva;
    }


    





    
    
}