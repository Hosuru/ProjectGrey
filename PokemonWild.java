import ProjectGreyHelper.MyResources;
import java.util.HashMap;
import java.util.Map;

public class PokemonWild {

    // Constant
    static final String POKEFILE = "Project Grey - Pokes.csv";
    static final int POKELINES = 160;
    static final String ABLTFILE = "Project Grey - Habilidades.csv";
    static final int ABLTLINES = 107;
    static final String MOVEFILE = "Project Grey - Moves CSV.csv";
    static final int MOVESLINES = 509;
    
    Double id;
    String name;
    int HP;
    int Att;
    int Def;
    int SpA;
    int SpD;
    int Spe;
    int PPs;
    E_PokeType type1;
    E_PokeType type2;
    String altura;
    String height;
    String peso;
    String weight;
    int minLevel;
    String evolv;
    String dexSp;
    String dexEn;
    Map<String, String[]> abilities = new HashMap<String, String[]>();
    int male;
    Map<String, String[]> movelist = new HashMap<String, String[]>();

    private PokemonWild(double id, String name, int hP, int att, int def, int spA, int spD, int spe, int pPs, String type1,
    String type2, String altura, String height, String peso, String weight, int minLevel, String evolv,
    String dexEn, String dexSp, String ab1, String ab2, String abO, int male, String[][] moveList) {
        this.id = id;
        this.name = name;
        HP = hP;
        Att = att;
        Def = def;
        SpA = spA;
        SpD = spD;
        Spe = spe;
        PPs = pPs;
        this.type1 = E_PokeType.type(type1);
        this.type2 = E_PokeType.type(type2);
        this.altura = altura;
        this.height = height;
        this.peso = peso;
        this.weight = weight;
        this.minLevel = minLevel;
        this.evolv = evolv;
        this.dexSp = dexSp;
        this.dexEn = dexEn;
        this.abilities = setAbilities(ab1, ab2, abO);
        this.male = male;
        this.movelist = setMoves(moveList);
    }

    public PokemonWild(String[] line){
        this(Double.parseDouble(line[0]),line[1],Integer.parseInt(line[2]),Integer.parseInt(line[3]),
        Integer.parseInt(line[4]),Integer.parseInt(line[5]),Integer.parseInt(line[6]),
        Integer.parseInt(line[7]), Integer.parseInt(line[8]),line[9],line[10],line[11],
        line[12],line[13],line[14],Integer.parseInt(line[15]),line[16],line[17],line[18],
        line[19],line[20],line[21],Integer.parseInt(line[22]),makeMoveList(line));
    }

    private static String[][] makeMoveList(String[] line){
        String[][] movelist = new String[11][];
        for(int i = 0; i<11; i++){
            movelist[i] = line[i+23].split(", ");
        }

        return movelist;
    }

    private Map<String, String[]> setAbilities(String ab1, String ab2, String abO){
        Map<String, String[]> output = new HashMap<String, String[]>();

        output.put("ab1", MyResources.lineFinder(ab1, MyResources.csvToTxt(ABLTFILE, ABLTLINES, ";")));
        output.put("ab2", MyResources.lineFinder(ab2, MyResources.csvToTxt(ABLTFILE, ABLTLINES, ";")));
        output.put("abO", MyResources.lineFinder(abO, MyResources.csvToTxt(ABLTFILE, ABLTLINES, ";")));

        return output;
    }

    private Map<String, String[]> setMoves(String[][] movelist){
        Map<String, String[]> output = new HashMap<String, String[]>();

        for(int i = 0; i<11; i++){
            output.put(Integer.toString(i), movelist[i]);
        }

        return output;
    }

