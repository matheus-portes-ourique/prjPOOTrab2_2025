
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Paciente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author 0030482411017
 */
public class DaoPaciente {
    
    private Connection conn;

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Paciente paciente){
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tb_paciente values(?,?,?,?,?,?,?);");
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getCpf());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getDataNascimento());
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Paciente consultar(String cpf){
        Paciente p = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * from tb_paciente" + 
                                       "where cpf = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                p = new Paciente(cpf, rs.getString("nome"), LocalDate.parse(rs.getString("dataNascimento")));
            }
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return p;
    }
    
    public void alterar(Paciente paciente){
        
    }
    
    public void excluir(Paciente paciente){
        
    }
}
