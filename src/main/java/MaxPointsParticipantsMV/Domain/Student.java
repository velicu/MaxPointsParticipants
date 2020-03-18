package MaxPointsParticipantsMV.Domain;

import java.util.Objects;

public class Student implements hasID<String> {
    private String idStudent;
    private String nume;
    private int grupa ;
    private String email;
    private String profesor;
    public Student (String id, String n, int gr, String e, String prof){
        this.idStudent=id;
        this.nume=n;
        this.grupa=gr;
        this.email=e;
        this.profesor=prof;
    }
    public String getID(){
        return idStudent;
    }
    public void setID(String id){
        this.idStudent=id;
    }
    public String getNume(){
        return nume;
    }
    public void setNume(String nume){
        this.nume=nume;
    }
    public int getGrupa(){
        return grupa;
    }
    public void setGrupa(int grupa){
        this.grupa=grupa;
    }
    public String getMail(){
        return email;
    }
    public void setMail(String mail){
        this.email=mail;
    }
    public String getProfesor(){
        return profesor;
    }
    public void setProfesor(String prof){
        this.profesor=prof;
    }
    public String toString(){
        return idStudent+' '+nume+' '+grupa+' '+email+' '+profesor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getGrupa() == student.getGrupa() &&
                idStudent.equals(student.idStudent) &&
                getNume().equals(student.getNume()) &&
                email.equals(student.email) &&
                getProfesor().equals(student.getProfesor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, getNume(), getGrupa(), email, getProfesor());
    }
}

