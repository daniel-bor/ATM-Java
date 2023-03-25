/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject.seccionb;

/**
 *
 * @author miguelcatalan
 */
public class Cuenta {
    private float saldo;
    private float saldoFlotante;
    private int numeroDeCuenta;
    private int nip;
    
    private boolean validarRetiro(float monto){
        if(monto <= this.saldo){
            return true;
        }else{
            return false;
        }
    }
    
    
    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public float getSaldoFlotante() {
        return saldoFlotante;
    }

    public void setSaldoFlotante(float saldoFlotante) {
        this.saldoFlotante = saldoFlotante;
    }

    public int getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public boolean setNumeroDeCuenta(int numeroDeCuenta) {
        if (numeroDeCuenta > 9999 && numeroDeCuenta < 100000) {
            this.numeroDeCuenta = numeroDeCuenta;
            return true;
        }
        else {
            return false;
        }
    }

    public int getNip() {
        return nip;
    }

    public boolean setNip(int nip) {
        if (nip > 9999 && nip < 100000) {
            this.nip = nip;
            return true;
        }
        else {
           return false;
        }
    }
    
    public void acreditar(float monto) {
        this.saldoFlotante += monto;
    }
    
    public boolean debitar(float monto) {
        if(this.validarRetiro(monto)){
            this.saldo -= monto;
            return true;
        }else{
            return false;
        }
    }
}