    public String toFileEspNormal() {
        String output = "{{monster\n";

        // depends on typing
        if(this.type2 == E_PokeType.NULL) { 
            output += "## {{color:#928862 #" + String.format("%.0f", this.id) + "}} " + this.name + " ![" + this.type1.toString() + "]" + "(" + this.type1.ImageLinkSp() + ")  {width:20%}\n";
        } else {
            output += "## {{color:#928862 #" + String.format("%.0f", this.id) + "}} " + this.name + " ![" + this.type1.toString() + "]" + "(" + this.type1.ImageLinkSp() + ")  {width:20%} ![" + this.type2.toString() + "]" + "(" + this.type2.ImageLinkSp() + ")  {width:20%}\n";
        }

        output += "*" + this.altura + ", " + this.peso + "*\n\n";
        
        if(this.male != 0){
            output += "♂" + this.male + "% ♀" + (100-this.male) + "%\n\n";
        }

        output += "*Nivel mínimo: " + this.minLevel + "*\n";
        output += "___\n";

        output += "| HP | Ataque | Defensa | At. Esp. | Def. Esp. | Velocidad | PPs |\n";
        output += "|:-:|:-:|:-:|:-:|:-:|:-:|:-:|\n";
        output += "| " + this.HP + " | " + this.Att + " | " + this.Def + " | " + this.SpA + " | " + this.SpD + " | " + this.Spe + " | " + this.PPs + "|\n";

        output += ":\n";

        output += "| Habilidad 1 | Habilidad 2 | Habilidad Oculta |\n";
        output += "|:-----------:|:-----------:|:----------------:|\n";
        output += "| *" + abilities.get("ab1")[1] + "* | *" + abilities.get("ab2")[1] + "* | *" + abilities.get("abO")[1] + "* |\n";

        output += "___\n";

        output += "##### Descripción en la pokédex:\n";
        output += "##### *" + this.dexSp + "*\n";
        
        output += "{{classTable,frame\n";
        output += "##### Aprendizaje de Ataques\n";
        output += "| **Nivel** | Ataques |\n";
        output += "|:---------:|:--------|\n";

        for(Map.Entry<String, String[]> entry : this.movelist.entrySet()){
            // first check if talking about TMs
            if(entry.getKey().equals("0")){
                output += "| **TMs**   |";
            } else {
                output += "| **" + entry.getKey() + "** |";
            }

            // check if there's moves at that level
            // then make sure not to end wiht a , something
            if(entry.getValue().length == 0){
                output += " |\n" ;
            } else {
                for (int i = 0; i<entry.getValue().length-1; i++) {
                    output += entry.getValue()[i] + ", ";
                }
                output += entry.getValue()[entry.getValue().length-1] + " |\n";
            }
        }
        output += "}}\n}}";
        output += "\n";

        return output;
    }

    public String toFileEspLegendary() {
        String output = "";

        output += "{{monster,wide\n";

        if(this.type2 == E_PokeType.NULL) { 
            output += "## {{color:#928862 #" + String.format("%.0f", this.id) + "}} " + this.name + " ![" + this.type1.toString() + "]" + "(" + this.type1.ImageLinkSp() + ")  {width:20%}\n";
        } else {
            output += "## {{color:#928862 #" + String.format("%.0f", this.id) + "}} " + this.name + " ![" + this.type1.toString() + "]" + "(" + this.type1.ImageLinkSp() + ")  {width:20%} ![" + this.type2.toString() + "]" + "(" + this.type2.ImageLinkSp() + ")  {width:20%}\n";
        }

        output += "*" + this.altura + ", " + this.peso + "* - *Nivel mínimo: " + this.minLevel + "*\n";

        output += "___\n";

        output += "##### Descripción en la pokédex:\n";
        output += "##### *" + this.dexSp + "*\n";

        output += "\\column\n";

        output += "::\n";

        output += "| HP | Ataque | Defensa | At. Esp. | Def. Esp. | Velocidad | PPs |\n";
        output += "|:-:|:-:|:-:|:-:|:-:|:-:|:-:|\n";
        output += "| " + this.HP + " | " + this.Att + " | " + this.Def + " | " + this.SpA + " | " + this.SpD + " | " + this.Spe + " | " + this.PPs + "|\n";

        output += ":\n";

        output += "| Habilidad 1 | Habilidad 2 | Habilidad Oculta |\n";
        output += "|:-----------:|:-----------:|:----------------:|\n";
        output += "| *" + abilities.get("ab1")[1] + "* | *" + abilities.get("ab2")[1] + "* | *" + abilities.get("abO")[1] + "* |\n";

        output += "}}\n";
        output += "{{classTable,frame,wide,decoration\n";
        output += "##### Aprendizaje de Ataques\n";
        output += "| **Nivel** | Ataques |\n";
        output += "|:---------:|:--------|\n";

        for(Map.Entry<String, String[]> entry : this.movelist.entrySet()){
            // first check if talking about TMs
            if(entry.getKey().equals("0")){
                output += "| **TMs**   |";
            } else {
                output += "| **" + entry.getKey() + "** |";
            }

            // check if there's moves at that level
            // then make sure not to end wiht a , something
            if(entry.getValue().length == 0){
                output += " |\n" ;
            } else {
                for (int i = 0; i<entry.getValue().length-1; i++) {
                    output += entry.getValue()[i] + ", ";
                }
                output += entry.getValue()[entry.getValue().length-1] + " |\n";
            }
        }
        output += "}}";
        output += "\n";

        return output;
    }
}