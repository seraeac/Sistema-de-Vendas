
package view;

import dao.ClientesDAO;
import dao.FornecedoresDAO;
import dao.ProdutosDAO;
import java.awt.GraphicsConfiguration;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Clientes;
import model.Fornecedores;
import model.Funcionarios;
import model.Produtos;
import utilitarios.SessaoUsuario;
import utilitarios.Utilitarios;

/**
 *
 * @author rodolpho
 */


public class FormularioVendas extends javax.swing.JFrame {

    /**
     * Creates new form FormularioCliente
     */
   private String nivelAcesso;
    public void listar(){
        ProdutosDAO dao = new ProdutosDAO();
            List<Produtos> lista = dao.Listar();

            DefaultTableModel dados = (DefaultTableModel) tabela_produtos.getModel();
            dados.setNumRows(0);
            for(Produtos c: lista){
                dados.addRow(new Object[]{
                c.getId(),
                c.getDescricao(),
                c.getPreco(),
                c.getQtdEstoque(),
                c.getLote(),
                c.getData_cadastro(),
                c.getFornecedores().getNome()
                });

            }
        
    }
        
   
   
    
    public FormularioVendas(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
        JOptionPane.showMessageDialog(null, "Nível de Acesso: " + nivelAcesso);
        initComponents();
       configurarVisibilidadeBotoes(nivelAcesso);
    }
private void configurarVisibilidadeBotoes(String nivelAcesso) {
        
         
         if (nivelAcesso.equals("Adminstrador")) {
            // Se for usuário ADM
                 
            }
         
       if (nivelAcesso.equals("Usuário")) {
            // Se for usuário comum, esconde os botões de edição e exclusão
         
           
        }
    }
    public FormularioVendas(GraphicsConfiguration gc) {
        super(gc);
    }
            Clientes obj = new Clientes();

