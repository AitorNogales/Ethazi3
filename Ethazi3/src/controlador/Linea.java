package controlador;

import java.util.ArrayList;

public class Linea {
	

private String kod_linea ,nombre_linea;
private ArrayList<Autobusa> Autobusak;
private ArrayList<Herria>Herriak;

//////Builders///////
/**
 * Linea objetuaren sortzailea 
 * @param kod_linea linearen kodea 
 * @param nombre_linea linearen izena 
 * @param autobusak zein autobus joango diren lineatik
 * @param herriak zein herrietatk pasatzen den linea 
 */
public Linea(String kod_linea, String nombre_linea, ArrayList<Autobusa> autobusak, ArrayList<Herria> herriak) {
	
	this.kod_linea = kod_linea;
	this.nombre_linea = nombre_linea;
	Autobusak = autobusak;
	Herriak = herriak;
}
/**
 * Linea objetuaren sotzailea 
 * @param kod_linea linearen kodea 
 * @param nombre_linea linearen izena 
 */
public Linea(String kod_linea, String nombre_linea) {
	
	this.kod_linea = kod_linea;
	this.nombre_linea = nombre_linea;
	Autobusak=new ArrayList<Autobusa>();
	Herriak= new ArrayList<Herria>();
}

/////////Getters && Setters//////////
public String getKod_linea() {
	return kod_linea;
}
public void setKod_linea(String kod_linea) {
	this.kod_linea = kod_linea;
}
public String getNombre_linea() {
	return nombre_linea;
}
public void setNombre_linea(String nombre_linea) {
	this.nombre_linea = nombre_linea;
}
public ArrayList<Autobusa> getAutobusak() {
	return Autobusak;
}
public void setAutobusak(ArrayList<Autobusa> autobusak) {
	Autobusak = autobusak;
}
public ArrayList<Herria> getHerriak() {
	return Herriak;
}
public void setHerriak(ArrayList<Herria> herriak) {
	Herriak = herriak;
}

//////Methods//////////////
public void addAutobusa(Autobusa au) {
	Autobusak.add(au);
}

public void removeAutobusa(Autobusa au) {
	Autobusak.remove(au);
	
}
public void removeAutobusa(int g) {
	Autobusak.remove(g);
	
}
public void addHerria(Herria he) {
	Herriak.add(he);
}

public void removeHerria(Herria he) {
	Herriak.remove(he);
	
}
public void removeHerria(int g) {
	Herriak.remove(g);
	
}
@Override
public String toString() {
	return kod_linea +"-" + nombre_linea ;
}

}
