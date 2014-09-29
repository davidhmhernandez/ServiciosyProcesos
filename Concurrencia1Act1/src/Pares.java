
public class Pares extends Thread {

    @Override
    public void run() {
        int acumulador=0;
        for(int i=0;i<1000;i++){
            if(i%2==0){
                acumulador+=i;
            }
        }System.out.println(acumulador);
    }
}
