/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject.seccionb;

/**
 *
 * @author miguelcatalan
 */
public class Retiro extends Transaccion {
    /*
    private int monto;
    */
    public boolean ejecutar(int monto, Cuenta cuentaEnCurso) { 
        if(cuentaEnCurso.debitar(monto)){
            return true;
        }else{
            return false;
        }
    } 
}
