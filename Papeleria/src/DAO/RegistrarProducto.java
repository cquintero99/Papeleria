/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import VO.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author 57310
 */
public class RegistrarProducto {
    
  
    
    public static void registrar(Connection cn, Producto p) throws SQLException {
        try {
            PreparedStatement consulta;
            consulta = cn.prepareStatement("Insert into producto(codigo,categoria,descripcion,valor,stock) Values(?,?,?,?,?)");
            consulta.setInt(1, p.getCodigo());
            consulta.setString(2, p.getCategoria());
            consulta.setString(3, p.getDescripcion());
            consulta.setInt(4, p.getValor());
            consulta.setInt(5, p.getStock());
            consulta.executeUpdate();
            System.out.println("guarda");
        } catch (SQLException e) {
            System.out.println("E guardar");
            throw new SQLException(e);
        }
    }
    public static Producto buscar(Connection cn,String codigo) throws SQLException{
        Producto p=new Producto();
        try{
            PreparedStatement consulta;
            consulta=cn.prepareStatement("Select categoria as Cate , descripcion as Des , valor as Valor , stock as Stock from producto where codigo='"+codigo+"'");
            ResultSet rs=consulta.executeQuery();
            if(rs.next()){
                p.setCategoria(rs.getString("Cate"));
                p.setDescripcion(rs.getString("Des"));
                p.setValor(rs.getInt("Valor"));
                p.setStock(rs.getInt("Stock"));
                
            }
        }catch(SQLException e){
            throw new SQLException(e);
        }
        return p;
    }
    public static void actualizar(Connection cn,Integer codigo,String categoria,String descripcion ,Integer valor,Integer stock) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta=cn.prepareStatement("UPDATE producto set descripcion='"+descripcion+"' , valor='"+valor+"' ,stock='"+stock+"',categoria='"+categoria+"' where codigo='"+codigo+"'");
            consulta.executeUpdate();
            System.out.println("Actualiza");
        }catch(SQLException e){
            System.out.println("E actualizar");
            throw new SQLException(e);
        }
    }
    public static void eliminar(Connection cn,Integer codigo) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta=cn.prepareStatement("DELETE from producto where codigo='"+codigo+"'");
            consulta.executeUpdate();
            System.out.println("Elimina");
        }catch(SQLException e){
            System.out.println("    E eliminar");
            throw new SQLException(e);
        }
    }
    
    public static ArrayList buscarProductos(Connection cn, String categoria) throws SQLException {
        ArrayList productos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = cn.prepareStatement("SELECT descripcion as Des from producto where categoria='" + categoria + "'");
            ResultSet rs = consulta.executeQuery();
            while (rs.next()) {
                
                productos.add(rs.getString("Des"));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return productos;
    }
    public static Producto buscarporNombre(Connection cn,String descripcion) throws SQLException{
        Producto p=new Producto();
        try{
            PreparedStatement consulta;
            consulta=cn.prepareStatement("select codigo as C , valor as V , stock as S from producto where descripcion='"+descripcion+"'");
            ResultSet rs=consulta.executeQuery();
            if (rs.next()){
                p.setCodigo(rs.getInt("C"));
                p.setStock(rs.getInt("S"));
                p.setValor(rs.getInt("V"));
            }
        }catch (SQLException e){
            throw new SQLException(e);
        }
        return p;
    }
    public static void compra(Connection cn,Integer cantidad,Integer codigo) throws SQLException{
        try{
            PreparedStatement consulta;
            consulta=cn.prepareStatement("UPDATE producto set stock=(stock-"+cantidad+") where codigo='"+codigo+"'");
            consulta.executeUpdate();
        }catch(SQLException e){
            throw new SQLException(e);
        }
    }
}
