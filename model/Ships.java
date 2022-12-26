package model;

public class Ships {
    Object portaAvioes; // 5 espaços 1x
    Object navioTanque; // 4 espaços 2x
    Object contraTorpedeiro;// 3 espaços 3x
    Object submarino;// 2 espaços 4x
    Object lancha; // 1 espaço 5x

    Ships(Object lancha){
        this.lancha=lancha;
    }
    Ships(){}
    
    public Object getLancha() {
        return lancha;
    }

    

}
