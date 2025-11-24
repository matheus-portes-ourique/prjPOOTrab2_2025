
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author erixian
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    private ArrayList<Exame> exames;
    private Medico medico;
    private Paciente Paciente;
    private ArrayList<Medicacao> medicacoes;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        this.exames = new ArrayList<Exame>();
        this.medicacoes = new ArrayList<Medicacao>();
    }
    
    public void addExame(Exame e) {
        this.exames.add(e);
        e.setConsulta(this);
    }
    
    public void addMedicacao(Medicacao m){
        medicacoes.add(m);
        m.setConsulta(this);
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente Paciente) {
        this.Paciente = Paciente;
    }
    
    public double calcValorTotalPagar() {
        double totalPagar = 0.0;
        for(int i = 0; i < exames.size(); i++) {
            totalPagar += exames.get(i).getValor();
        }
        return totalPagar + valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}
