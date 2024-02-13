package lala;

import java.util.Scanner;
public class Supuesto2 {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int numero;
        int numeroDecimal;
        do{
            System.out.println("0 = Salir");
            System.out.println("1 = Convertir decimal a binario");
            numero = menu();
            if(numero == 1){
                System.out.println("Introduce el valor del número que deseas convertir a decimal (0 a 255)");
                numeroDecimal = pedirPositivo();
                conseguirBinario(numeroDecimal);
            }
            else{
                System.out.println("Adiós");
            }

        } while(numero != 0);
    }
    //Método para conseguir números enteros positivos
    public static int pedirPositivo(){
        int num;
        do{
            num = pedirInt();
            if(num < 0 || num > 255){
                System.out.println("Introduce un número mayor que 0 y menor que 255: ");
            }

        } while(num < 0 || num > 255);
        return num;
    }
    //Método para establecer el dominio del menú
    public static int menu(){
        int num;
        do{
            num = pedirInt();
            if(num > 1 || num < 0){
                System.out.println("Introduce un número entre 0 y 1 por favor");
            }

        } while(num > 1 || num < 0);
        return num;
    }

    //Método para asegurar que se introduce un número válido
    public static int pedirInt(){
        boolean aceptado = false;
        int num = 0;
        do{
            try{
                num = sc.nextInt();
                aceptado = true;
            } catch(Exception e){
                sc.nextLine();
                System.out.println("Valor introducido no válido");
            }
        } while(aceptado != true);
        return num;
    }
    //Método para transformar un número decimal a binario
    //Es void porque voy a recorrer el array y mostrarlo con un print
    public static void conseguirBinario(int numeroDecimal){
        int[] valores = new int[8];
        int contador = 0;
        int valor; //Almacenamos los valores del número binario
        while(contador <= 7 && numeroDecimal % 2 != 1 || numeroDecimal % 2 != 0){
            valor = numeroDecimal % 2;
            numeroDecimal = numeroDecimal/2;
            valores[contador] = valor;
            contador += 1;
        }
        
        //Finalmentre recorremos el array de forma inversa para mostrar el número binario
        System.out.println("NUMERO BINARIO");
        for(int i = valores.length - 1; i >= 0; i--){
            System.out.print(valores[i]);
        }
        System.out.println("");
    }
}
