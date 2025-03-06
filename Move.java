public class Move {

    private int pp;             // > 0
    private String dam;
    private int acc;            // > 0, si = 0 entonces es PROPIO, ZONA o ALIADO, se pone --
    private String name;
    private String nombre;
    private String desEn;
    private String desSP;
    private int appeal;
    private E_PokeType type;    // != NULL
    private E_PokeType theme;
    private E_PokeType category;

    public Move(int pp, String dam, int acc, String name, String nombre, String desEn, String desSP, String theme,
            int appeal, String type, String category) {
        this.pp = pp;
        this.dam = dam;
        this.acc = acc;
        this.name = name;
        this.nombre = nombre;
        this.desEn = desEn;
        this.desSP = desSP;
        this.theme = E_PokeType.type(theme);
        this.category = E_PokeType.type(category);
        this.appeal = appeal;
        this.type = E_PokeType.type(type);
    }

    public Move(String[] line){
        this(Integer.parseInt(line[5]),line[6],Integer.parseInt(line[8]), line[0], line[1], line[9], line[10], line[3], Integer.parseInt(line[7]), line[2], line[4]);
    }

    public String toStringEsp(){
        String output;

        if(acc == 0){
            output = nombre + " " + type.toString() + "\n";
            output += dam + " " + category.toString() + " | " + appeal + "d10 " + theme.toString() + " | " + pp + " | --" + "\n";
            output += desSP;
        } else {
            output = nombre + " " + type.toString() + "\n";
            output += dam + " " + category.toString() + " | " + appeal + "d10 " + theme.toString() + " | " + pp + " | " + acc + "\n";
            output += desSP;
        }
        return output;
    }

    public String toFile(int i){
        String output = "";

        output += "#### " + nombre + "{{color:#cca983,width:13px,position:relative,top:-1px #" + i + "}}" + "\n";

        output += "![" + type.toString() + "](" + type.ImageLinkSp() + "){height:15px,position:relative,top:5px} ![" + category.toString() + "](" + category.ImageLinkSp() + "){height:15px,position:relative,top:2.5px}" + "\n";
        
        if(!dam.equals("--")){
            output += "**Daño:** :: " + dam + "\n";
        }
        
        output += "**Concurso:** :: " + appeal + "d10 ![" + theme.toString() + "](" + theme.ImageLinkSp() + "){height:15px,position:relative,top:2.5px}" + "\n";
        
        if(acc != 0){
            output += "**Precisión:** :: 1d100 " + acc + "\n";
        } else {
            output += "**Precisión:** :: 1d100\n";
        }
        
        output += desSP;

        return output;
    }

    @Override
    public String toString(){
        String output;

        if(acc == 0){
            output = name + " " + type.toString() + "\n";
            output += dam + " " + category.toString() + " | " + appeal + "d10 " + theme.toString() + " | " + pp + " | --" + "\n";
            output += desEn;
        } else {
            output = name + " " + type.toString() + "\n";
            output += dam + " " + category.toString() + " | " + appeal + "d10 " + theme.toString() + " | " + pp + " | " + acc + "\n";
            output += desEn;
        }
        return output;
    }
}
