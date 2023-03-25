/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject.seccionb;

import java.util.Scanner;

/**
 *
 * @author miguelcatalan
 */
public class TecladoNumerico {
    
    private Scanner scan;
    
    public TecladoNumerico(){
        this.scan = new Scanner(System.in);
    }
    
    public int capturarDatos() { 
        int datoIngresado = scan.nextInt();
        return datoIngresado;
    }
}
