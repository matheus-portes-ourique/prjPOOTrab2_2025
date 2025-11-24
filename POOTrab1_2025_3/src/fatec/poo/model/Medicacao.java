package fatec.poo.model;

/**
 * @author erixian
 */
public class Medicacao {
    
    private String nome;
    private String dosagem;
    private int qtdeDias;
    private Consulta consulta;
    
    public Medicacao(String nome) {
        this.nome = nome;
    }
    
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }

    public String getNome() {
        return nome;
    }
}
