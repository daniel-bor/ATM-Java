/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject.seccionb;

/**
 *
 * @author miguelcatalan
 */
public class Deposito extends Transaccion {

    /*
    private int monto;
     */
    public boolean ejecutar(int monto, Cuenta cuentaEnCurso) { 
        float montoFloat = monto/100;
        cuentaEnCurso.acreditar(montoFloat);
        return true;
    } 
}
