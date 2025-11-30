package fatec.poo.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.control.DaoMedico;

/**
 * @author 0030482411017
 */

public class DaoConsulta {

    public Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }

    public void inserir(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("INSERT INTO tb_consulta VALUES (?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void alterar(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = conn.prepareStatement("UPDATE tb_consulta SET valor = ?,"
                    + "med_cpf = ?"
                    + "WHERE codigo = ?");
            ps.setDouble(1, consulta.getValor());
            ps.setObject(2, consulta.getMedico());
            ps.setInt(3, consulta.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }

    public Consulta consultar(int codigo) {
        PreparedStatement ps = null;
        Consulta c = null;

        try {
            ps = conn.prepareStatement("SELECT * FROM tb_consultas"
                    + "WHERE codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Consulta(rs.getInt("codigo"), rs.getString("cons_data"));
                c.setValor(rs.getDouble("valor"));
                
                DaoMedico dm = new DaoMedico(conn);
                Medico m = dm.consultar(rs.getString("med_cpf"));
                c.setMedico(m);
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
