
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
    private DaoConsulta daoConsulta;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Exame exame, int codigoConsulta){
        PreparedStatement ps = null;
        try {
            
            String sql = "INSERT INTO tb_exame (codigo, descricao, exa_data, exa_hora, valor, consulta_codigo) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(sql);
            
            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, codigoConsulta); 
            
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " + ex.toString());
        }
    }
    
    public void excluir(Exame exame){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tb_exame WHERE codigo = ?");
            ps.setInt(1, exame.getCodigo());
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println("Erro ao excluir: " + ex.toString());
        }
    }
    
    public void alterar(Exame exame){
        PreparedStatement ps = null;
        try{
            String sql = "UPDATE tb_exame SET descricao = ?, exa_data = ?, exa_hora = ?, valor = ? WHERE codigo = ?";
            ps = conn.prepareStatement(sql);
            
            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println("Erro ao alterar: " + ex.toString());
        }
    }
    
    public Exame consultar(int codigo){
        Exame e = null;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM tb_exame WHERE codigo = ?");
            
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                daoConsulta = new DaoConsulta(conn);
                e = new Exame(rs.getInt("codigo"), rs.getString("descricao"));
                e.setData(rs.getString("exa_data"));
                e.setHorario(rs.getString("exa_hora"));
                e.setValor(rs.getDouble("valor"));
                e.setConsulta(daoConsulta.consultar(rs.getInt("consulta_codigo")));
            }
            rs.close();
            ps.close();
        }catch(SQLException ex){
            System.out.println("Erro ao consultar: " + ex.toString());
        }
        return e;
    }
}