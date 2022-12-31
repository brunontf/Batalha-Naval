package model;

public class Ships {
    private Object portaAvioes; // 5 espaços 1x
    private Object navioTanque; // 4 espaços 2x
    private Object contraTorpedeiro;// 3 espaços 3x
    private Object submarino;// 2 espaços 4x
    private Object lancha = 5; // 1 espaço 5x

    public Ships(Object lancha) {
        this.lancha = lancha;
    }

    public Ships() {
    }

    public Object getLancha() {
        return lancha;
    }


}
