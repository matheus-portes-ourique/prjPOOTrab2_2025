
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Medico;

/**
 * @author 0030482411017
 */

public class DaoMedico {
    private Connection conn;

    public DaoMedico(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Medico medico){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("INSERT INTO tb_medico VALUES (?,?,?,?,?,?);");
            
            ps.setString(1, medico.getNome());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getCrm());
            ps.setString(4, medico.getEspecialidade());
            ps.setString(5, medico.getEndereco());
            ps.setString(6, medico.getTelefone());
            
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Medico medico){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("UPDATE tb_medico");
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Medico consultar(){
    
    }
    
    public void excluir(){
        
    }
    
    
}
