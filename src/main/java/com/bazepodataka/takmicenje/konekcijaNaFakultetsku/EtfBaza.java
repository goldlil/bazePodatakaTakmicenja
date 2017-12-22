/*package com.bazepodataka.takmicenje.konekcijaNaFakultetsku;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DatabaseMetaData;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class EtfBaza {

    //Osnovni podaci za bazu
    //Lokalna mysql baza
    static String username = "root";
    static String password = "";

    //Baza od fakulteta
    static String etf_username = "EP16747";
    static String etf_password = "NXJ7hq3b";

    //Driveri
    static String mySQL_driver = "com.mysql.fabric.jdbc.FabricMySQLDriver";
    static String ojdbc_driver = "oracle.jdbc.driver.OracleDriver";

    //URL
    static String urlMySQL = "jdbc:mysql://localhost:3306/";
    static String urlOracle = "jdbc:oracle:thin:@80.65.65.66:1521:ETFLAB";

    //Atributi

    static Connection konekcija = null;
    static Statement iskaz = null;
    static ResultSet rezultatQuerya = null;
    static DatabaseMetaData metaPodaci = null;


    //Zbog koristenja DataSource, tj. uspostavljanja skupa konekcije potrebno je imati dodatne atribute

    protected int dbConnectionsMinCount = 4;
    protected int dbConnectionsMaxCount = 10;
    protected int dbConnectionMaxWait = -1;     //Vrijeme cekanja za uspostavu konekcije

    protected BasicDataSource dataSource;



    //Metoda open
    //Priprema osobne konekcije i pravi skup konekcija


    //synchronized tag znaci ako 2 niti rade na isto objektu ukoliko jedna nit promijeni taj objekat druga zna za tu promjenu odnosno radi sa promjenjenom vrijednosti varijable
    //Na neki nacin vrsi se sinhronizacija niti nad istim resursom
    public synchronized void open() throws Exception {
        try {
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(mySQL_driver);
            dataSource.setUrl(urlMySQL);
            dataSource.setUsername(username);
            dataSource.setPassword(password);
            dataSource.setMaxIdle(dbConnectionsMinCount);
            dataSource.setMaxTotal(dbConnectionsMaxCount);
            dataSource.setMaxWaitMillis(dbConnectionMaxWait);


        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        konekcija = null;
        try {
            konekcija = dataSource.getConnection();

            System.out.println( "Konektovan");
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        return konekcija;
    }


    public void closeConnection() {
        try {
            dataSource.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
}*/
