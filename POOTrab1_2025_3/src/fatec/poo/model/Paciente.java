/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author erixian
 */
public class Paciente extends Pessoa {
    private LocalDate dataNascimento;
    private double altura;
    private double peso;
    private ArrayList<Consulta> consultas; 
    

    public Paciente(String cpf, String nome, LocalDate dataNasc) {
        super(cpf, nome);
        this.dataNascimento = dataNasc;
        consultas = new ArrayList<Consulta>();
    }
    
    public void addConsulta(Consulta c){
        consultas.add(c);
        //SEGUNDO A CORRECAO DO DIMAS, CONSULTA NAO APONTA PARA PACIENTE
        //c.setPaciente(this);
    }
    
    //Professor, arredondei o valor de saida do metodo para evitar decimais gigantes
    public double calcIMC() {
        double imc = peso/(Math.pow(altura, 2));
        return Math.round(imc * 100) / 100.0;
    }
    
    public int calcIdade(LocalDate dataAtual) {
        return Period.between(dataNascimento, dataAtual).getYears();
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }  
}
