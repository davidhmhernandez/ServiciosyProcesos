
public class Otros extends Thread {
	int acumulador=0;
    @Override
    public void run() {
        for(int i=0;i<=1000;i++){
            if(i%10==2 || i%10==3){
                acumulador+=i;
            }
        }System.out.println(acumulador);
    }
}
