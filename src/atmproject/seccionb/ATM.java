/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package atmproject.seccionb;

/**
 *
 * @author miguelcatalan
 */
public class ATM {

    private RanuraParaDepositos ranuraParaDepositosObj;
    private TecladoNumerico tecladoNumericoObj;
    private Pantalla pantallaObj;
    private Dispensador dispensadorObj;
    private Transaccion retiroObj;
    private Transaccion depositoObj;
    //Elementos del flujo de programa
    private Cuenta cuentaEnCurso;

    //Implementación de relacion de agregación entre la clase TecladoNumerico y ATM
    public ATM() {
        //Elementos del ATM
        this.ranuraParaDepositosObj = new RanuraParaDepositos();
        this.tecladoNumericoObj = new TecladoNumerico();
        this.pantallaObj = new Pantalla();
        this.dispensadorObj = new Dispensador();
        this.retiroObj = new Retiro();
        this.depositoObj = new Deposito();

        //Elementos del flujo de programa
        this.cuentaEnCurso = new Cuenta();
        
        
        //Al no utilizar base de datos se inicializa la cuenta con un saldo de Q.1,000
        //Para realizar las operaciones del programa.
        this.cuentaEnCurso.setSaldo(1000);

        //Inicia el proceso del atm
        this.solicitarDatos();
        
        pantallaObj.mostrarMensaje("\nBienvenido al sistema ATM!");
    }

    private void solicitarDatos() {
        pantallaObj.mostrarMensaje("\nIngrese su numero de cuenta: ");
        int numeroCuenta = tecladoNumericoObj.capturarDatos();
        if (cuentaEnCurso.setNumeroDeCuenta(numeroCuenta)) {
            pantallaObj.mostrarMensaje("\nIngrese el nip de la cuenta: ");
            int nipCuenta = tecladoNumericoObj.capturarDatos();
            if (cuentaEnCurso.setNip(nipCuenta)) {
                pantallaObj.mostrarMensaje("\nBienvenido Usuario, seleccione una operacion a realizar.");
                this.mostrarMenuOpciones();
            } else {
                pantallaObj.mostrarMensaje("\nEl nip ingresado no es valido, intente nuevamente.");
                pantallaObj.mostrarMensaje("\n*************************************************");
                pantallaObj.mostrarMensaje("\n");
                this.solicitarDatos();
            }
        } else {
            pantallaObj.mostrarMensaje("\nEl numero de cuenta ingresado no es valido, intente nuevamente.");
            this.solicitarDatos();
            pantallaObj.mostrarMensaje("\n*************************************************");
            pantallaObj.mostrarMensaje("\n");
        }
    }

    private void mostrarMenuOpciones() {
        int opcion = 0;
        while (opcion != 4) {
            pantallaObj.mostrarMensaje("\n---- Menú de opciones ----");
            pantallaObj.mostrarMensaje("\n1. Solicitud de saldo");
            pantallaObj.mostrarMensaje("\n2. Retiro de efectivo");
            pantallaObj.mostrarMensaje("\n3. Deposito de efectivo");
            pantallaObj.mostrarMensaje("\n4. Salir");
            pantallaObj.mostrarMensaje("\nIngrese una opción: ");
            opcion = tecladoNumericoObj.capturarDatos();
            switch (opcion) {
                case 1:
                    pantallaObj.mostrarMensaje("\n----------Solicitud de saldo----------");
                    pantallaObj.mostrarMensaje("\nEl saldo disponible es: " + this.cuentaEnCurso.getSaldo());
                    pantallaObj.mostrarMensaje("\nEl saldo flotante es: " + this.cuentaEnCurso.getSaldoFlotante());
                    break;
                case 2:
                    pantallaObj.mostrarMensaje("\nRetiro de efectivo");
                    mostrarOpcionesRetiro();
                    break;
                case 3:
                    pantallaObj.mostrarMensaje("\nDeposito de efectivo");
                    mostrarOpcionesDeposito();
                    break;
                case 4:
                    pantallaObj.mostrarMensaje("\nGracias por utilizar los sistemas de cajero ATM, adiós!");
                    System.exit(0);
                    break;
                default:
                    pantallaObj.mostrarMensaje("\nOpción inválida. Intente de nuevo.");
                    pantallaObj.mostrarMensaje("\n**********************************");
                    pantallaObj.mostrarMensaje("\n");
                    break;
            }
        }
    }

    private void mostrarOpcionesRetiro() {
        int opcion = 0;
        while (opcion != 6) {
            pantallaObj.mostrarMensaje("\n---- Menú de retiro ----");
            pantallaObj.mostrarMensaje("\n1. Q.20");
            pantallaObj.mostrarMensaje("\n2. Q.40");
            pantallaObj.mostrarMensaje("\n3. Q.60");
            pantallaObj.mostrarMensaje("\n4. Q.100");
            pantallaObj.mostrarMensaje("\n5. Q.200");
            pantallaObj.mostrarMensaje("\n6. Cancelar transaccion.");
            pantallaObj.mostrarMensaje("\nElija un monto de retiro: ");
            opcion = tecladoNumericoObj.capturarDatos();
            switch (opcion) {
                case 1:
                    pantallaObj.mostrarMensaje("\nPor favor espere...");
                    this.retirarEfectivo(20);
                    break;
                case 2:
                    pantallaObj.mostrarMensaje("\nPor favor espere...");
                    this.retirarEfectivo(40);
                    break;
                case 3:
                    pantallaObj.mostrarMensaje("\nPor favor espere...");
                    this.retirarEfectivo(60);
                    break;
                case 4:
                    pantallaObj.mostrarMensaje("\nPor favor espere...");
                    this.retirarEfectivo(100);
                    break;
                case 5:
                    pantallaObj.mostrarMensaje("\nPor favor espere...");
                    this.retirarEfectivo(200);
                    break;
                case 6:
                    pantallaObj.mostrarMensaje("\nCancelando...");
                    this.mostrarMenuOpciones();
                    break;
                default:
                    pantallaObj.mostrarMensaje("\nOpción inválida. Intente de nuevo.");
                    pantallaObj.mostrarMensaje("\n **********************************");
                    pantallaObj.mostrarMensaje("\n");
                    break;
            }
        }
    }
    
    private void mostrarOpcionesDeposito() {
        int montoDeposito = 0;
        
        pantallaObj.mostrarMensaje("\nIngrese el sobre con la cantidad que desea depositar y el monto de la cantidad depositada (debe realizar este proceso en los proximos dos minutos).");
        pantallaObj.mostrarMensaje("\nMonto depositado:");
        montoDeposito = tecladoNumericoObj.capturarDatos();
        this.depositarEfectivo(montoDeposito);
        this.mostrarMenuOpciones();
    }

    private void retirarEfectivo(int monto) {
        if(this.retiroObj.ejecutar(monto, cuentaEnCurso)){
            pantallaObj.mostrarMensaje("\nTransaccion realizada correctamente.");
            this.mostrarMenuOpciones();
        }else{
            pantallaObj.mostrarMensaje("\nLa cuenta no cuenta con los fondos suficientes, ingrese un monto menor.");
            this.mostrarOpcionesRetiro();
        }
    }
    
    private void depositarEfectivo(int monto) {
        this.depositoObj.ejecutar(monto, this.cuentaEnCurso);
        pantallaObj.mostrarMensaje("\nTransaccion realizada correctamente.");
        pantallaObj.mostrarMensaje("\nEl banco debe validar la cantidad depositada antes de abonarlo al saldo disponible.");
    }
}
