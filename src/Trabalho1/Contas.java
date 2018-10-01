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
public class Contas {
    public static Contas instancia;
    protected Contas() {
    }
 
    public static Contas getInstancia() {
        if (instancia == null)
            instancia = new Contas();
        return instancia;
    }
    //private ContaEspecial a= ContaEspecial.getInstancia1();
    private String nome;
    private int numero;
    private double saldo;
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    String sacar(double valor){
        if(getSaldo()>=valor){
        setSaldo( getSaldo()-valor);
        return "Saque efetuado com sucesso";
        }
        else return "Saldo insuficiente";
    }
    String depositar(double valor)
    {
        saldo= valor+saldo;
        return "Deposito bem sucedido";
    }
    double transferir(int a, int b, double valor)
    {
        double t;
        if(a==getNumero())
        {
            if(getSaldo()>=valor )
            {
                
            setSaldo(getSaldo()-valor);
            t=valor;
            
            }
            else 
            {
                t=0;
            }
            return t;
        }
        else return 0;
    }
    String tipoConta()
    {
        return "Conta-comum";
    }
    
            }
