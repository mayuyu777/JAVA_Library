/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package library;

/**
 *
 * @author natto
 */
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*; 
import java.time.Period;
public class Home extends javax.swing.JFrame {

    /** Creates new form Home */
    public Home() {
        initComponents();
        page1.setVisible(true);
        page3.setVisible(false);
        page6.setVisible(false);
        this.populateBook("",(DefaultTableModel)booktable3.getModel());
    }
    public void populateBook(String book,DefaultTableModel dm){
         
        dm.getDataVector().removeAllElements();
        dm.fireTableDataChanged();
        String sql;
        try {
            conn con = new conn();
            if(book.equals("")){
                sql = "select * from book inner join genre on book.genreid = genre.genreid";
            }else{
                sql = "select * from book inner join genre on book.genreid = genre.genreid where "
                        + "book.bookid = '"+book+"' or book.title = '"+book+"' or book.author = '"+book+"'"
                        + " or genre.genrename = '"+book+"'";
            }
            
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               
                dm.addRow(new Object[]{rs.getInt("book.bookid"),rs.getString("book.title"),
                    rs.getString("book.author"),rs.getString("book.bookisbn"),rs.getString("genre.genrename"),rs.getString("book.bookdesc")});
                
            }
            rs.close();
            st.close();

            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        genre();
    }
    
    public void populateStudent(String student){
        DefaultTableModel mytable = (DefaultTableModel)studenttable.getModel();
        mytable.getDataVector().removeAllElements();
        mytable.fireTableDataChanged();
        String sql;
        try {
            conn con = new conn();
            if(student.equals("")){
                sql = "select * from student";
            }else{
                sql = "select * from student where studentid = '"+student+"' or studentname = '"+student+"'"
                        + " or studentcourse = '"+student+"'";
            }
            
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               
                mytable.addRow(new Object[]{rs.getInt("studentid"),rs.getString("studentname"),
                    rs.getString("studentcourse")});
                
            }
            rs.close();
            st.close();

            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void clearBook(){
        bookid3.setText("");
        title3.setText("");
        author3.setText("");
        isbn3.setText("");
        desc.setText("");
       
    }
    public void clearIssue(){
        bookid5.setText("");
        title5.setText("");
        author5.setText("");
        isbn5.setText("");
        genre5.setText("");
        studentid.setText("");
        studentname.setText("");
        course.setText("");
    }
    public void genre(){
            genre3.removeAllItems();
            try {
                conn con = new conn();
           
               String sql = "select * from genre";
            
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               genre3.addItem(rs.getString("genrename"));
                
            }
            rs.close();
            st.close();

            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void populateBorrow(String borrow){
        DefaultTableModel mytable = (DefaultTableModel)borrowtable.getModel();
        mytable.getDataVector().removeAllElements();
        mytable.fireTableDataChanged();
        String sql;
        try {
            conn con = new conn();
            if(borrow.equals("")){
                sql = "select * from borrowbook inner join book on borrowbook.bookid = book.bookid inner join student on borrowbook.studentid = student.studentid ";
            }else{
                sql = "select * from borrowbook inner join book on borrowbook.bookid = book.bookid inner join student on borrowbook.studentid = student.studentid where  book.bookid = '"+borrow+"'"
                        + " or borrowbook.studentid = '"+borrow+"' or book.title = '"+borrow+"' or book.author = '"+borrow+"' or student.studentname = '"+borrow+"' ";
            }
            
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
               
                mytable.addRow(new Object[]{rs.getInt("borrowbook.bookid"), rs.getString("book.title"),rs.getInt("borrowbook.studentid"),
                    rs.getString("student.studentname"),rs.getString("borrowbook.date_start")});
                
            }
            rs.close();
            st.close();

            con.connect.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void clearBorrow(){
         rbookid.setText("");
          rtitle.setText("");
         rstudentid.setText("");
         rstudentname.setText("");
          rdate.setText("");
          rbalance.setText("");
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tab1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tab2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tab3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tab4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        page1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        booktable3 = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        bookid3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        title3 = new javax.swing.JTextField();
        author3 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        isbn3 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        genre3 = new javax.swing.JComboBox<>();
        Genre3 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        searchbtn = new javax.swing.JButton();
        page3 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        booktable4 = new javax.swing.JTable();
        search1 = new javax.swing.JTextField();
        searchbtn1 = new javax.swing.JButton();
        issue = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        title5 = new javax.swing.JLabel();
        bookid5 = new javax.swing.JLabel();
        author5 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        isbn5 = new javax.swing.JLabel();
        Genre4 = new javax.swing.JLabel();
        genre5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        studentname = new javax.swing.JTextField();
        studentid = new javax.swing.JTextField();
        course = new javax.swing.JTextField();
        issuebtn = new javax.swing.JButton();
        issuebtn1 = new javax.swing.JButton();
        issuemessage = new javax.swing.JLabel();
        studentsearch = new javax.swing.JTextField();
        searchbtn2 = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        studenttable = new javax.swing.JTable();
        page6 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        borrowtable = new javax.swing.JTable();
        search2 = new javax.swing.JTextField();
        searchbtn3 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        rbookid = new javax.swing.JTextField();
        rtitle = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rstudentid = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rstudentname = new javax.swing.JTextField();
        rdate = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbalance = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        resetbtn = new javax.swing.JButton();
        returnedbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 153, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 51));

        tab1.setBackground(new java.awt.Color(51, 204, 0));
        tab1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab1MouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Book Management");

        org.jdesktop.layout.GroupLayout tab1Layout = new org.jdesktop.layout.GroupLayout(tab1);
        tab1.setLayout(tab1Layout);
        tab1Layout.setHorizontalGroup(
            tab1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab1Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jLabel1)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        tab1Layout.setVerticalGroup(
            tab1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel1)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab2.setBackground(new java.awt.Color(51, 102, 0));
        tab2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab2MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Issue Book");

        org.jdesktop.layout.GroupLayout tab2Layout = new org.jdesktop.layout.GroupLayout(tab2);
        tab2.setLayout(tab2Layout);
        tab2Layout.setHorizontalGroup(
            tab2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab2Layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabel2)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab2Layout.setVerticalGroup(
            tab2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, tab2Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jLabel2)
                .addContainerGap())
        );

