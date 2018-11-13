package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import negocio.Conta;

public class ContaDao {

	public static List<Conta> obterLista() {
		String sql = "SELECT * FROM TCONTA ORDER BY descricao?";
		List<Conta> lista = null;
		PreparedStatement ps = null;
		
		try {	
			lista = new ArrayList<>();
			ps = Conexao.obterConexao().prepareStatement(sql);

			ResultSet rs = null; 
			rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(
				new Conta(
				rs.getLong("id"),
				rs.getString("descricao"),
				rs.getFloat("valor"),
				rs.getBoolean("debito")
				)
				);
				return lista;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;		
	}


public static boolean incluir(Conta conta){
	String sql = "INSERT INTO TCONTA(descricao, valor, debito) VALUES (?, ?, ?)";
	
	PreparedStatement ps = null;
	
	try {			
		ps = Conexao.obterConexao().prepareStatement(sql);
		ps.setString(1, conta.getDescricao());
		ps.setFloat(2, conta.getValor());
		ps.setBoolean(3, conta.isDebito());		
		ps.execute();
		
		return true;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return false;
}
}