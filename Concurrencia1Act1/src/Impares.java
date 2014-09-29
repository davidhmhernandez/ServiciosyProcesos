
public class Impares extends Thread {
	int acumulador=0;
    @Override
    public void run() {
        for(int i=0;i<=1000;i++){
            if(i%2!=0){
                acumulador+=i;
            }
        }System.out.println(acumulador);
    }
}