        tab3.setBackground(new java.awt.Color(51, 102, 0));
        tab3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab3MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Return Book");

        org.jdesktop.layout.GroupLayout tab3Layout = new org.jdesktop.layout.GroupLayout(tab3);
        tab3.setLayout(tab3Layout);
        tab3Layout.setHorizontalGroup(
            tab3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab3Layout.createSequentialGroup()
                .add(20, 20, 20)
                .add(jLabel3)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab3Layout.setVerticalGroup(
            tab3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab3Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel3)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab4.setBackground(new java.awt.Color(51, 102, 0));
        tab4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tab4MouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Logout");

        org.jdesktop.layout.GroupLayout tab4Layout = new org.jdesktop.layout.GroupLayout(tab4);
        tab4.setLayout(tab4Layout);
        tab4Layout.setHorizontalGroup(
            tab4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab4Layout.createSequentialGroup()
                .add(22, 22, 22)
                .add(jLabel4)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tab4Layout.setVerticalGroup(
            tab4Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tab4Layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel4)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, tab1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(tab2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(tab3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(tab4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(85, 85, 85)
                .add(tab1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tab2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tab3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(tab4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        page1.setBackground(new java.awt.Color(161, 201, 161));

        booktable3.setBackground(new java.awt.Color(204, 204, 255));
        booktable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Title", "Author", "ISBN", "Genre", "Desc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        booktable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booktable3MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(booktable3);
        if (booktable3.getColumnModel().getColumnCount() > 0) {
            booktable3.getColumnModel().getColumn(4).setResizable(false);
            booktable3.getColumnModel().getColumn(5).setResizable(false);
            booktable3.getColumnModel().getColumn(5).setHeaderValue("Desc");
        }

        jLabel20.setText("ID:");

        jLabel21.setText("Title:");

        jLabel22.setText("Author:");

        jLabel23.setText("ISBN:");

        Genre3.setText("Genre:");

        jLabel24.setText("Description");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane8.setViewportView(desc);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setText("Reset");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Create");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        searchbtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchbtn.setText("Enter");
        searchbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbtnMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout page1Layout = new org.jdesktop.layout.GroupLayout(page1);
        page1.setLayout(page1Layout);
        page1Layout.setHorizontalGroup(
            page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page1Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(page1Layout.createSequentialGroup()
                        .add(search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchbtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(page1Layout.createSequentialGroup()
                        .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 441, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(page1Layout.createSequentialGroup()
                                .add(jButton2)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton3)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(jButton4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 71, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(page1Layout.createSequentialGroup()
                                .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(page1Layout.createSequentialGroup()
                                        .add(jLabel22)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(author3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(page1Layout.createSequentialGroup()
                                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                            .add(jLabel20)
                                            .add(jLabel21))
                                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(page1Layout.createSequentialGroup()
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(title3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                            .add(page1Layout.createSequentialGroup()
                                                .add(1, 1, 1)
                                                .add(bookid3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 70, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                    .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                        .add(jLabel24)
                                        .add(page1Layout.createSequentialGroup()
                                            .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                                .add(jLabel23)
                                                .add(Genre3))
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                            .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                                .add(genre3, 0, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .add(isbn3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 250, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        page1Layout.setVerticalGroup(
            page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page1Layout.createSequentialGroup()
                .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(page1Layout.createSequentialGroup()
                        .add(32, 32, 32)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(searchbtn)
                            .add(search, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 312, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(page1Layout.createSequentialGroup()
                        .add(61, 61, 61)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel20)
                            .add(bookid3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 14, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel21, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(title3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel22, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(author3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel23, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(isbn3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(genre3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Genre3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jButton1))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel24)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(jScrollPane8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(27, 27, 27)
                        .add(page1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButton2)
                            .add(jButton3)
                            .add(jButton4))))
                .add(49, 49, 49))
        );

        page3.setBackground(new java.awt.Color(161, 201, 161));

        booktable4.setBackground(new java.awt.Color(204, 204, 255));
        booktable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Title", "Author", "ISBN", "Genre", "Desc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        booktable4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booktable4MouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(booktable4);
        if (booktable4.getColumnModel().getColumnCount() > 0) {
            booktable4.getColumnModel().getColumn(3).setHeaderValue("ISBN");
            booktable4.getColumnModel().getColumn(4).setResizable(false);
            booktable4.getColumnModel().getColumn(4).setHeaderValue("Genre");
            booktable4.getColumnModel().getColumn(5).setResizable(false);
            booktable4.getColumnModel().getColumn(5).setHeaderValue("Desc");
        }

        searchbtn1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchbtn1.setText("Enter");
        searchbtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbtn1MouseClicked(evt);
            }
        });
        searchbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtn1ActionPerformed(evt);
            }
        });

        issue.setBackground(new java.awt.Color(161, 201, 161));

        jLabel25.setText("ID:");

        jLabel26.setText("Title:");

        title5.setBackground(new java.awt.Color(255, 255, 255));
        title5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        title5.setOpaque(true);

        bookid5.setBackground(new java.awt.Color(255, 255, 255));
        bookid5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        bookid5.setOpaque(true);

        author5.setBackground(new java.awt.Color(255, 255, 255));
        author5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        author5.setOpaque(true);

        jLabel27.setText("Author:");

        jLabel28.setText("ISBN:");

        isbn5.setBackground(new java.awt.Color(255, 255, 255));
        isbn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        isbn5.setOpaque(true);

        Genre4.setText("Genre:");

        genre5.setBackground(new java.awt.Color(255, 255, 255));
        genre5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        genre5.setOpaque(true);

        jLabel29.setText("Student ID:");

        jLabel30.setText("Student Name:");

        jLabel31.setText("Course:");

        issuebtn.setText("Issue");
        issuebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                issuebtnMouseClicked(evt);
            }
        });

        issuebtn1.setText("Reset");
        issuebtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issuebtn1ActionPerformed(evt);
            }
        });

        issuemessage.setForeground(new java.awt.Color(255, 0, 51));
        issuemessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        org.jdesktop.layout.GroupLayout issueLayout = new org.jdesktop.layout.GroupLayout(issue);
        issue.setLayout(issueLayout);
        issueLayout.setHorizontalGroup(
            issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(issueLayout.createSequentialGroup()
                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(issueLayout.createSequentialGroup()
                        .add(52, 52, 52)
                        .add(issuemessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 162, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(issueLayout.createSequentialGroup()
                        .add(80, 80, 80)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(issueLayout.createSequentialGroup()
                                .add(13, 13, 13)
                                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(issueLayout.createSequentialGroup()
                                        .add(jLabel26)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(title5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(issueLayout.createSequentialGroup()
                                        .add(8, 8, 8)
                                        .add(jLabel25)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(bookid5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, issueLayout.createSequentialGroup()
                                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                    .add(jLabel28)
                                    .add(jLabel27)
                                    .add(Genre4))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(author5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(isbn5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(genre5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jLabel29)
                                .add(jLabel30))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel31))
                        .add(18, 18, 18)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(studentname)
                            .add(studentid)
                            .add(course, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 116, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(issuebtn1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 128, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(issuebtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 129, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        issueLayout.setVerticalGroup(
            issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(issueLayout.createSequentialGroup()
                .add(7, 7, 7)
                .add(issuemessage, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(issueLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(bookid5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel25))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel26)
                            .add(title5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel27)
                            .add(author5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel28)
                            .add(isbn5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 22, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(issueLayout.createSequentialGroup()
                        .add(15, 15, 15)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel29)
                            .add(studentid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(9, 9, 9)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel30)
                            .add(studentname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(12, 12, 12)
                        .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(course, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel31)))
                    .add(issueLayout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(issuebtn1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(issuebtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 37, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(issueLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(Genre4)
                    .add(genre5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 24, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        searchbtn2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchbtn2.setText("Enter");
        searchbtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbtn2MouseClicked(evt);
            }
        });

        studenttable.setBackground(new java.awt.Color(204, 204, 255));
        studenttable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "StudentID", "Name", "Course"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        studenttable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studenttableMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(studenttable);

        org.jdesktop.layout.GroupLayout page3Layout = new org.jdesktop.layout.GroupLayout(page3);
        page3.setLayout(page3Layout);
        page3Layout.setHorizontalGroup(
            page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, page3Layout.createSequentialGroup()
                .add(21, 21, 21)
                .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(issue, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(page3Layout.createSequentialGroup()
                        .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, page3Layout.createSequentialGroup()
                                .add(search1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 117, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(searchbtn1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 93, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 396, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 45, Short.MAX_VALUE)
                        .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, page3Layout.createSequentialGroup()
                                .add(studentsearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 123, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(searchbtn2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 96, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 256, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(31, 31, 31))
        );
        page3Layout.setVerticalGroup(
            page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page3Layout.createSequentialGroup()
                .add(48, 48, 48)
                .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, page3Layout.createSequentialGroup()
                        .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(searchbtn2)
                            .add(studentsearch, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jScrollPane10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .add(page3Layout.createSequentialGroup()
                        .add(page3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(searchbtn1)
                            .add(search1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(jScrollPane9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 148, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(issue, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        page6.setBackground(new java.awt.Color(161, 201, 161));

        borrowtable.setBackground(new java.awt.Color(204, 204, 255));
        borrowtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BookID", "Title", "StudentID", "Student Name", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        borrowtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowtableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(borrowtable);
        if (borrowtable.getColumnModel().getColumnCount() > 0) {
            borrowtable.getColumnModel().getColumn(4).setResizable(false);
        }

        searchbtn3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchbtn3.setText("Enter");
        searchbtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchbtn3MouseClicked(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("BookID:");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Title:");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("StudentID:");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Student Name:");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Date Borrowed:");

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Balance:");

        resetbtn.setText("Reset");
        resetbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetbtnMouseClicked(evt);
            }
        });

        returnedbtn.setText("Returned");
        returnedbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnedbtnMouseClicked(evt);
            }
        });

        org.jdesktop.layout.GroupLayout page6Layout = new org.jdesktop.layout.GroupLayout(page6);
        page6.setLayout(page6Layout);
        page6Layout.setHorizontalGroup(
            page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page6Layout.createSequentialGroup()
                .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, page6Layout.createSequentialGroup()
                        .addContainerGap()
                        .add(search2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(searchbtn3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 104, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(page6Layout.createSequentialGroup()
                        .add(19, 19, 19)
                        .add(jScrollPane11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 400, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(32, 32, 32)
                .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(page6Layout.createSequentialGroup()
                        .add(62, 62, 62)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(page6Layout.createSequentialGroup()
                                .add(jLabel6, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(rtitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(page6Layout.createSequentialGroup()
                                .add(jLabel5, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 48, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(rbookid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(page6Layout.createSequentialGroup()
                        .add(25, 25, 25)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(page6Layout.createSequentialGroup()
                                .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(rbalance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(page6Layout.createSequentialGroup()
                                .add(jLabel8, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(rstudentname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(page6Layout.createSequentialGroup()
                                .add(jLabel7, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 85, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(rstudentid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                    .add(page6Layout.createSequentialGroup()
                        .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 110, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(rdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 120, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(page6Layout.createSequentialGroup()
                        .add(resetbtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 124, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(returnedbtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 118, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        page6Layout.setVerticalGroup(
            page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page6Layout.createSequentialGroup()
                .add(41, 41, 41)
                .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(searchbtn3)
                    .add(search2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jScrollPane11, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 289, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(page6Layout.createSequentialGroup()
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rbookid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rtitle, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel7, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rstudentid, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel8, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rstudentname, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel9, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rdate, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel10, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(rbalance, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 26, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(30, 30, 30)
                        .add(page6Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(resetbtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(returnedbtn, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 36, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, page6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(page1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(page3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(page6, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(page1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(page3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void tab1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab1MouseClicked
        page1.setVisible(true);
        page3.setVisible(false);
        page6.setVisible(false);
        tab1.setBackground(new java.awt.Color(51,204,0));
        tab2.setBackground(new java.awt.Color(51,102,0));
        tab2.setBackground(new java.awt.Color(51,102,0));
        populateBook(search.getText(),(DefaultTableModel)booktable3.getModel());
    }//GEN-LAST:event_tab1MouseClicked

    private void tab2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab2MouseClicked
        page1.setVisible(false);
        page3.setVisible(true);
        page6.setVisible(false);
        tab2.setBackground(new java.awt.Color(51,204,0));
        tab1.setBackground(new java.awt.Color(51,102,0));
        tab3.setBackground(new java.awt.Color(51,102,0));
        populateBook("",(DefaultTableModel)booktable4.getModel());
        populateStudent("");
    }//GEN-LAST:event_tab2MouseClicked

    private void tab3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab3MouseClicked
       page1.setVisible(false);
        page3.setVisible(false);
        page6.setVisible(true);
        tab3.setBackground(new java.awt.Color(51,204,0));
        tab2.setBackground(new java.awt.Color(51,102,0));
        tab1.setBackground(new java.awt.Color(51,102,0));
        populateBorrow("");
    }//GEN-LAST:event_tab3MouseClicked

    private void tab4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tab4MouseClicked
        new Login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_tab4MouseClicked

    private void searchbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtnMouseClicked
        populateBook(search.getText(),(DefaultTableModel)booktable3.getModel());
    }//GEN-LAST:event_searchbtnMouseClicked

    
    private void booktable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booktable3MouseClicked

        clearBook();
        DefaultTableModel mytable = (DefaultTableModel)booktable3.getModel();
        int row = booktable3.getSelectedRow();
         bookid3.setText(mytable.getValueAt(row,0).toString());
         title3.setText(mytable.getValueAt(row,1).toString());
         author3.setText(mytable.getValueAt(row,2).toString());
         isbn3.setText(mytable.getValueAt(row,3).toString());
         genre3.setSelectedItem(mytable.getValueAt(row,4).toString());
         desc.setText(mytable.getValueAt(row,5).toString());
    }//GEN-LAST:event_booktable3MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        clearBook();
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        try{
            conn con = new conn();
            String sql = "Insert into book (title,author,bookisbn,bookdesc,genreid) "
                    + "values('"+title3.getText()+"','"+author3.getText()+"','"+isbn3.getText()+"',"
                    + "'"+desc.getText()+"',(Select genreid from genre where genrename='"+genre3.getSelectedItem()+"'))";
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            
            st.close();
            con.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        populateBook("",(DefaultTableModel)booktable3.getModel());
        clearBook();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        try{
            conn con = new conn();
            String sql = "Update book set"
                    + " title = '"+title3.getText()+"',author = '"+author3.getText()+"',bookisbn = '"+isbn3.getText()+"',"
                    + " bookdesc = '"+desc.getText()+"',genreid = (Select genreid from genre where genrename='"+genre3.getSelectedItem()+"') where bookid = '"+bookid3.getText()+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            
            st.close();
            con.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        populateBook("",(DefaultTableModel)booktable3.getModel());
        clearBook();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
       try{
            conn con = new conn();
            String sql = "Delete from book where bookid = '"+bookid3.getText()+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            
            st.close();
            con.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        populateBook("",(DefaultTableModel)booktable3.getModel());
        clearBook();
    }//GEN-LAST:event_jButton4MouseClicked

    private void booktable4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booktable4MouseClicked
       DefaultTableModel mytable = (DefaultTableModel)booktable4.getModel();
        int row = booktable4.getSelectedRow();
         bookid5.setText(mytable.getValueAt(row,0).toString());
         title5.setText(mytable.getValueAt(row,1).toString());
         author5.setText(mytable.getValueAt(row,2).toString());
         isbn5.setText(mytable.getValueAt(row,3).toString());
         genre5.setText(mytable.getValueAt(row,4).toString());
         
    }//GEN-LAST:event_booktable4MouseClicked

    private void searchbtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtn1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbtn1MouseClicked

    private void searchbtn2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtn2MouseClicked
        populateStudent(studentsearch.getText());
    }//GEN-LAST:event_searchbtn2MouseClicked

    private void studenttableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studenttableMouseClicked
       DefaultTableModel mytable = (DefaultTableModel)studenttable.getModel();
        int row = studenttable.getSelectedRow();
         studentid.setText(mytable.getValueAt(row,0).toString());
         studentname.setText(mytable.getValueAt(row,1).toString());
         course.setText(mytable.getValueAt(row,2).toString());
    }//GEN-LAST:event_studenttableMouseClicked

    private void searchbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtn1ActionPerformed
        populateBook(search1.getText(),(DefaultTableModel)booktable4.getModel());
    }//GEN-LAST:event_searchbtn1ActionPerformed

    private void issuebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_issuebtnMouseClicked
       boolean flag = false;
       LocalDate currentdate = LocalDate.now();
        try{
            conn con = new conn();
            String sql = "Select count(*) as count from borrowbook where bookid = '"+bookid5.getText()+"'";
            PreparedStatement st = con.connect.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                if(rs.getInt("count")==0){
                    flag  = true;
                }
            }
            
            if(flag){
                
                sql = "Select count(*) as count from student where studentid = '"+studentid.getText()+"'";
                PreparedStatement st1 = con.connect.prepareStatement(sql);
                ResultSet rs1 = st1.executeQuery();
                while(rs1.next()){
                if(rs1.getInt("count")==0){
                    
                    
                    sql = "Insert into student (studentid,studentname,studentcourse) values ('"+studentid.getText()+"','"+studentname.getText()+"','"+course.getText()+"')";
                    PreparedStatement st2 = con.connect.prepareStatement(sql);
                    st2.executeUpdate();
                }
                }
                
                sql = "Insert into borrowbook (bookid,studentid,date_start) values"
                        + "('"+bookid5.getText()+"','"+studentid.getText()+"','"+currentdate.getYear()+'-'
                        +currentdate.getMonthValue()+'-'+currentdate.getDayOfMonth()+"')";
                PreparedStatement st3 = con.connect.prepareStatement(sql);
                st3.executeUpdate();
                
                issuemessage.setText("Book is issued successfully!");
                
            }else{
                issuemessage.setText("Book is already borrowed.");
            }
            
            st.close();
            con.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        populateBook("",(DefaultTableModel)booktable4.getModel());
        populateStudent("");
        clearIssue();
       
    }//GEN-LAST:event_issuebtnMouseClicked

    private void issuebtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issuebtn1ActionPerformed
        clearIssue();
    }//GEN-LAST:event_issuebtn1ActionPerformed

    private void borrowtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowtableMouseClicked
        DefaultTableModel mytable = (DefaultTableModel)borrowtable.getModel();
        int row = borrowtable.getSelectedRow();
         rbookid.setText(mytable.getValueAt(row,0).toString());
          rtitle.setText(mytable.getValueAt(row,1).toString());
         rstudentid.setText(mytable.getValueAt(row,2).toString());
         rstudentname.setText(mytable.getValueAt(row,3).toString());
          rdate.setText(mytable.getValueAt(row,4).toString());
          String[] mydate = rdate.getText().split("-");
          LocalDate currentdate = LocalDate.now();
        LocalDate startdate = LocalDate.of( Integer.parseInt(mydate[0]),Integer.parseInt(mydate[1]),Integer.parseInt(mydate[2]));
     
        Period p = Period.between(startdate,currentdate);
        int totaldays = ((p.getYears()*12)*30) + (p.getMonths()*30) + p.getDays();
        float balance = 0;
        
        if(totaldays>14){
            balance = (totaldays-14) * 10;
        }
        rbalance.setText(String.valueOf(balance));
        System.out.println(totaldays);
        System.out.println("Years (Difference) = "+p.getYears());
        System.out.println("Month (Difference) = "+p.getMonths());
        System.out.println("Days (Difference) = "+p.getDays());
         
          
       
    }//GEN-LAST:event_borrowtableMouseClicked

    private void searchbtn3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchbtn3MouseClicked
        populateBorrow(search2.getText());
    }//GEN-LAST:event_searchbtn3MouseClicked

    private void resetbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetbtnMouseClicked
       clearBorrow();
    }//GEN-LAST:event_resetbtnMouseClicked

    private void returnedbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnedbtnMouseClicked
         try{
            conn con = new conn();
            String sql = "Delete from borrowbook where bookid = '"+rbookid.getText()+"' ";
                   
            PreparedStatement st = con.connect.prepareStatement(sql);
            st.executeUpdate();
            
            st.close();
            con.connect.close();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
        populateBorrow("");
        clearBorrow();
    }//GEN-LAST:event_returnedbtnMouseClicked
    
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Genre3;
    private javax.swing.JLabel Genre4;
    private javax.swing.JTextField author3;
    private javax.swing.JLabel author5;
    private javax.swing.JLabel bookid3;
    private javax.swing.JLabel bookid5;
    private javax.swing.JTable booktable3;
    private javax.swing.JTable booktable4;
    private javax.swing.JTable borrowtable;
    private javax.swing.JTextField course;
    private javax.swing.JTextArea desc;
    private javax.swing.JComboBox<String> genre3;
    private javax.swing.JLabel genre5;
    private javax.swing.JTextField isbn3;
    private javax.swing.JLabel isbn5;
    private javax.swing.JPanel issue;
    private javax.swing.JButton issuebtn;
    private javax.swing.JButton issuebtn1;
    private javax.swing.JLabel issuemessage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JPanel page1;
    private javax.swing.JPanel page3;
    private javax.swing.JPanel page6;
    private javax.swing.JTextField rbalance;
    private javax.swing.JTextField rbookid;
    private javax.swing.JTextField rdate;
    private javax.swing.JButton resetbtn;
    private javax.swing.JButton returnedbtn;
    private javax.swing.JTextField rstudentid;
    private javax.swing.JTextField rstudentname;
    private javax.swing.JTextField rtitle;
    private javax.swing.JTextField search;
    private javax.swing.JTextField search1;
    private javax.swing.JTextField search2;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton searchbtn1;
    private javax.swing.JButton searchbtn2;
    private javax.swing.JButton searchbtn3;
    private javax.swing.JTextField studentid;
    private javax.swing.JTextField studentname;
    private javax.swing.JTextField studentsearch;
    private javax.swing.JTable studenttable;
    private javax.swing.JPanel tab1;
    private javax.swing.JPanel tab2;
    private javax.swing.JPanel tab3;
    private javax.swing.JPanel tab4;
    private javax.swing.JTextField title3;
    private javax.swing.JLabel title5;
    // End of variables declaration//GEN-END:variables

}