        double preco,subtotal,total;
        int qtd;
        DefaultTableModel meus_produtos;
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        painel_vendas = new javax.swing.JPanel();
        painel_dados_cliente = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        btnPesquisaNomeCliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtEncontraProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela_produtos = new javax.swing.JTable();
        txtData = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtFuncionarioId = new javax.swing.JTextField();
        painel_carrinho = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabela_carrinho = new javax.swing.JTable();
        painel_dados_produtos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtCodigoProduto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtProduto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtQtd_estoque = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtDescontoProduto = new javax.swing.JTextField();
        btnPesquisaProduto = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtQtd_produto = new javax.swing.JTextField();
        btnAddProduto = new javax.swing.JButton();
        btnAddProduto1 = new javax.swing.JButton();
        painel_finaliza_venda = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTotalVenda = new javax.swing.JFormattedTextField();
        btnPagamento = new javax.swing.JButton();
        btnCancelaVenda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Formulario Cliente");
        setMinimumSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ponto de Vendas");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        painel_dados_cliente.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Cliente"));

        jLabel16.setText("CPF:");

        try {
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCPFActionPerformed(evt);
            }
        });
        txtCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCPFKeyPressed(evt);
            }
        });

        jLabel2.setText("Data:");

        jLabel3.setText("Nome:");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNomeKeyPressed(evt);
            }
        });

        btnPesquisaNomeCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        btnPesquisaNomeCliente.setText("Pesquisar");
        btnPesquisaNomeCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaNomeClienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Encontre um Produto Aqui:");

        txtEncontraProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEncontraProdutoActionPerformed(evt);
            }
        });
        txtEncontraProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEncontraProdutoKeyReleased(evt);
            }
        });

        tabela_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Descrição", "Preço", "Qtd. Estoque", "Lote", "Data", "Fornecedor"
            }
        ));
        tabela_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabela_produtosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela_produtos);

        txtData.setEditable(false);
        txtData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDataActionPerformed(evt);
            }
        });

        jLabel12.setText("Fun.ID");

        txtFuncionarioId.setEditable(false);
        txtFuncionarioId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFuncionarioIdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_clienteLayout = new javax.swing.GroupLayout(painel_dados_cliente);
        painel_dados_cliente.setLayout(painel_dados_clienteLayout);
        painel_dados_clienteLayout.setHorizontalGroup(
            painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                .addGroup(painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnPesquisaNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFuncionarioId))))
                    .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEncontraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        painel_dados_clienteLayout.setVerticalGroup(
            painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_clienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtFuncionarioId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisaNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painel_dados_clienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEncontraProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
        );

        painel_carrinho.setBorder(javax.swing.BorderFactory.createTitledBorder("Carrinho de Compras"));

        tabela_carrinho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Qtd", "Preço", "SubTotal"
            }
        ));
        tabela_carrinho.setEnabled(false);
        jScrollPane2.setViewportView(tabela_carrinho);

        javax.swing.GroupLayout painel_carrinhoLayout = new javax.swing.GroupLayout(painel_carrinho);
        painel_carrinho.setLayout(painel_carrinhoLayout);
        painel_carrinhoLayout.setHorizontalGroup(
            painel_carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_carrinhoLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 25, Short.MAX_VALUE))
        );
        painel_carrinhoLayout.setVerticalGroup(
            painel_carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_carrinhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        painel_dados_produtos.setBorder(javax.swing.BorderFactory.createTitledBorder("Dados do Produto"));

        jLabel5.setText("Codigo:");

        txtCodigoProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCodigoProdutoKeyPressed(evt);
            }
        });

        jLabel6.setText("Produto:");

        txtProduto.setEditable(false);
        txtProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProdutoActionPerformed(evt);
            }
        });

        jLabel7.setText("Preço:");

        txtPreco.setEditable(false);

        jLabel8.setText("Estoque:");

        txtQtd_estoque.setEditable(false);
        txtQtd_estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQtd_estoqueActionPerformed(evt);
            }
        });

        jLabel9.setText("Desconto em %: ");

        btnPesquisaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/buscar.png"))); // NOI18N
        btnPesquisaProduto.setText("Pesquisar");
        btnPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaProdutoActionPerformed(evt);
            }
        });

        jLabel10.setText("QTD:");

        txtQtd_produto.setText("1");

        btnAddProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/novo.png"))); // NOI18N
        btnAddProduto.setText("Adicionar Item");
        btnAddProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProdutoActionPerformed(evt);
            }
        });

        btnAddProduto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/limpa.png"))); // NOI18N
        btnAddProduto1.setText("Limpar");
        btnAddProduto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddProduto1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painel_dados_produtosLayout = new javax.swing.GroupLayout(painel_dados_produtos);
        painel_dados_produtos.setLayout(painel_dados_produtosLayout);
        painel_dados_produtosLayout.setHorizontalGroup(
            painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                        .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQtd_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtQtd_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAddProduto)
                                .addGap(18, 18, 18)
                                .addComponent(btnAddProduto1)))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        painel_dados_produtosLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAddProduto, btnAddProduto1});

        painel_dados_produtosLayout.setVerticalGroup(
            painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_dados_produtosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtDescontoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnPesquisaProduto))
                .addGap(18, 18, 18)
                .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(txtQtd_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAddProduto)
                        .addComponent(btnAddProduto1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_dados_produtosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtQtd_estoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painel_dados_produtosLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnAddProduto, btnAddProduto1});

        painel_finaliza_venda.setBorder(javax.swing.BorderFactory.createTitledBorder("Finaliza Venda"));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total da Venda:");

        txtTotalVenda.setEditable(false);
        txtTotalVenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTotalVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalVendaActionPerformed(evt);
            }
        });

        btnPagamento.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_Finance_loan_money_1889199.png"))); // NOI18N
        btnPagamento.setText("PAGAMENTO");
        btnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentoActionPerformed(evt);
            }
        });

        btnCancelaVenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelaVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/iconfinder_download_cancel_103531.png"))); // NOI18N
        btnCancelaVenda.setText("CANCELAR VENDA");

        javax.swing.GroupLayout painel_finaliza_vendaLayout = new javax.swing.GroupLayout(painel_finaliza_venda);
        painel_finaliza_venda.setLayout(painel_finaliza_vendaLayout);
        painel_finaliza_vendaLayout.setHorizontalGroup(
            painel_finaliza_vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_finaliza_vendaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_finaliza_vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painel_finaliza_vendaLayout.createSequentialGroup()
                        .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painel_finaliza_vendaLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_finaliza_vendaLayout.setVerticalGroup(
            painel_finaliza_vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_finaliza_vendaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painel_finaliza_vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTotalVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painel_finaliza_vendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelaVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout painel_vendasLayout = new javax.swing.GroupLayout(painel_vendas);
        painel_vendas.setLayout(painel_vendasLayout);
        painel_vendasLayout.setHorizontalGroup(
            painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_vendasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_dados_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_dados_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painel_carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(painel_finaliza_venda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painel_vendasLayout.setVerticalGroup(
            painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painel_vendasLayout.createSequentialGroup()
                .addGroup(painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_dados_cliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_carrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painel_vendasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_dados_produtos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painel_finaliza_venda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painel_vendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1060, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painel_vendas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        java.util.Date agora = new java.util.Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy | H:mm:ss");
        String dataFormatada = formato.format(agora);
        txtData.setText(String.valueOf(dataFormatada));
        
         // Obtém o funcionário logado da sessão
    Funcionarios funcionarioLogado = SessaoUsuario.getFuncionarioLogado();
    txtFuncionarioId.setText(String.valueOf(funcionarioLogado.getId()));
    /*
    
    if (funcionarioLogado != null) {
        txtFuncionarioId.setText(String.valueOf(funcionarioLogado.getId()));
    } else {
        JOptionPane.showMessageDialog(this, "Nenhum funcionário está logado!");
    }
    */
        listar();
        
    }//GEN-LAST:event_formWindowActivated

    private void txtCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCPFActionPerformed
        
    }//GEN-LAST:event_txtCPFActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtEncontraProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEncontraProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEncontraProdutoActionPerformed

    private void btnPesquisaNomeClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaNomeClienteActionPerformed
        String nome = txtNome.getText();
        Clientes obj = new Clientes();
        ClientesDAO dao = new ClientesDAO();
        
        obj = dao.buscarCliente(nome);
        
        if(obj.getNome()==null){
            JOptionPane.showMessageDialog(null,"Cliente  não encontrado!");
        
    }     
        
        if(obj.getNome()!= null){
            
            txtCPF.setText(obj.getCpf());
            txtNome.setText(obj.getNome());
            
        }
    }//GEN-LAST:event_btnPesquisaNomeClienteActionPerformed

    private void txtQtd_estoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQtd_estoqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQtd_estoqueActionPerformed

    private void txtTotalVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalVendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalVendaActionPerformed

    private void txtCPFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCPFKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String cpf = txtCPF.getText();
            Clientes obj = new Clientes();
            ClientesDAO dao = new ClientesDAO();

            obj = dao.buscarClientePorCPF(cpf);

            if(obj.getCpf()==null){
                JOptionPane.showMessageDialog(null,"Cliente  não encontrado!");

            }     

            if(obj.getCpf()!= null){

                txtCPF.setText(obj.getCpf());
                txtNome.setText(obj.getNome());
            }
        }
    }//GEN-LAST:event_txtCPFKeyPressed

    private void txtNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String nome = txtNome.getText();
        Clientes obj = new Clientes();
        ClientesDAO dao = new ClientesDAO();
        
        obj = dao.buscarCliente(nome);
        
        if(obj.getNome()==null){
            JOptionPane.showMessageDialog(null,"Cliente  não encontrado!");
        
    }     
        
        if(obj.getNome()!= null){
            
            txtCPF.setText(obj.getCpf());
            txtNome.setText(obj.getNome());
            
        }
        
        }
    }//GEN-LAST:event_txtNomeKeyPressed

    private void txtEncontraProdutoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncontraProdutoKeyReleased
        String descricao = "%"+txtEncontraProduto.getText()+"%";
        ProdutosDAO dao = new ProdutosDAO();
        List<Produtos> lista = dao.Filtrar(descricao);
        DefaultTableModel dados = (DefaultTableModel) tabela_produtos.getModel();
        dados.setNumRows(0);
        for(Produtos c: lista){
            dados.addRow(new Object[]{
            c.getId(),
            c.getDescricao(),
            c.getPreco(),
            c.getQtdEstoque(),
            c.getLote(),
            c.getData_cadastro(),
            c.getFornecedores().getNome()
        });
           
        }
    }//GEN-LAST:event_txtEncontraProdutoKeyReleased

    private void tabela_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabela_produtosMouseClicked
        
        txtCodigoProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(),0).toString());
        txtProduto.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(),1).toString());
        txtPreco.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(),2).toString());
        txtQtd_estoque.setText(tabela_produtos.getValueAt(tabela_produtos.getSelectedRow(),3).toString());
        
      
    }//GEN-LAST:event_tabela_produtosMouseClicked

    private void btnAddProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProdutoActionPerformed
        String nome =txtProduto.getText();
        Produtos obj = new Produtos();
        ProdutosDAO dao = new ProdutosDAO();
        
        obj = dao.buscarProdutos(nome);
        
        preco = Double.valueOf(txtPreco.getText());
        
        // Valida se os dados do produto caso esteja alguma coisa errada
        if(preco<=0 || obj.getQtdEstoque()<=0 || obj.getDescricao()==null){
                JOptionPane.showMessageDialog(null,"Não foi possivel adicionar ao carrinho Falta informações.");
                return;
            }
        // validação e inicalização dos dados do produtos para jogar na tabela de vendas
        if(obj.getDescricao()!=null){
            int estoque = Integer.valueOf(txtQtd_estoque.getText());
            int quantidade_de_venda = Integer.valueOf(txtQtd_produto.getText());
            preco = Double.valueOf(txtPreco.getText());
            quantidade_de_venda= Integer.valueOf(txtQtd_produto.getText());
            subtotal = preco*quantidade_de_venda;
            total+=subtotal;
            
            // validação caso a quantiadade de itens da venda nao for maior que 1
            String qtd_venda_String =txtQtd_produto.getText().trim();
            if (quantidade_de_venda<1 || qtd_venda_String.isEmpty()){
                JOptionPane.showMessageDialog(null,"Quantidade de venda invalida");
            }
            
            if(estoque>=quantidade_de_venda && quantidade_de_venda>0){
                txtTotalVenda.setText(String.valueOf(total));
                meus_produtos = (DefaultTableModel)tabela_carrinho.getModel();
                meus_produtos.addRow(new Object[]{
                    txtCodigoProduto.getText(),
                    txtProduto.getText(),
                    txtQtd_produto.getText(),
                    txtPreco.getText(),
                    subtotal
                
                });
            }
            if(estoque<quantidade_de_venda){
                JOptionPane.showMessageDialog(null,"A quantidade de produtos e maior que a do estoque");
            }
            
            
        }
    }//GEN-LAST:event_btnAddProdutoActionPerformed

    private void btnPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaProdutoActionPerformed
        
        String id = txtCodigoProduto.getText();
        Produtos obj = new Produtos();
        ProdutosDAO dao = new ProdutosDAO();
        
        obj = dao.buscarProdutosPorID(id);
        
        if(obj.getId()==0){
            JOptionPane.showMessageDialog(null,"Produto não encontrado");        
        
        }
        if(obj.getId()!=0){
            txtProduto.setText(obj.getDescricao());
            txtPreco.setText(String.valueOf(obj.getPreco()));
            txtQtd_estoque.setText(String.valueOf(obj.getQtdEstoque()));
        }
    
    }//GEN-LAST:event_btnPesquisaProdutoActionPerformed

    private void txtProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProdutoActionPerformed

    private void txtCodigoProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoProdutoKeyPressed
        if(evt.getKeyCode()== KeyEvent.VK_ENTER){
            String id = txtCodigoProduto.getText();
            Produtos obj = new Produtos();
            ProdutosDAO dao = new ProdutosDAO();

            obj = dao.buscarProdutosPorID(id);
            if(obj.getId()==0){
                JOptionPane.showMessageDialog(null,"Produto não encontrado");        
            }
            if(obj.getId()!=0){
                txtProduto.setText(obj.getDescricao());
                txtPreco.setText(String.valueOf(obj.getPreco()));
                txtQtd_estoque.setText(String.valueOf(obj.getQtdEstoque()));
            }
        }
    }//GEN-LAST:event_txtCodigoProdutoKeyPressed

    private void btnAddProduto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddProduto1ActionPerformed
       Utilitarios util = new Utilitarios();
        util.LimpaTela(painel_dados_produtos);
        util.LimpaTela(painel_dados_cliente);
    }//GEN-LAST:event_btnAddProduto1ActionPerformed

    private void btnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentoActionPerformed
       String nome = txtNome.getText();
       String cpf = txtCPF.getText();
       obj = new Clientes();
       
       ClientesDAO daoc= new ClientesDAO();
       
       obj=daoc.buscarCliente(nome);
       obj=daoc.buscarClientePorCPF(cpf);
       
       if(obj.getNome()==null && obj.getCpf()==null){
           JOptionPane.showMessageDialog(null,"verifique se voce não esqueceu de preencher alguma informação importante");
       }
       
       if(obj.getNome()!=null && obj.getCpf()!=null){
           FormularioPagamentos telaPag = new FormularioPagamentos();
           telaPag.clientes = obj;
           telaPag.meus_produtos = meus_produtos;
           telaPag.txtTotal.setText(String.valueOf(total));
           telaPag.setVisible(true);
           this.dispose();
           
       }
    }//GEN-LAST:event_btnPagamentoActionPerformed

    private void txtDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDataActionPerformed

    private void txtFuncionarioIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFuncionarioIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFuncionarioIdActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormularioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioVendas("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddProduto;
    private javax.swing.JButton btnAddProduto1;
    private javax.swing.JButton btnCancelaVenda;
    private javax.swing.JButton btnPagamento;
    private javax.swing.JButton btnPesquisaNomeCliente;
    private javax.swing.JButton btnPesquisaProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painel_carrinho;
    private javax.swing.JPanel painel_dados_cliente;
    private javax.swing.JPanel painel_dados_produtos;
    private javax.swing.JPanel painel_finaliza_venda;
    public javax.swing.JPanel painel_vendas;
    private javax.swing.JTable tabela_carrinho;
    private javax.swing.JTable tabela_produtos;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JTextField txtCodigoProduto;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtDescontoProduto;
    private javax.swing.JTextField txtEncontraProduto;
    private javax.swing.JTextField txtFuncionarioId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    private javax.swing.JTextField txtQtd_estoque;
    private javax.swing.JTextField txtQtd_produto;
    private javax.swing.JFormattedTextField txtTotalVenda;
    // End of variables declaration//GEN-END:variables
}
