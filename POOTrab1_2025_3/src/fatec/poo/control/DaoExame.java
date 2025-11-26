
package fatec.poo.control;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

import fatec.poo.model.Exame;

/**
 * @author 0030482411017
 */

public class DaoExame {
    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Exame exame){
        PreparedStatement ps = null;
        
        try {
            ps = conn.prepareStatement("INSERT INTO tb_exame VALUES(,,,,)");
            
            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Exame exame){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("DELETE FROM tb_exame"
                                     + "WHERE codigo = ?");
            
            ps.setInt(1, exame.getCodigo());
            ps.execute();
            
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Exame exame){
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("UPDATE tb_exame SET descricao = ?,"
                                     + "exa_data = ?,"
                                     + "exa_hora = ?,"
                                     + "valor = ?,"
                                     + "WHERE codigo = ?");
            
            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());
            
            ps.execute();

        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Exame consultar(int codigo){
        Exame e = null;
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tb_exame"
                                     + "WHERE codigo = ?;");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                e = new Exame(rs.getInt("codigo"), rs.getString("descricao"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        
        return e;
    }
    
}
