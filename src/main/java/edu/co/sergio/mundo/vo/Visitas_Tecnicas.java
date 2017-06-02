package edu.co.sergio.mundo.vo;

import java.sql.Date;

public class Visitas_Tecnicas {

java.sql.Date	fecha;    
String tecnico;
int id_colmena ;

 

    public String getTecnico() {
        return tecnico;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setTecnico(String tecnico) {
        this.tecnico = tecnico;
    }

    public int getId_colmena() {
        return id_colmena;
    }

    public void setId_colmena(int id_colmena) {
        this.id_colmena = id_colmena;
    }


    



   

	
	

}
