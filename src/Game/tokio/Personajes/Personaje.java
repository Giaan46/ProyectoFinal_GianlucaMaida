package Game.tokio.Personajes;




public abstract class Personaje {

    private String nombre;
    private int puntosVida;
    private int resistenciaArmadura;

    public Personaje() {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.resistenciaArmadura = resistenciaArmadura;
    }
    public Personaje(String nombre, int puntosVida,int resistenciaArmadura){
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.resistenciaArmadura = resistenciaArmadura;
    }
    public String getNombre() {
        return nombre;
    }


    public  int getVida() {
        if(puntosVida < 0){
            return 0;
        }
        return puntosVida;
    }

    public void setVida(int vida) {
        this.puntosVida = vida;
    }

    public int getResistenciaArmadura() {
        return resistenciaArmadura;
    }


    public abstract int atacar (Personaje enemigo);

    public  int recibirAtaque(int ataque,Personaje enemigo){
           if(ataque >= resistenciaArmadura){
          return ataque - resistenciaArmadura;

       }else if (ataque < resistenciaArmadura){
           return 0;
       }else if(puntosVida == 0){
           return 0;
       }
       return ataque - resistenciaArmadura;
    }
    public abstract String mensaje();

        @Override
        public String toString () {
            return getNombre() + "( Vida= " + getVida() + " Armadura =" + getResistenciaArmadura() + ")";
        }



}

