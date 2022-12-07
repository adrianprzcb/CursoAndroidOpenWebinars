package com.example.listviewpersonalizado;

public class Averia {
        private String titulo;
        private String modeloCoche;
        private String urlFoto;
        private int numeroPresupuesto;

    public Averia(String titulo, String modeloCoche, String urlFoto, int numeroPresupuesto) {
        this.titulo = titulo;
        this.modeloCoche = modeloCoche;
        this.urlFoto = urlFoto;
        this.numeroPresupuesto = numeroPresupuesto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getModeloCoche() {
        return modeloCoche;
    }

    public void setModeloCoche(String modeloCoche) {
        this.modeloCoche = modeloCoche;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public int getNumeroPresupuesto() {
        return numeroPresupuesto;
    }

    public void setNumeroPresupuesto(int numeroPresupuesto) {
        this.numeroPresupuesto = numeroPresupuesto;
    }
}
