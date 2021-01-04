package crud;

import java.util.ArrayList;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class GUI extends JFrame{
	
	DefaultTableModel m;
	
    private JButton btnDelete;
    private JButton btnInsert;
    private JButton btnUpdate;
    private JScrollPane jScrollPane1;
    private JLabel lblDeleteFilmId;
    private JLabel lblDescription;
    private JLabel lblDescription1;
    private JLabel lblLanguageID;
    private JLabel lblRating;
    private JLabel lblReleaseYear;
    private JLabel lblReleaseYear1;
    private JLabel lblSearch;
    private JLabel lblTitle;
    private JLabel lblUpdateFilmId;
    private JLabel lblUpdateTitle;
    private JPanel pnlCreate;
    private JPanel pnlDelete;
    private JPanel pnlUpdate;
    private JTable tblFilms;
    private JTextField tbxDeleteFilmId;
    private JTextField tbxDescription;
    private JTextField tbxDescriptionUpdate;
    private JTextField tbxLanguageId;
    private JTextField tbxRating;
    private JTextField tbxReleaseYear;
    private JTextField tbxReleaseYearUpdate;
    private JTextField tbxTitle;
    private JTextField tbxUpdateFilmId;
    private JTextField tbxUpdateTitle;
    private JTextField txtRead;
	
	public GUI(){
		initComponents();
		populateTable();
	}
	
	private void initComponents() {
		 	
			jScrollPane1 = new JScrollPane();
	        tblFilms = new JTable();
	        txtRead = new JTextField();
	        lblSearch = new JLabel();
	        pnlCreate = new javax.swing.JPanel();
	        tbxRating = new javax.swing.JTextField();
	        lblTitle = new javax.swing.JLabel();
	        tbxTitle = new javax.swing.JTextField();
	        btnInsert = new javax.swing.JButton();
	        tbxLanguageId = new javax.swing.JTextField();
	        lblLanguageID = new javax.swing.JLabel();
	        tbxDescription = new javax.swing.JTextField();
	        tbxReleaseYear = new javax.swing.JTextField();
	        lblDescription = new javax.swing.JLabel();
	        lblReleaseYear = new javax.swing.JLabel();
	        lblRating = new javax.swing.JLabel();
	        pnlDelete = new javax.swing.JPanel();
	        tbxDeleteFilmId = new javax.swing.JTextField();
	        lblDeleteFilmId = new javax.swing.JLabel();
	        btnDelete = new javax.swing.JButton();
	        pnlUpdate = new javax.swing.JPanel();
	        tbxDescriptionUpdate = new javax.swing.JTextField();
	        lblDescription1 = new javax.swing.JLabel();
	        tbxReleaseYearUpdate = new javax.swing.JTextField();
	        lblReleaseYear1 = new javax.swing.JLabel();
	        tbxUpdateTitle = new javax.swing.JTextField();
	        lblUpdateTitle = new javax.swing.JLabel();
	        btnUpdate = new javax.swing.JButton();
	        tbxUpdateFilmId = new javax.swing.JTextField();
	        lblUpdateFilmId = new javax.swing.JLabel();

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	        setTitle("CRUD");
	        setBackground(new java.awt.Color(251, 118, 206));
	        
	        tblFilms.setFont(new Font("Tahoma", 0, 14)); // NOI18N
	        tblFilms.setModel(new DefaultTableModel(
	            new Object [][] {

	            },
	            new String [] {
	                "Film ID", "Title", "Release Year", "Rating", "Description", "Language ID"
	            }
	        ) {
	            Class[] types = new Class [] {
	                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
	            };
	            boolean[] canEdit = new boolean [] {
	                false, false, false, false, false, false
	            };

	            public Class getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        });
		
	}
	
	public void populateTable() {
		m = (DefaultTableModel)tbFilms.getModel();
		m.setRowCount(0);
		 try{
	            ArrayList<Film> films = getFilms();
	            for(Film film : films){        
	                m.addRow(new Object[] 
	                                         {
	                                           film.getFilm_id(),film.getTitle(),
	                                           film.getRelease_year(),film.getRating(), 
	                                           film.getDescription(),film.getLanguage_id() 
	                                         });
	            }
	        }catch(SQLException e){
	            System.out.println("Error");
	        }
	}
	
	//Getting data From database
	public ArrayList<Film> getFilms() throws SQLException{
		Connection connection = null;
        DataBaseHP db = new DataBaseHP();
        Statement statement = null;
        ResultSet resultSet;
        ArrayList<Film> films = null;
        
        try{
            connection = db.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select film_id, title, release_year,rating, description, language_id from film");
            films = new ArrayList<>();
            while(resultSet.next()){
                films.add(new Film(resultSet.getInt("film_id"),
                        resultSet.getString("title"), 
                        resultSet.getInt("release_year"), 
                        resultSet.getString("rating"), 
                        resultSet.getString("description"), 
                        resultSet.getInt("language_id")));
            }
           
            }catch(SQLException e){
                db.errorMessages(e);
            }finally {
            statement.close();
            connection.close();
        }
          return films; 
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		

	}

}
