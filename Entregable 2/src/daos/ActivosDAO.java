package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import entregable1.Saldo;
import entregable1.Usuario;

public class ActivosDAO implements DaoInterface<Saldo>{
	private Connection con = null;
	public ActivosDAO() {
		con = MyConnection.getCon();
		this.crearTabla();
	}
	@Override
	public void crearTabla() {
		try {
			//Se crea una tabla si no existe ya en el archivo...
			String query = "CREATE TABLE IF NOT EXISTS ACTIVOS (" +
					"ID int PRIMARY KEY AUTO_INCREMENT" +
                    "SIGLA TEXT NOT NULL," +
					"NOMBRE TEXT NOT NULL,"+
                    "CANTIDAD DOUBLE,"+
                    "TIPO TEXT NOT NULL,"+
                    "USER_ID int NOT NULL,"+
                    "FOREING KEY ('USER_ID') REFERENCES 'USUARIOS' ('DNI')"+
                    ");";
			/*
			 * Después agregaremos los demás parámetros a la base de datos,
			 * Por ahora nos limitamos a esto para su funcionamiento.
			 * Se omitieron todos los datos relacionados con seguridad.
			 */
			Statement pstmt = con.createStatement();
			pstmt.execute(query);
			pstmt.close();
			return;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 

		return;


	}
	@Override
	public void modificar(Saldo saldo) { //SOLO MODIFICA LA CANTIDAD DE MONEDAS
		try {
			String query = ("UPDATE SALDOS SET CANTIDAD = ? WHERE ID = '"+saldo.getID()+"';");
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setDouble(1,saldo.getCantMonedas());  
			pstmt.executeUpdate();
			pstmt.close();
		  
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} 
		return;

	}

	
	@Override
	public void guardar(Saldo saldo) {
		try {
		    String query = "INSERT INTO saldos (SIGLA, CANTIDAD, TIPO, USER_ID) VALUES (?, ?, ?, ?)";
		    PreparedStatement pstmt = con.prepareStatement(query);
		    pstmt.setString(1,saldo.getSigla());
		    pstmt.setString(4,saldo.getUser_id());
		    pstmt.setString(3,saldo.getTipo());  
		    pstmt.setDouble(2,saldo.getCantMonedas());
		    pstmt.executeUpdate();
		    pstmt.close();
		  
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return;
		}		
		System.out.println("¡Se agregó con éxito la criptomoneda a la base de datos!");
		return;


	}

	@Override
	public List<Saldo> devolverTabla() {

		Saldo auxSaldo=null;
		List<Saldo> saldos = new LinkedList<Saldo>();
		try {
			Statement sent = con.createStatement();	
			ResultSet resul = sent.executeQuery("SELECT * FROM SALDOS");
			 
			// Si entra al while obtuvo al menos una fila
			while (resul.next()){
			auxSaldo = new Saldo(resul.getInt("ID"),resul.getString("USER_ID"),resul.getString("TIPO"),resul.getString("SIGLA"),resul.getDouble("CANTIDAD"));
			if (auxSaldo != null)
			{
				
			}
		}
			sent.close();
			return saldos;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return saldos;
		}
	}

	@Override
	public void remover(String s) {
		//No implementado.
	}
	
}