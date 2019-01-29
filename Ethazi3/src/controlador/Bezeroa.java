package controlador;

import java.sql.Date;

public class Bezeroa {
private String NAN,izen_abizen,sexua,pasahitza;
private Date jaiotze_data;




/////////Builders/////////////
public Bezeroa(String NAN, String izen, String abizena, Date jaiotze_data, String sexua, String pasahitza) {
	
	this.NAN = NAN;
	this.izen_abizen = izen+abizena;
	this.sexua = sexua;
	this.pasahitza = pasahitza;
	this.jaiotze_data = jaiotze_data;
}

/////////Getters && Setters//////////
public String getNAN() {
	return NAN;
}
public void setNAN(String NAN) {
	this.NAN = NAN;
}
public String getIzen_abizen() {
	return izen_abizen;
}
public void setIzen_abizen(String izen_abizen) {
	this.izen_abizen = izen_abizen;
}
public String getSexua() {
	return sexua;
}
public void setSexua(String sexua) {
	this.sexua = sexua;
}
public String getPasahitza() {
	return pasahitza;
}
public void setPasahitza(String pasahitza) {
	this.pasahitza = pasahitza;
}
public Date getJaiotze_data() {
	return jaiotze_data;
}
public void setJaiotze_data(Date jaiotze_data) {
	this.jaiotze_data = jaiotze_data;
}

}
