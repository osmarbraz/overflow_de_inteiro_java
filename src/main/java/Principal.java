
public class Principal {

    public static void main(String[] args) {                
        System.out.println("OVERFLOW DO TIPO SHORT");        
        short numeroShort = Short.MAX_VALUE;
        System.out.println("Maior short=" + numeroShort); //32767
        numeroShort = (short) (numeroShort + 1);
        System.out.println("short + 1=" + numeroShort);
        System.out.println("---------------------------");
        numeroShort = Short.MIN_VALUE;
        System.out.println("Menor short=" + numeroShort); //-32768
        numeroShort = (short) (numeroShort - 1);
        System.out.println("short - 1=" + numeroShort);

        System.out.println("\nOVERFLOW DO TIPO INT");
        int numeroInt = Integer.MAX_VALUE;
        System.out.println("Maior int=" + numeroInt); //2147483647
        numeroInt = numeroInt + 1;
        System.out.println("int + 1=" + numeroInt);
        System.out.println("---------------------------");
        numeroInt = Integer.MIN_VALUE;
        System.out.println("Menor int=" + numeroInt); //-2147483648
        numeroInt = numeroInt - 1;
        System.out.println("int - 1=" + numeroInt);

        System.out.println("\nOVERFLOW DO TIPO LONG");
        long numeroLong = Long.MAX_VALUE;
        System.out.println("Maior long=" + numeroLong);//9223372036854775807
        numeroLong = numeroLong + 1;
        System.out.println("long + 1=" + numeroLong);
        System.out.println("---------------------------");
        numeroLong = Long.MIN_VALUE;
        System.out.println("Menor long=" + numeroLong);//-9223372036854775808
        numeroLong = numeroLong - 1;
        System.out.println("long - 1=" + numeroLong);
    }
}
