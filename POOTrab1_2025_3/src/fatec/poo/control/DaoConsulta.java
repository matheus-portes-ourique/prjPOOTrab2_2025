package fatec.poo.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.control.DaoMedico;
import fatec.poo.model.Paciente;

/**
 * @author 0030482411017
 */

public class DaoConsulta {

    public Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta, String cpfPaciente) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tb_consulta VALUES (?,?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5, cpfPaciente);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Consulta consulta) {
        PreparedStatement ps = null;

        try {
       
            String sql = "UPDATE tb_consulta SET " +
                        "cons_data = ?, " +
                        "valor = ? " +
                        "WHERE codigo = ?";
        
            ps = conn.prepareStatement(sql);
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());

            ps.execute();
            ps.close();
        
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar consulta: " + ex.toString());
        }
    }

    public Consulta consultar(int codigo) {
        Consulta c = null;
        PreparedStatement ps = null;
    
       try {
        String sql = "SELECT c.codigo, c.cons_data, c.valor, c.pac_cpf, " + 
                     "m.cpf AS med_cpf, m.nome AS med_nome " +
                     "FROM tb_consulta c " +
                     "INNER JOIN tb_medico m ON c.med_cpf = m.cpf " +
                     "WHERE c.codigo = ?";

        ps = conn.prepareStatement(sql);
        ps.setInt(1, codigo);
        ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Consulta(rs.getInt("codigo"), rs.getString("cons_data"));
                c.setValor(rs.getDouble("valor"));
            
                Medico m = new Medico(rs.getString("med_cpf"), rs.getString("med_nome"), "", "");
                c.setMedico(m);
            
                c.setCpfPaciente(rs.getString("pac_cpf"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }   
        return c;
    }

    public void excluir(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("DELETE FROM tb_consulta "
                    + "WHERE codigo = ?");

            ps.setInt(1, consulta.getCodigo());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
}
