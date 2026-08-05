package Banco;

public class ContaBancaria {
    private double saldo;
    private final double limiteChequeEspecial;
    private double usadoChequeEspecial;

    public ContaBancaria(double depositoInicial) {
        if (depositoInicial < 0) {
            throw new IllegalArgumentException("Depósito inicial não pode ser negativo.");
        }
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
        this.usadoChequeEspecial = 0;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public double consultarChequeEspecial() {
        return limiteChequeEspecial - usadoChequeEspecial;
    }

    public boolean usandoChequeEspecial() {
        return usadoChequeEspecial > 0;
    }

    public double consultarLimiteTotalDisponivel() {
        return saldo + consultarChequeEspecial();
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }
        if (usandoChequeEspecial()) {
            double taxa = usadoChequeEspecial * 0.2;
            double totalDevido = usadoChequeEspecial + taxa;

            if (valor >= totalDevido) {
                valor -= totalDevido;
                System.out.printf("Cheque especial quitado. Taxa de %.2f cobrada.%n", taxa);
                usadoChequeEspecial = 0;
                saldo += valor;
            } else if (valor > taxa) {
                double pagoNoCheque = valor - taxa;
                usadoChequeEspecial -= pagoNoCheque;
                if (usadoChequeEspecial < 0) {
                    saldo += -usadoChequeEspecial;
                    usadoChequeEspecial = 0;
                }
                System.out.printf("Depósito usado para pagar parte do cheque especial. Ainda falta %.2f.%n", usadoChequeEspecial);
            } else {
                System.out.println("Depósito não é suficiente para pagar a taxa do cheque especial. O valor foi aplicado no saldo." );
                saldo += valor;
            }
        } else {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso.");
        }
        exibirResumo();
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }
        double disponivel = consultarLimiteTotalDisponivel();
        if (valor > disponivel) {
            System.out.println("Saldo insuficiente, mesmo considerando o cheque especial.");
            return;
        }
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double restante = valor - saldo;
            saldo = 0;
            usadoChequeEspecial += restante;
        }
        System.out.println("Saque realizado com sucesso.");
        exibirResumo();
    }

    public void pagarBoleto(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de boleto inválido.");
            return;
        }
        double disponivel = consultarLimiteTotalDisponivel();
        if (valor > disponivel) {
            System.out.println("Saldo insuficiente para pagar o boleto.");
            return;
        }
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            double restante = valor - saldo;
            saldo = 0;
            usadoChequeEspecial += restante;
        }
        System.out.println("Boleto pago com sucesso.");
        exibirResumo();
    }

    private void exibirResumo() {
        System.out.printf("Saldo: R$ %.2f | Cheque especial disponível: R$ %.2f | Usado: R$ %.2f%n",
                saldo, consultarChequeEspecial(), usadoChequeEspecial);
    }
}
