package cuenta;

// Clase que representa una Cuenta Bancaria
public class Cuenta {
    private final String titular; // Nombre del titular de la cuenta
    private double saldo; // Saldo actual de la cuenta
    private static final double COMISION_MENSUAL = 0.15; // 15% de comisión mensual
    private final double ingresosMensuales; // Ingresos mensuales del titular

    // Constructor para inicializar una nueva cuenta bancaria
    public Cuenta(String titular, double saldoInicial, double ingresosMensuales) {
        this.titular = titular; // Asigna el nombre del titular
        this.saldo = saldoInicial; // Define el saldo inicial
        this.ingresosMensuales = ingresosMensuales; // Define los ingresos mensuales
    }

    // Método para consultar el saldo de la cuenta
    public double consultarSaldo() {
        return saldo; // Retorna el saldo actual
    }

    // Método para consignar dinero en la cuenta
    public void consignar(double monto) {
        if (monto > 0) { // Verifica que el monto sea positivo
            saldo += monto; // Incrementa el saldo con el monto consignado
            System.out.println("Consignacion exitosa. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("El monto debe ser mayor a 0."); // Mensaje de error si el monto no es válido
        }
    }

    // Método para retirar dinero de la cuenta
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) { // Verifica que el monto sea válido y menor o igual al saldo
            saldo -= monto; // Deduce el monto del saldo
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido."); // Mensaje de error
        }
    }

    // Método para transferir dinero a otra cuenta
    public void transferir(double monto, Cuenta cuentaDestino) {
        if (monto > 0 && monto <= saldo) { // Verifica que el monto sea válido y menor o igual al saldo
            saldo -= monto; // Deduce el monto del saldo del emisor
            cuentaDestino.consignar(monto); // Consigna el monto en la cuenta destino
            System.out.println("Transferencia exitosa. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Fondos insuficientes o monto inválido."); // Mensaje de error
        }
    }

    // Método para aplicar la comisión mensual basada en los ingresos
    public void aplicarComision() {
        double comision = ingresosMensuales * COMISION_MENSUAL; // Calcula el 15% de comisión sobre los ingresos
        if (saldo >= comision) { // Verifica que haya saldo suficiente para la comisión
            saldo -= comision; // Deduce la comisión del saldo
            System.out.println("Se ha aplicado una comision de $" + comision + ". Nuevo saldo: $" + saldo);
        } else {
            System.out.println("No hay suficiente saldo para aplicar la comisión."); // Mensaje de error
        }
    }

    public static void main(String[] args) {
        // Crear una cuenta con un titular, saldo inicial e ingresos mensuales
        Cuenta cuenta1 = new Cuenta("Juan Uribe", 10000000, 10000000); // 10 millones de ingreso mensual
        Cuenta cuenta2 = new Cuenta("Daniela Quiroga", 5000000, 5000000); // Otra cuenta con 5 millones

        // Consultar el saldo inicial
        System.out.println("Saldo inicial de Juan: $" + cuenta1.consultarSaldo());

        // Realizar una consignación
        cuenta1.consignar(2000000); // Consigna 2 millones

        // Realizar un retiro
        cuenta1.retirar(1000000); // Retira 1 millón

        // Transferir dinero a otra cuenta
        cuenta1.transferir(3000000, cuenta2); // Transfiere 3 millones a María

        // Aplicar la comisión mensual basada en los ingresos
        cuenta1.aplicarComision(); // Aplica el 15% de comisión sobre los ingresos de Juan

        // Consultar los saldos finales
        System.out.println("Saldo final de Juan: $" + cuenta1.consultarSaldo());
        System.out.println("Saldo final de Daniela: $" + cuenta2.consultarSaldo());
    }
}

