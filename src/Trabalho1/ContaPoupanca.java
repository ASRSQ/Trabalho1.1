package Trabalho1;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alex
 */
public class ContaPoupanca extends Contas{
    public static ContaPoupanca instancia2;
    
    protected ContaPoupanca() {
    }
 
    public static ContaPoupanca getInstancia1() {
        if (instancia2 == null)
            instancia2 = new ContaPoupanca();
        return instancia2;
    }

    private double reajuste;

    public double getReajuste() {
        return reajuste;
    }

    public void setReajuste(double reajustar) {
        this.reajuste = reajustar;
    }
    
    double reajustar(double taxa)
    {
        setSaldo((taxa/100)*getSaldo()+getSaldo());
        return getSaldo();
    }
    void reajustar()
    {
        setSaldo(0.1*getSaldo()+getSaldo());
    }
    String tipoconta()
    {
        return "Poupança";
    }
}
