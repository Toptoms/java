package demenagement;

public class Moove {
    int ancienbat=34;
    int newbat=0;
    int camion=0;
    int placecamion=9;

    void remplissage(){
        while(placecamion != camion && ancienbat > 0){
            camion = camion + 1;
            ancienbat = ancienbat - 1;
        }
    }

    void vidage(){
        while(camion > 0){
            camion = camion -1;
            newbat= newbat +1;
        }
    }

    void deplacementcamion(){
        while(ancienbat > 0){
            remplissage();
            vidage();
        }
    }

    void setup(){
        deplacementcamion();
        System.out.println(newbat);
    }
}

