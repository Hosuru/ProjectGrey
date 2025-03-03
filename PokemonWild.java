import ProjectGreyHelper.MyResources;

public class PokemonWild {

    // Constant
    static final String POKEFILE = "Project Grey - Pokes.csv";
    static final String ABLTFILE = "Project Grey - Habilidades.csv";
    static final String MOVEFILE = "Project Grey - Moves CSV.csv";
    
    int id;
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
    String[] abilities;
    String ability;
    int male;
    String moveList;
    int level = 1;

    public PokemonWild(int id, String name, int hP, int att, int def, int spA, int spD, int spe, int pPs, String type1,
            String type2, String altura, String height, String peso, String weight, int minLevel, String evolv,
            String dexSp, String dexEn, String ab1, String ab2, String abO, int male, String moveList) {
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
        this.moveList = moveList;
    }

    private String[] setAbilities(String ab1, String ab2, String abO){
        String[] output = new String[12];

        String[][] abMatrix = MyResources.csvToTxt(ABLTFILE, 107, ";");

        String[] data1 = MyResources.lineFinder(ab1, abMatrix);
        String[] data2 = MyResources.lineFinder(ab2, abMatrix);
        String[] data3 = MyResources.lineFinder(abO, abMatrix);

        int x = 0;

        // x[0] = ab1 english name
        // x[1] = ab1 nombre español
        // x[2] = ab1 english description
        // x[3] = ab 1 descripcion español
        // x[4-7] ab2
        // x[8-11] abO

        for (String y : data1) {
            output[x] = y;
            x++;
        }
        for (String y : data2) {
            output[x] = y;
            x++;
        }
        for (String y : data3) {
            output[x] = y;
            x++;
        }

        return output;
    }

    // NOT FINISHED, ONLY GIVES NAME, ID AND TYPES
    @Override
    public String toString() {
        String output;
        // first line depends on typing
        if(this.type2 != E_PokeType.NULL)
            output = this.id + " - " + this.name + " (" + this.level + "): " + this.type1 + " " + this.type2 + "\n";
        else
            output = this.id + " - " + this.name + " (" + this.level + "): " + this.type1 + "\n";

        return output;
    }
}