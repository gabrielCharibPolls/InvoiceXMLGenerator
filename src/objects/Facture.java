package objects;

import java.time.LocalDate;
 public class Facture {

    int numFcture ;
    Pays  Pays;
    Adress adressDestination ;
    Adress adressVendeure;
    Adress adressActeur ;
    LocalDate dateDocument ;
    LocalDate dateComamnde ;
    Lignes [] tabLignes ;

    
    public Facture(int numFcture, objects.Pays pays, Adress adressDestination, Adress adressVendeure,
            Adress adressActeur, LocalDate dateDocument, LocalDate dateComamnde, Lignes[] tabLignes) {
        this.numFcture = numFcture;
        Pays = pays;
        this.adressDestination = adressDestination;
        this.adressVendeure = adressVendeure;
        this.adressActeur = adressActeur;
        this.dateDocument = dateDocument;
        this.dateComamnde = dateComamnde;
        this.tabLignes = tabLignes;
    }
    public void setNumFcture(int numFcture) {
        this.numFcture = numFcture;
    }
    public void setPays(Pays pays) {
        Pays = pays;
    }
    public void setAdressDestination(Adress adressDestination) {
        this.adressDestination = adressDestination;
    }
    public void setAdressVendeure(Adress adressVendeure) {
        this.adressVendeure = adressVendeure;
    }
    public void setAdressActeur(Adress adressActeur) {
        this.adressActeur = adressActeur;
    }
    public void setDateDocument(LocalDate dateDocument) {
        this.dateDocument = dateDocument;
    }
    public void setDateComamnde(LocalDate dateComamnde) {
        this.dateComamnde = dateComamnde;
    }
    public void setTabLignes(Lignes[] tabLignes) {
        this.tabLignes = tabLignes;
    }





    
    
}