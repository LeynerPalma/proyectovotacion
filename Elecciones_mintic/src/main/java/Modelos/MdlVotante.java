/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;



/**
 *
 * @author leine
 */
public class MdlVotante {
    
        ClsJdbc jdbc;
    
   

    public MdlVotante() {
        this.jdbc = new ClsJdbc();
        this.jdbc.crearConexion();
    }
    
    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje;

        try {
            String sql = "INSERT INTO tbl_registro_votante VALUES (?,?,?,?,?,?,?)";
            PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(sql);
            sentencia.setString(1, votante.getCedula());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getCorreo());
            sentencia.setString(5, votante.getCiudad());
            sentencia.setString(6, votante.getCotrasena());
            sentencia.setInt(7, votante.getEstado());


            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {
                JOptionPane.showMessageDialog(null, "Votante agregado con exito");
                return null;
            }
            return null;



        } catch (Exception excepcion) {
            
            JOptionPane.showMessageDialog(null, "Uy ocurrió un error: " + excepcion.getMessage());
           
           return null;
              }

    }
 /**   
    public LinkedList <ClsVotante> llamarVotante (){    
        try{
                LinkedList <ClsVotante> lista = new LinkedList<>();
                String cosulta = "SELECT * FROM tbl_registro_votante";
                PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(cosulta);
                ResultSet  resultado = sentencia.executeQuery();
                
                while (resultado.next()){
                        String ndocumento = resultado.getString("ncedula ");
                        String nombre = resultado.getString("nombre");
                        String telefono = resultado.getString("telefono");
                        String correo =  resultado.getString("correo");
                        String ciudad = resultado.getString("ciudad");
                        String contrasena = resultado .getString("contrasena");
                        int estado = resultado.getInt("estado");

            
                        ClsVotante votante = new ClsVotante(ndocumento, nombre, telefono, correo, ciudad, contrasena, estado);
                        
                        lista. add(votante);
                }

                return  lista;    
        }  
        catch (Exception e){
                return null;
        }
    }
        
     public ClsMensaje eliminarVotante(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_registro_votante WHERE tipo_cedula = ?";
            
            
            PreparedStatement sentencia = this.jdbc.conexio.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un cadidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    } 
    * **/
    
}   
    