package com.example.efootball;

public class Partidos {
    String id, equipo, campo, horario, arbitro;

    public Partidos(String id,String equipo,String campo,String horario,String arbitro){
        this.id=id;
        this.equipo=equipo;
        this.campo=campo;
        this.horario=horario;
        this.arbitro=arbitro;
    }

    public String getId(){return id;}

    public void setId(String id){this.id = id;}

    public String getEquipo(){return equipo;}

    public void setEquipo(String equipo){this.equipo = equipo;}

    public String getCampo(){return campo;}

    public void setCampo(String campo){this.campo = campo;}

    public String getHorario(){return horario;}

    public void setHorario(String horario){this.horario = horario;}

    public String getArbitro(){return arbitro;}

    public void setArbitro(String arbitro){this.arbitro = arbitro;}

}
