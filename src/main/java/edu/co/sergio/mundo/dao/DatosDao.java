package edu.co.sergio.mundo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import edu.co.sergio.mundo.vo.Visitas_Tecnicas;
import edu.co.sergio.mundo.vo.Recoleccion;
import edu.co.sergio.mundo.vo.Colmena;
import java.net.URISyntaxException;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2 Clase que permite la gestion de la tabla Depto en la base de
 * datos.
 *
 * CREATE TABLE Depto( id_depto integer, nom_depto varchar(40), PRIMARY
 * KEY(id_depto) );
 */
public class DatosDao {

    /**
     * Funcion que permite obtener una lista de los departamentos existentes en
     * la base de datos
     *
     * @return List<Departamento> Retorna la lista de Departamentos existentes
     * en la base de datos
     */
    public List<Visitas_Tecnicas> findAll() {
        List<Visitas_Tecnicas> Visitas = null;
        String query = "SELECT * FROM VTecnica";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DatosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            java.sql.Date fecha;
            String tecnico;
            int id_colmena;

            while (rs.next()) {
                if (Visitas == null) {
                    Visitas = new ArrayList<Visitas_Tecnicas>();
                }

                Visitas_Tecnicas registro = new Visitas_Tecnicas();

                fecha = rs.getDate("Fecha");
                registro.setFecha(fecha);

                tecnico = rs.getString("Tecnico");
                registro.setTecnico(tecnico);

                id_colmena = rs.getInt("id_Colmena");
                registro.setId_colmena(id_colmena);

                Visitas.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Visitas tecnicas");
            e.printStackTrace();
        }

        return Visitas;
    }

    public List<Recoleccion> findAll2() {
        List<Recoleccion> Recoleccion = null;
        String query = "SELECT * FROM Recoleccion";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DatosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            java.sql.Date fecha;
            String recolector;
            int id_colmena;
            int kilosdeiel;

            while (rs.next()) {
                if (Recoleccion == null) {
                    Recoleccion = new ArrayList<Recoleccion>();
                }

                Recoleccion registro = new Recoleccion();

                fecha = rs.getDate("Fecha");
                registro.setFecha(fecha);

                recolector = rs.getString("Recolector");
                registro.setRecolector(recolector);

                id_colmena = rs.getInt("id_Colmena");
                registro.setId_colmena(id_colmena);

                kilosdeiel = rs.getInt("KMiel");
                registro.setKilosdeiel(kilosdeiel);

                Recoleccion.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Recoleccion");
            e.printStackTrace();
        }

        return Recoleccion;
    }

    public List<Colmena> findAll3() {
        List<Colmena> Colmena = null;
        String query = "SELECT * FROM Colmena";
        Connection connection = null;
        try {
            connection = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(DatosDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);

            int id_colmena;
            String cantidadp;
            String calidado;
            boolean preina;
            boolean pmiel;
            int pccera;
            int pcalimento;
            int pccria;
            int pvacios;
            while (rs.next()) {
                if (Colmena == null) {
                    Colmena = new ArrayList<Colmena>();
                }

                Colmena registro = new Colmena();

                id_colmena = rs.getInt("id_Colmena");
                registro.setId_colmena(id_colmena);

                cantidadp = rs.getString("CantidadP");
                registro.setCantidadp(cantidadp);

                calidado = rs.getString("CalidadP");
                registro.setCalidado(calidado);

                preina = rs.getBoolean("PReina");
                registro.setPreina(preina);

                pmiel = rs.getBoolean("PMiel");
                registro.setPreina(pmiel);

                pccera = rs.getInt("PCCera");
                registro.setPccera(pccera);

                pcalimento = rs.getInt("PCAlimento");
                registro.setPcalimento(pcalimento);
                pccria = rs.getInt("PCCria");
                registro.setPccria(pccria);
                pvacios = rs.getInt("PVacios");
                registro.setPccera(pvacios);

                Colmena.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Visitas tecnicas");
            e.printStackTrace();
        }

        return Colmena;
    }

    /**
     * Funcion que permite realizar la insercion de un nuevo registro en la
     * tabla Visitas_Tecnicas
     *
     * @param Departamento recibe un objeto de tipo Visitas_Tecnicas
     * @return boolean retorna true si la operacion de insercion es exitosa.
     */
////	public boolean insert(Visitas_Tecnicas t) {
////		boolean result=false;
////		Connection connection=null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////	    String query = " insert into Depto (id_depto,nom_depto)"  + " values (?,?)";
////        PreparedStatement preparedStmt=null;
////	    try {
////			preparedStmt = connection.prepareStatement(query);
////			preparedStmt.setInt (1, t.getId_departamento());
////                        preparedStmt.setString (2, t.getNom_departamento());
////			result= preparedStmt.execute();
////	    } catch (SQLException e) {
////			e.printStackTrace();
////		}
////		return result;
////	}
////
////	/**
////	 * Funcion que permite realizar la actualizacion de un nuevo registro en la tabla Visitas_Tecnicas
////	 * @param Departamento recibe un objeto de tipo Visitas_Tecnicas 
////	 * @return boolean retorna true si la operacion de actualizacion es exitosa.
////	 */
////	public boolean update(Visitas_Tecnicas t) {
////		boolean result=false;
////		Connection connection= null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////		String query = "update Depto set nom_depto = ? where id_depto = ?";
////		PreparedStatement preparedStmt=null;
////		try {
////		    preparedStmt = connection.prepareStatement(query);
////		    preparedStmt.setString(1, t.getNom_departamento());
////                    preparedStmt.setInt   (2, t.getId_departamento());
////		    if (preparedStmt.executeUpdate() > 0){
////		    	result=true;
////		    }
////			    
////		} catch (SQLException e) {
////				e.printStackTrace();
////		}
////			
////		return result;
////	}
////
////	/**
////	 * Funcion que permite realizar la eliminario de registro en la tabla Visitas_Tecnicas
////	 * @param Departamento recibe un objeto de tipo Visitas_Tecnicas 
////	 * @return boolean retorna true si la operacion de borrado es exitosa.
////	 */
////	public boolean delete(Visitas_Tecnicas t) {
////	   boolean result=false;
////	   Connection connection = null;
////            try {
////                connection = Conexion.getConnection();
////            } catch (URISyntaxException ex) {
////                Logger.getLogger(Visitas_tecnicasDao.class.getName()).log(Level.SEVERE, null, ex);
////            }
////	   String query = "delete from Depto where id_depto = ?";
////	   PreparedStatement preparedStmt=null;
////	   try {
////		     preparedStmt = connection.prepareStatement(query);
////		     preparedStmt.setInt(1, t.getId_departamento());
////		    result= preparedStmt.execute();
////		} catch (SQLException e) {
////			e.printStackTrace();
////		}
////	   
////	   return result;
////	}
}
