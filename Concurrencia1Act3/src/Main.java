
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		jugarOtraVez();
        while (jugarOtraVez() == true) {
            Dado1 t1 = new Dado1();
            Dado2 t2 = new Dado2();
            t1.start();
            t2.start();
            System.out.println("Dado 1: "+t1.valorDado1);
            System.out.println("Dado 2: "+t2.valorDado2);
            if(t1.valorDado1<t2.valorDado2){
               System.out.println("Gana el Dado 2."); 
            }else if(t1.valorDado1>t2.valorDado2){
               System.out.println("Gana el Dado 1."); 
            } else System.out.println("Empate.");
        }


	}
	 public static boolean jugarOtraVez() {
	        char jov = Consola.leerChar("¿Desea Jugar? S/N");
	        if (jov == 's' || jov == 'S') {
	            return true;
	        }
	        return false;
	    }


}
