/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chckavailability;



import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
public  class DbConnect extends AbstractTableModel {
    
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSetMetaData metaData;
    private int numberOfRows;
    private boolean connectedToDatabase = false;
    
    public DbConnect(String url, String username,String password, String query ){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url,username,password);
            st = con.createStatement();
            
            connectedToDatabase = true;
            
            setQuery(query);
                    
            
        }catch(Exception ex){
            System.out.println("Error:"+ex);
        }
    }
    
    
    
    public void setQuery(String query) throws SQLException {
        
       
        
        rs = st.executeQuery(query);
        metaData = rs.getMetaData();
        rs.last();
        numberOfRows = rs.getRow();
        
        fireTableStructureChanged();
    }
    
    
    public int getNumberOfRows(){
        return this.numberOfRows;
    }
    public ResultSet getRs(){
        return this.rs;    
    }
    
    public Statement getSt(){
        return this.st;   
    }
       
    public Connection getCon(){
        return this.con;
    }
    
    public void setRs(ResultSet rs){
        this.rs = rs;
    }
    

     @Override
    public int getRowCount() {//throw new UnsupportedOperationException("Not supported yet.");
         if(!connectedToDatabase)
            throw new UnsupportedOperationException("Not supported yet.");
        return getNumberOfRows();

    }

    @Override
    public int getColumnCount() {
        
        if(!connectedToDatabase)
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
            return metaData.getColumnCount();
        } catch (SQLException ex) {
            //Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return 0;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
         throws IllegalStateException
    {
        if(!connectedToDatabase)
            throw new IllegalStateException( "Not Connected to Database" );
        try{
            rs.absolute(rowIndex +1);
            return rs.getObject(columnIndex+1);
        }catch (SQLException ex) {
            //Logger.getLogger(DbConnect.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return "";
       
    }
    
    public void disconnectFromDatabase()
{
     if ( connectedToDatabase )
    {
// close Statement and Connection
       try
        {
           rs.close();
           st.close();
           con.close();
        } // end try
       catch ( SQLException sqlException )
        {
            sqlException.printStackTrace();
        } // end catch
         finally // update database connection status
        {
               connectedToDatabase = false;
        } // end finally
       } // end if
} // end method disconnectFromDatabase
        
    
    
  public Object[][] getData() throws SQLException{
      Object[][] result = null;
      
          for(int i=0; i< this.getNumberOfRows();i++)
          {
              while(rs.next()){
              result[i][1] = rs.getRowId("room_type");
          }
          
      }
      return result;
  }  
}

