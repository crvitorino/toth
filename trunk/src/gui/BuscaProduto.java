package gui;

import Componentes.ModeloTabela;
import app.ConSQL;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author fernando
 */
public class BuscaProduto extends Busca{
    
    /** Creates a new instance of BuscaCliente */
    private JLabel lbNome, lbFab;
    private JButton btPesquisar, btSelecionar;
    private JTextField txtNome, txtFab;
    private Pedido pedido;
    public BuscaProduto(ConSQL con, Pedido pedido) {
        super("Busca de Produtos");
        this.pedido = pedido;
        this.con = con;
        this.setLayout(new FlowLayout());
        this.setPreferredSize(new Dimension(700, 190));
        colunas = new Vector();
        String[] cols = {"Código", "Descriçao", "Fabricante", "Grupo", "Custo", "Venda"};
        for (int i=0; i<6; i++)
            colunas.addElement(cols[i]);
        
        tbModel =  new ModeloTabela(new Object [][] { }, cols);
        
        lbNome = new JLabel("Descrição: ");
        lbFab = new JLabel("Fabricante: ");
        txtNome = new JTextField(10);
        txtFab = new JTextField(10);
        btPesquisar = new JButton("Pesquisar");
        btSelecionar =  new JButton("Selecionar");
          
        tabela = new JTable();
        JScrollPane scroll = new JScrollPane(tabela);
        
        tabela.setModel(tbModel);
        tabela.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tabela.setOpaque(false);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scroll.setPreferredSize(new Dimension(650, 115));
        
        this.add(lbNome);
        this.add(txtNome);
        this.add(lbFab);
        this.add(txtFab);
        this.add(btPesquisar);
        this.add(btSelecionar);
        this.add(scroll);
        
        btPesquisar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getTable();
            }
        });
        btSelecionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selecionaValor();
            }
        });
               
        
    }
    protected void selecionaValor() {
        int indice = tabela.getSelectedRow();
        if (indice > -1) {
            int id  = Integer.parseInt(tbModel.getValueAt(indice, 0).toString());
            pedido.recebeIdProduto(id);
            this.dispose();
        } else 
            JOptionPane.showMessageDialog(this, "Nenhum produto foi selecionado!","Produto não selecionado", JOptionPane.ERROR_MESSAGE);
        
    }
    private void getTable() {
      
        Statement statement; 
        ResultSet resultset; 
 
        try {
            String query;
            if (!txtNome.getText().equals("") && !txtFab.getText().equals("")) 
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where upper(descricao) LIKE '"+txtNome.getText().toUpperCase()+"%' AND fabricante LIKE '"+txtFab.getText().toUpperCase()+"%' order by nome";
            else if (!txtNome.getText().equals(""))
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where upper(descricao) LIKE '"+txtNome.getText().toUpperCase()+"%' order by nome";
            else if (!txtFab.getText().equals(""))
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos where  '"+txtFab.getText().toUpperCase()+" order by nome";
            else
                query = "Select id,descricao,fabricante, grupo, custo, venda from produtos order by descricao";
            statement = con.getStatement(); 
            resultset = statement.executeQuery(query); 
            displayResultSet(resultset); 
        } 
        catch ( SQLException sqlex ) { 
            sqlex.printStackTrace(); 
        } 
    } 
} 
   
