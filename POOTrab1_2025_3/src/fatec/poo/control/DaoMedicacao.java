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
    
    public void inserir(Medicacao medicacao) {
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERIR INTO tb_medicacao VALUES (?,?,?);");
            
            ps.setString(1,medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.execute();
        }catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
   public void alterar (Medicacao medicacao) {
        PreparedStatement ps = null;
        try {
           ps = conn.prepareStatement("UPDATE tb_medicacao  SET dosagem = ?,"
                                       + "qtdDias = ?;");
            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
       } catch (SQLException ex) {
            System.out.println(ex.toString());
       }
    }
   
   public void consultar(String nome) {
       Medicacao medicacao = null;
       PreparedStatement ps = null;
       try {
          ps = conn.prepareStatement("SELECT * FROM tb_medicacao WHERE nome = ?;");
          ps.setString(1, nome);
          ResultSet rs = ps.executeQuery();
          if(rs.next()) {
              String procedure = "";
              ps = conn.prepareStatement(procedure);
              medicacao = new Medicacao();
          }
       } catch (Exception e) {
       }
       
   }
} 
   
    
