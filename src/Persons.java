public class Persons {
    private int persId;
    private String nachname, vorname,rolle;

    public Persons() {
    }

    public Persons(int persId, String nachname, String vorname, String rolle) {
        this.persId = persId;
        this.nachname = nachname;
        this.vorname = vorname;
        this.rolle = rolle;
    }

    public int getPersId() {
        return persId;
    }

    public void setPersId(int persId) {
        this.persId = persId;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getRolle() {
        return rolle;
    }

    public void setRolle(String rolle) {
        this.rolle = rolle;
    }

    @Override
    public String toString() {
        return "Persons [person ID=" + persId + ", nachname=" + nachname + ", vorname=" + vorname + ", rolle=" + rolle
                + "]";
    }

}
