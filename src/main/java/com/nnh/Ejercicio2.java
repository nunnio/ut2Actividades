package com.nnh;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        int sel;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Introduce la acción que desee: " +
                    "1- Insertar tabla" +
                    "2- Modificar tabla" +
                    "3- Borrar tabla" +
                    "0- Salir");
            sel = sc.nextInt();
            switch (sel){
                case 1: insertar(); break;
                case 2: modificar(); break;
                case 3: borrar(); break;
                default:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
            }
        }
    }
}
