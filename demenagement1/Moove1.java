package demenagement1;

public class Moove1 {
    int ancienbat=34; //<>//
    int newbat=0;
    int camion=0;
    int placecamion=9;
    int poids1kg=0;
    int poids1a3kg=0;
    int poids3a5kg=0;
    int poids5kg=0;
    int i=0;
    int n=0;
    int ghost;
    int[] piecevide ={0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] colisparpiece ={3, 4, 2, 1, 3, 2, 5, 2, 2, 1, 1, 3, 3, 3, 4};
  double [] tableaucarton=new double[34];

    void remplissage() {
        while (placecamion != camion && ancienbat > 0) {
            camion++;
            ancienbat--;
        }
    }

    void vidage() {
        while (camion > 0) {
            camion--;
            newbat++;
            pesepoids();
            colisreparti();
        }
    }

    void deplacementcamion() {
        while (ancienbat > 0) {
            remplissage();
            vidage();
        }
    }

//void colisreparti() {
//  //la piecvide est pleine je passe a suivante
//  if (piecevide [i] != colisparpiece [i]) {
//    piecevide [i]++;
//  } else {
//    i++;
//    piecevide [i]++;
//  }
//}

//void remplirtableau(){
//  poids = tableaucarton [n] ;
//  n++;

//}

    void tribulles() {
      double ghostt;
        boolean estPermute = true;

        while(estPermute){
            estPermute=false;

            for (int n=0; n<33; n++){
                if(tableaucarton[n] > tableaucarton[n+1]) {
                    ghostt = tableaucarton [n];
                    tableaucarton[n]= tableaucarton[n+1];
                    tableaucarton[n+1] = ghostt;
                    estPermute= true;
                }
            }


        }
    }



    void colisreparti()
    {
        while (piecevide [i] == colisparpiece [i]) {
            i++;
        }
        piecevide [i]++;
        i++;
        if  (i==15) {
            i=0;
        }
    }

    void pesepoids() {
      double poids=Math.random()* 8 ;
        if (poids<1) {
            poids1kg++;
        } else if (poids>1 && poids<3) {
            poids1a3kg++;
        } else if (poids>3 && poids<5) {
            poids3a5kg++;
        } else {
            poids5kg++;
        }
        tableaucarton [n] = poids ;
        n++;
    }
    void transfert() {
        ghost=piecevide [5];
        piecevide [5]=piecevide [10];
        piecevide [10]=ghost;
    }

    void setup() {
        deplacementcamion();
        transfert();
        tribulles();
        System.out.println("ancienbat:"+ ancienbat+
                "newbat:"+ newbat+
                "poids1:"+ poids1kg+
                "poids2:"+ poids1a3kg+
                "poids3:"+ poids3a5kg+
                "poids4:"+ poids5kg+
                " variable i"+ i );

        for  (i=0; i<=14; i++ ) {
            System.out.print(piecevide[i]);
        }
       ;
        for  (i=0; i<=33; i++ ) {
            System.out.println(tableaucarton[i]);
        }
    }
}
