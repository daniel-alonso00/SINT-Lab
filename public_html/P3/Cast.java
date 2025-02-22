package p3;

public class Cast implements Comparable<Cast>{
    
    private String idC;
    private String name;
    private String role;

    //Constructor vacio
    public Cast(){
    }

    //Constructor con argumentos
    public Cast(String idC, String name, String role){
        this.idC = idC;
        this.name = name;
        this.role = role;
    }

    //GETTERS
    public String getIdC(){
        return idC;
    }
    public String getName(){
        return name;
    }
    public String getRole(){
        return role;
    }

    //SETTERS
    public void setIdC(String idC){
        this.idC = idC;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRole(String role){
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false; // Si es null, no son iguales
        Cast other = (Cast) obj; // Asumimos que siempre será Cast
        return this.idC.equals(other.idC) && this.name.equals(other.name) && this.role.equals(other.role);
    }


    @Override
    public String toString() {

        return ("idC: "+idC+" ,Name: "+name+" ,Role: "+role);
    }

    @Override
    public int compareTo(Cast other){
        return this.idC.compareTo(other.idC);
    }

}
