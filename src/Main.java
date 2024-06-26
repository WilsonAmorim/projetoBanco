import controle.Conta;
import controle.ContaCorrente;
import controle.ContaPoupanca;
import modelo.Cliente;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {

        CriarBanco();
    }

    private static void CriarBanco() {
        JFrame f;
        f = new JFrame();
        String nome = JOptionPane.showInputDialog(f, "Entre Nome do Cliente");
        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        Conta cc = new ContaCorrente(cliente);
        Conta pp = new ContaPoupanca(cliente);
        while (true) {
            int tipoConta = Integer.parseInt(JOptionPane.showInputDialog(f, "Entre  com o tipo da conta: 0 - Sair, 1 - Conta Corrente, 2 - Conta Poupança "));
            switch (tipoConta) {
                case 0:
                    break;
                case 1:
                    int movimentoC = Integer.parseInt(JOptionPane.showInputDialog(f, "0 - Sair, 1 - Saldo, 2 - Sacar, 3 - Deposito, 4 - Transferencia para Poupança"));
                    if(movimentoC == 0) break;
                    if(movimentoC == 1) cc.imprimirExtrato();
                    if(movimentoC == 2) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da saque"));
                        cc.sacar(valor);
                        cc.imprimirExtrato();
                    }
                    if(movimentoC == 3) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do depósito "));
                        cc.depositar(valor);
                        cc.imprimirExtrato();
                    }
                    if(movimentoC == 4) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da transferência "));
                        cc.transferir(valor, pp);
                        cc.imprimirExtrato();
                    }
                    break;
                case 2:
                    int movimentoP = Integer.parseInt(JOptionPane.showInputDialog(f, "0 - Sair, 1 - Saldo, 2 - Sacar, 3 - Deposito, 4 - Transferencia para Poupança"));
                    if(movimentoP == 0) break;
                    if(movimentoP == 1) pp.imprimirExtrato();
                    if(movimentoP == 2) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da saque"));
                        pp.sacar(valor);
                        pp.imprimirExtrato();
                    }
                    if(movimentoP == 3) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor do depósito "));
                        pp.depositar(valor);
                        pp.imprimirExtrato();
                    }
                    if(movimentoP == 4) {
                        double valor = Double.parseDouble(JOptionPane.showInputDialog(f, "Entre com o valor da transferência "));
                        pp.transferir(valor, cc);
                        pp.imprimirExtrato();
                    }
                    break;
            }
        }
    }
}