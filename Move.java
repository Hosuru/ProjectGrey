public class Move {

    private int pp;             // > 0
    private String dam;
    private int acc;            // > 0, si = 0 entonces es PROPIO, ZONA o ALIADO, se pone --
    private String name;
    private String description;
    private E_PokeType type;    // != NULL

    // Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public E_PokeType getType() {
        return type;
    }

    public int getPP(){
        return pp;
    }

    public String getDam(){
        return dam;
    }

    public int getAcc(){
        return acc;
    }
    
    // Setters
    public void setName(String x) {
        this.name = x;
    }

    public void setDescription(String x) {
        this.description = x;
    }

    public void setType(E_PokeType x) {
        this.type = x;
    }

    public void setPP(int x){
        this.pp = x;
    }

    public void setDam(String x){
        this.dam = x;
    }

    public void setAcc(int x){
        this.acc = x;
    }

    @Override
    public String toString(){
        if (getAcc() > 0){
            return getName() + " - " + getType() + " (PP: " + getPP() + " PP, Dam: " + getDam() + ", Acc: " + getAcc() + "%)\n"
        + getDescription();
        } else {
            return getName() + " - " + getType() + " (PP: " + getPP() + " PP, Dam: " + getDam() + ", Acc: --)\n"
        + getDescription();
        }
    }
}
