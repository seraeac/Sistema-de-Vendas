
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.Banco;
import model.Clientes;
import model.Fornecedores;
import model.Produtos;


/**
 *
 * @author rodolpho
 */
public class ProdutosDAO {
    
    private final Connection conn;
    
    public ProdutosDAO(){
        this.conn= new Banco().getConexao();
    
    }
    // metodo para salvar clientes no bando de dados
    public void salvarProdutos(Produtos obj){
        
        try {
             //criando o SQL
            String sql = "insert into tb_produtos (descricao,preco,qtd_estoque,for_id)"
                    + "values(?,?,?,?)";
            
            //preparar conexao sql para se conectar ao banco
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,obj.getDescricao());
            stmt.setDouble(2,obj.getPreco());
            stmt.setInt(3,obj.getQtdEstoque());
            stmt.setInt(4,obj.getFornecedores().getId());
           
            // executa SQL
            stmt.execute();
            //fecha conecxao
            stmt.close();
            JOptionPane.showMessageDialog(null,"Fornecedor salvo com sucesso");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar o Fornecedor "+erro.getMessage());
        }
      
        
    }
    // metodo para Editar clientes no banco de dados
    public void Editar(Produtos obj){
        
        try {
            //criando o SQL
            String sql = "update tb_produtos set descricao=?,preco=?,qtd_estoque=?,for_id=? where id=?";
            //preparar conexao sql para se conectar ao banco
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,obj.getDescricao());
            stmt.setDouble(2,obj.getPreco());
            stmt.setInt(3,obj.getQtdEstoque());
            stmt.setInt(4,obj.getFornecedores().getId());
            stmt.setInt(5,obj.getId());
            
            
            
            // executa SQL
            stmt.execute();
            //fecha conecxao
            stmt.close();
            JOptionPane.showMessageDialog(null,"Produto Editado com sucesso");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao editar o Produto "+erro.getMessage());
        }
        
    }
    //metodo para excluir  cliente no banco de dados
    public void Excluir(Produtos obj){
    
        try {
            String sql= "delete from tb_produtos where id = ?";
            
            PreparedStatement stmt=conn.prepareStatement(sql);
            
            stmt.setInt(1,obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null,"Produto excluido com sucesso");
        } catch (SQLException erro) {
            
            JOptionPane.showMessageDialog(null,"Erro ao excluir o Produto"+erro.getMessage());
        }
    }
    // metod para buscar o cliente no banco de dados
    public Produtos buscarProdutos(String descricao){
       
        try {
            String sql = "SELECT * FROM tb_produtos WHERE descricao=?";
            PreparedStatement stmt=conn.prepareStatement(sql);
            stmt.setString(1,descricao);
            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            if(rs.next()){
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                
                // buscando o ID do fornecedor
                
                int fornecedorID= rs.getInt("for_id");
                FornecedoresDAO dao = new FornecedoresDAO();
                Fornecedores fornecedor = new Fornecedores();
                
                dao.buscarPorId(fornecedorID);
                obj.setFornecedores(fornecedor);
                
            }
            return obj;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null,"Erro ao buscar o cliente " +erro.getMessage());
        }
        return null;
    }
    //metodo para listar o cliente na tabela de clientes na aba de consultar clientes
    public List<Produtos>Listar(){
       List<Produtos> lista = new ArrayList<>();
       
        try {
            String sql= "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p inner join tb_fornecedores as f on (p.for_id = f.id)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtdEstoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedores(f);
                
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao criar lista: " +erro.getMessage());
        }
        return null;
    }
    // metodo para filtrar o cliente em tempo de digitação e filtra a tabela no banco de dados
    public List<Produtos>Filtrar(String descricao){
       List<Produtos> lista = new ArrayList<>();
       
        try {
            String sql= "select * from tb_produtos where descricao like ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,descricao);
            ResultSet rs= stmt.executeQuery();
            
            while(rs.next()){
                
                Produtos obj = new Produtos();
                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtdEstoque(rs.getInt("qtd_estoque"));
                // buscando o ID do fornecedor
                
                int fornecedorID= rs.getInt("for_id");
                FornecedoresDAO dao = new FornecedoresDAO();
                Fornecedores fornecedor = new Fornecedores();
                
                dao.buscarPorId(fornecedorID);
                obj.setFornecedores(fornecedor);
                lista.add(obj);
            }
            return lista;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null,"Erro ao criar lista: " +erro.getMessage());
        }
        return null;
    }
    
    public List<Fornecedores> listarFornecedores() {
    List<Fornecedores> lista = new ArrayList<>();
    String sql = "SELECT * FROM tb_fornecedores";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Fornecedores fornecedor = new Fornecedores();
            fornecedor.setId(rs.getInt("id"));
            fornecedor.setNome(rs.getString("nome"));
            // Preencha os outros atributos, se necessário
            lista.add(fornecedor);
        }
        stmt.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar fornecedores: " + e.getMessage());
    }

    return lista;
}
}
