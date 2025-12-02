/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 0030482411017
 */
public class DaoMedicacao {
    private Connection conn;
    
    public DaoMedicacao(Connection conn) {
        this.conn =  conn;
    }
    
     public void inserir(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO tb_medicacao (nome, dosagem, qtdDias, consulta_codigo) VALUES (?,?,?,?)");
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, codigoConsulta);
            
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao inserir: " + ex.toString());
        }
    }
    
   public void alterar(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE tb_medicacao SET dosagem = ?, qtdDias = ? WHERE nome = ? AND consulta_codigo = ?");
            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setString(3, medicacao.getNome());
            ps.setInt(4, codigoConsulta);
            
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao alterar: " + ex.toString());
        }
    }
   
   /*public Medicacao consultar(String nome, int codConsulta) {
       Medicacao medicacao = null;
       PreparedStatement ps = null;
       try {
          ps = conn.prepareStatement("SELECT * FROM tb_medicacao WHERE nome = ? "
                                    + "AND consulta_codigo = ?");
          ps.setString(1, nome);
          ps.setInt(2, codConsulta);
          ResultSet rs = ps.executeQuery();
          if(rs.next()) {
              medicacao = new Medicacao(rs.getString("nome"));
              medicacao.setDosagem(rs.getString("dosagem"));
              medicacao.setQtdeDias(rs.getInt("qtdDias"));
              medicacao.setConsulta(rs.getInt("consulta_codigo"));
          }
       } catch (SQLException ex) {
           System.out.println(ex.toString());
       }  
       return medicacao;
   }*/
   
   public void excluir(Medicacao medicacao, int codigoConsulta) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM tb_medicacao WHERE nome = ? AND consulta_codigo = ?");
            ps.setString(1, medicacao.getNome());
            ps.setInt(2, codigoConsulta);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao excluir: " + ex.toString());
        }
    }
   
    public Medicacao consultar(String nome, int codigoConsulta) {
        Medicacao m = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * FROM tb_medicacao WHERE nome = ? AND consulta_codigo = ?");
            ps.setString(1, nome);
            ps.setInt(2, codigoConsulta);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                m = new Medicacao(rs.getString("nome"));
                m.setDosagem(rs.getString("dosagem"));
                m.setQtdeDias(rs.getInt("qtdDias"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao consultar: " + e.toString());
        } 
        return m;
    }
} 
   
    
