package fatec.poo.model;

/**
 * @author erixian
 */
public class Medicacao {
    
    private String nome;
    private String dosagem;
    private int qtdeDias;
    private int codConsulta;
    
    public Medicacao(String nome) {
        this.nome = nome;
    }
    
    public int getCodConsulta(){
        return codConsulta;
    }
    
    public void setConsulta(int codigo) {
        this.codConsulta = codigo;
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
