
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class GUI extends javax.swing.JFrame {

    DefaultTableModel m;
    
    public GUI() {
        initComponents();
        table();
    }
    
    public void table(){    
        m = (DefaultTableModel)tblFilms.getModel();
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
                      
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
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
        txtRead = new javax.swing.JTextField();
        lblSearch = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFilms = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMultipleDelete = new javax.swing.JTextField();
        btnMultipleDelete = new javax.swing.JButton();
        pnlDelete = new javax.swing.JPanel();
        tbxDeleteFilmId = new javax.swing.JTextField();
        lblDeleteFilmId = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD");
        setBackground(new java.awt.Color(251, 118, 206));
        setResizable(false);

        pnlMain.setBackground(new java.awt.Color(102, 255, 204));
        pnlMain.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        pnlCreate.setBackground(new java.awt.Color(102, 255, 204));
        pnlCreate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CREATE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tbxRating.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTitle.setText("Title:");

        tbxTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnInsert.setBackground(new java.awt.Color(255, 255, 255));
        btnInsert.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnInsert.setText("Save");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        lblLanguageID.setText("Language ID:");

        tbxDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        tbxReleaseYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblDescription.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescription.setText("Description: ");

        lblReleaseYear.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblReleaseYear.setText("Release Year:");

        lblRating.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblRating.setText("Rating: ");

        javax.swing.GroupLayout pnlCreateLayout = new javax.swing.GroupLayout(pnlCreate);
        pnlCreate.setLayout(pnlCreateLayout);
        pnlCreateLayout.setHorizontalGroup(
            pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreateLayout.createSequentialGroup()
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCreateLayout.createSequentialGroup()
                        .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRating)
                            .addComponent(lblReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle)
                            .addComponent(lblDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCreateLayout.createSequentialGroup()
                                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tbxReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxRating, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tbxTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreateLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlCreateLayout.createSequentialGroup()
                        .addComponent(lblLanguageID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tbxLanguageId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 10, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnInsert)
                .addContainerGap())
        );
        pnlCreateLayout.setVerticalGroup(
            pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreateLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRating)
                    .addComponent(tbxRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxReleaseYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReleaseYear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDescription)
                    .addComponent(tbxDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(pnlCreateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxLanguageId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLanguageID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInsert)
                .addGap(7, 7, 7))
        );

        pnlUpdate.setBackground(new java.awt.Color(102, 255, 204));
        pnlUpdate.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "UPDATE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tbxDescriptionUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblDescription1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDescription1.setText("Description: ");

        tbxReleaseYearUpdate.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblReleaseYear1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblReleaseYear1.setText("Release Year:");

        tbxUpdateTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblUpdateTitle.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUpdateTitle.setText("Title: ");

        btnUpdate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        lblUpdateFilmId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblUpdateFilmId.setText("Find the Film ID:");

        javax.swing.GroupLayout pnlUpdateLayout = new javax.swing.GroupLayout(pnlUpdate);
        pnlUpdate.setLayout(pnlUpdateLayout);
        pnlUpdateLayout.setHorizontalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdateLayout.createSequentialGroup()
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlUpdateLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate))
                    .addGroup(pnlUpdateLayout.createSequentialGroup()
                        .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlUpdateLayout.createSequentialGroup()
                                .addComponent(lblUpdateFilmId)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdateLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUpdateTitle, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblReleaseYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDescription1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tbxUpdateFilmId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxUpdateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxReleaseYearUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tbxDescriptionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        pnlUpdateLayout.setVerticalGroup(
            pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateFilmId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdateFilmId))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxUpdateTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUpdateTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxReleaseYearUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblReleaseYear1))
                .addGap(18, 18, 18)
                .addGroup(pnlUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxDescriptionUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDescription1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUpdate)
                .addGap(15, 15, 15))
        );

        txtRead.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtRead.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtReadKeyReleased(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSearch.setText("Read:");

        tblFilms.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblFilms.setModel(new javax.swing.table.DefaultTableModel(
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
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFilms);
        if (tblFilms.getColumnModel().getColumnCount() > 0) {
            tblFilms.getColumnModel().getColumn(0).setResizable(false);
            tblFilms.getColumnModel().getColumn(0).setPreferredWidth(1);
            tblFilms.getColumnModel().getColumn(1).setResizable(false);
            tblFilms.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblFilms.getColumnModel().getColumn(2).setResizable(false);
            tblFilms.getColumnModel().getColumn(2).setPreferredWidth(20);
            tblFilms.getColumnModel().getColumn(3).setResizable(false);
            tblFilms.getColumnModel().getColumn(3).setPreferredWidth(10);
            tblFilms.getColumnModel().getColumn(4).setResizable(false);
            tblFilms.getColumnModel().getColumn(4).setPreferredWidth(200);
            tblFilms.getColumnModel().getColumn(5).setResizable(false);
            tblFilms.getColumnModel().getColumn(5).setPreferredWidth(10);
        }

        jPanel1.setBackground(new java.awt.Color(102, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "blablab", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("blabla");

        btnMultipleDelete.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnMultipleDelete.setText("action");
        btnMultipleDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultipleDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(txtMultipleDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnMultipleDelete)
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMultipleDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnMultipleDelete)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pnlDelete.setBackground(new java.awt.Color(102, 255, 204));
        pnlDelete.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DELETE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        tbxDeleteFilmId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblDeleteFilmId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblDeleteFilmId.setText("Film ID:");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDeleteLayout = new javax.swing.GroupLayout(pnlDelete);
        pnlDelete.setLayout(pnlDeleteLayout);
        pnlDeleteLayout.setHorizontalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDeleteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDelete)
                    .addGroup(pnlDeleteLayout.createSequentialGroup()
                        .addComponent(lblDeleteFilmId)
                        .addGap(18, 18, 18)
                        .addComponent(tbxDeleteFilmId, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        pnlDeleteLayout.setVerticalGroup(
            pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDeleteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDeleteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tbxDeleteFilmId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDeleteFilmId))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDelete)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(lblSearch)
                            .addGap(26, 26, 26)
                            .addComponent(txtRead, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlMainLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(pnlCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(61, 61, 61)
                            .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(58, 58, 58)
                            .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(pnlUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addComponent(pnlDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(161, 161, 161))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlMain, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }                       

    private void txtReadKeyReleased(java.awt.event.KeyEvent evt) {                                    
        String readKey = txtRead.getText();
        TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<>(m);
        tblFilms.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter(readKey));
    }                                   

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Connection connection = null;
        DataBaseHP db = new DataBaseHP();
        PreparedStatement statement = null;
        try {
            connection = db.getConnection();
            statement = connection.prepareStatement("insert into film(title,rating,release_year,description,language_id) values(?,?,?,?,?)");
            statement.setString(1,tbxTitle.getText());
            statement.setString(2,tbxRating.getText());
            statement.setInt(3,Integer.valueOf(tbxReleaseYear.getText()));
            statement.setString(4,tbxDescription.getText());
            statement.setInt(5,Integer.valueOf(tbxLanguageId.getText()));
            statement.executeUpdate();
            table();
            tbxTitle.setText("");
            tbxRating.setText("");
            tbxReleaseYear.setText("");
            tbxDescription.setText("");
            tbxLanguageId.setText("");
        } catch (SQLException e) {
            db.errorMessages(e);
        }finally{
            try{   
            statement.close();
            connection.close();
            }catch(SQLException ex){ }    
            }
    }                                         

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                          
        
        Connection connection = null;
        DataBaseHP db = new DataBaseHP();
        PreparedStatement statement = null;
        
        try{
            connection = db.getConnection();
            statement = connection.prepareStatement("delete from film where film_id = ?");
            statement.setInt(1,Integer.valueOf(tbxDeleteFilmId.getText()));
            statement.executeUpdate();
            table();
            tbxDeleteFilmId.setText("");
        }catch(SQLException e){
            db.errorMessages(e);
        }finally{
             try{   
                statement.close();
                connection.close();
            }catch(SQLException ex){ }  
        }
    }                                         

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Connection connection = null;
        DataBaseHP db = new DataBaseHP();
        PreparedStatement statement = null;
        try{
             connection = db.getConnection(); 
             statement = connection.prepareStatement("update film set title=?, release_year=?,description=? where film_id=?");
             statement.setString(1,tbxUpdateTitle.getText());
             statement.setInt(2,Integer.valueOf(tbxReleaseYearUpdate.getText()));
             statement.setString(3,tbxDescriptionUpdate.getText());
             statement.setInt(4,Integer.valueOf(tbxUpdateFilmId.getText()));   
             statement.executeUpdate();
             table();
             tbxUpdateFilmId.setText("");
             tbxDescriptionUpdate.setText("");
             tbxReleaseYearUpdate.setText("");
             tbxUpdateTitle.setText("");
        }catch(SQLException e){
            db.errorMessages(e);
        }finally{
             try{   
            statement.close();
             connection.close();
            }catch(SQLException ex){ }  
        }
    }                                         

    private void btnMultipleDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        Connection connection = null;
        DataBaseHP db = new DataBaseHP();
        PreparedStatement statement = null;
        try{
        connection = db.getConnection(); 
           int[] row = tblFilms.getSelectedRows();
           for(int rows: row){
               statement = connection.prepareStatement("delete from film where film_id = ?");  
               statement.setInt(1,(int)(tblFilms.getValueAt(rows, 0)));
               statement.executeUpdate();
               table();
           }
        }catch(SQLException e){
            db.errorMessages(e);
        }finally{
             try{   
            statement.close();
             connection.close();
            }catch(SQLException ex){ }  
        }
    }                                                 

    public static void main(String args[]) {
        new GUI().setVisible(true);
    }
                  
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnMultipleDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDeleteFilmId;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblDescription1;
    private javax.swing.JLabel lblLanguageID;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblReleaseYear;
    private javax.swing.JLabel lblReleaseYear1;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUpdateFilmId;
    private javax.swing.JLabel lblUpdateTitle;
    private javax.swing.JPanel pnlCreate;
    private javax.swing.JPanel pnlDelete;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlUpdate;
    private javax.swing.JTable tblFilms;
    private javax.swing.JTextField tbxDeleteFilmId;
    private javax.swing.JTextField tbxDescription;
    private javax.swing.JTextField tbxDescriptionUpdate;
    private javax.swing.JTextField tbxLanguageId;
    private javax.swing.JTextField tbxRating;
    private javax.swing.JTextField tbxReleaseYear;
    private javax.swing.JTextField tbxReleaseYearUpdate;
    private javax.swing.JTextField tbxTitle;
    private javax.swing.JTextField tbxUpdateFilmId;
    private javax.swing.JTextField tbxUpdateTitle;
    private javax.swing.JTextField txtMultipleDelete;
    private javax.swing.JTextField txtRead;
               
}
