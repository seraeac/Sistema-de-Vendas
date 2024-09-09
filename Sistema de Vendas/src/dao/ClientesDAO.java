
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.Banco;
import model.Clientes;

/**
 *
 * @author rodolpho
 */
public class ClientesDAO {
    
    private final Connection conn;
    
    public ClientesDAO(){
        this.conn= new Banco().getConexao();
    
    }
    public void Salvar(Clientes obj){
        
        try {
            //criando o SQL
            

            String sql = "INSERT INTO tb_clientes(nome,rg,cpf,email,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            //preparar conexao sql para se conectar ao banco
            
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setString(1,obj.getNome());
            stmt.setString(2,obj.getRg());
            stmt.setString(3,obj.getCpf());
            stmt.setString(4,obj.getEmail());
            stmt.setString(5,obj.getTelefone());
            stmt.setString(6,obj.getCelular());
            stmt.setString(7,obj.getCep());
            stmt.setString(8,obj.getEndereco());
            stmt.setInt(9,obj.getNumero());
            stmt.setString(10,obj.getComplemento());
            stmt.setString(12,obj.getBairro());
            stmt.setString(11,obj.getCidade());
            stmt.setString(13,obj.getEstado());
            
            // executa SQL
            stmt.execute();
            //fecha conecxao
            stmt.close();
            JOptionPane.showMessageDialog(null,"Cliente salvo com sucesso");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Cliente "+erro.getMessage());
        }
        
    }
    public Clientes buscarCliente(String nome){
       
        try {
            String sql = "SELECT * FROM tb_clientes WHERE nome=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,nome);
            ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setEstado(rs.getString("estado"));
            }
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar o cliente " +erro.getMessage());
        }
        return null;
    }
    
}
