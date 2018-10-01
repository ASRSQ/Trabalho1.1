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
public class ContaEspecial extends Contas {
    private int limite=0;
    private double multa=0;
    public static ContaEspecial instancia1;
 
    protected ContaEspecial() {
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
 
    public static ContaEspecial getInstancia1() {
        if (instancia1 == null)
            instancia1 = new ContaEspecial();
        return instancia1;
    }
    void descontar(double valor)
    {
        double r;
        r= getSaldo()-valor;
        setSaldo((r*(multa/100))+r);
    }
    
    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }
    String tipoConta()
    {
        return "Especial";
    }
}
