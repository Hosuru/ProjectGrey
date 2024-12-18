import ProjectGreyHelper.MyResources;

public class Pokemon {

    // Constant
    static final String POKEFILE = "Pokemon base.csv";
    static final String ABLTFILE = "Pokemon base.csv";
    
    // Variables (some are final just in case, shold NOT be changed)
    private final int id;     // num de la pokedex NACIONAL
    private final String name;
    private final E_PokeType type1;
    private final E_PokeType type2; // Siempre pensando en que puede no haber segundo tipo
    private final Move movepool[][]; // 10 niveles + 0 para los aprendidos por otros medios
    private Move moves[] = new Move[6];         // tratemos de usar un puntero a movepool para aligerar un poco la carga
    private final Pokemon prevo[];// Pokemon que evolucionan en this     usa ID
    private final Pokemon evo[];  // Pokemon a los que this evoluciona   usa ID       ADD BASCULEGION
    private final String ability[];
    private final String entry;   // Info de la pokedex
    private int level;  // Nivel, donde (1 <= level <= 10)
    private int hp, att, def, sAtt, sDef, spe;
    // MINIMUM LEVEL


    public Pokemon(int id, String name, String entry, E_PokeType type1, E_PokeType type2, String[] ability,
    int hp, int att, int def, int sAtt, int sDef, int spe,
    int level, Move[][] movepool, Move[] moves,
    Pokemon[] prevo, Pokemon[] evo) {

        //esto va a ser rellenado por un lector de CSVs, por ahora voy a confiar que siempre va a estar bien hecho.
        this.id = id;
        this.name = name;
        this.entry = entry;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
        this.hp = hp;
        this.att = att;
        this.def = def;
        this.sAtt = sAtt;
        this.sDef = sDef;
        this.spe = spe;
        this.level = level;
        this.movepool = movepool;
        this.moves = moves;
        this.prevo = prevo;
        this.evo = evo;
    }

    // if there's a specific moves and ability, meaning that this is a specific pokemon
    public Pokemon(String[] list, int level, Move[] moves , String[] ability){
        this(Integer.parseInt(list[0]), list[1], null, E_PokeType.valueOf(list[9]), E_PokeType.valueOf(list[10]), ability,    // ID, NAME, ENTRY, TYPE1, TYPE2, ABILITY
        Integer.parseInt(list[2]), Integer.parseInt(list[3]), Integer.parseInt(list[4]),                                            // HP, ATT, DEF
        Integer.parseInt(list[5]), Integer.parseInt(list[6]), Integer.parseInt(list[7]),                                            // SPA, SPD, SPE
        level, null, moves, null, null);                                                                         // LEVL, MOVEPOOL, MOVES, PREVO, EVO
    }

    // completely randomized pokemon
    public Pokemon(String[] list, int level){
        this(list, level, chooseMoves(null/*movepool*/, level), chooseAbility(Integer.parseInt(list[0])));
    }

    // completely randomized pokemon, at the basic level
    public Pokemon(String[] list){
        this(list, 1);
    }
    
    // returns [ability name, ability description]
    // for now just in English
    private static String[] chooseAbility(int pokeID){
        int abPos; // ability position
        String name;

        int num = 1 + (int)(Math.random() * 100);
        if(num <= 50 && num != 1)
            abPos = 11;
        else if(num > 50 && num != 100)
            abPos = 12;
        else
            abPos = 13;
        
        name = MyResources.searchLine(POKEFILE, ",", pokeID, 0)[abPos];

        // for some reason it makes me use a va
        String output[] = {name, MyResources.searchLine(ABLTFILE, ",", name, 0)[2]};
        return output;
    }

    // assigns the las 6 moves from this pokemon, if it doesn't have 6 moves, leaves null on blank spaces
    // i better get some sleep for today
    /*
    private static Move[] chooseMoves(Move[] movepool, int level){
        Move[] output = {null, null, null, null, null, null};
        boolean moreMoves = true;

        while(output[6] == null && moreMoves){
            int i = level;
            if(movepool[i]){
                
            }
        }

        return output;
    }*/

    // GETTERS
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public E_PokeType getType1() {
        return type1;
    }
    public E_PokeType getType2() {
        return type2;
    }
    public Move[][] getMovepool() {
        return movepool;
    }
    public Pokemon[] getPrevo() {
        return prevo;
    }
    public Pokemon[] getEvo() {
        return evo;
    }
    public String getEntry() {
        return entry;
    }
    public int getLevel() {
        return level;
    }
    public int getHp() {
        return hp;
    }
    public int getAtt() {
        return att;
    }
    public int getDef() {
        return def;
    }
    public int getsAtt() {
        return sAtt;
    }
    public int getsDef() {
        return sDef;
    }
    public int getSpe() {
        return spe;
    }
    public Move[] getMoves() {
        return moves;
    }
    public String[] getAbility(){
        return ability;
    }

    // SETTERS
    public void setLevel(int level) {
        this.level = level;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setAtt(int att) {
        this.att = att;
    }
    public void setDef(int def) {
        this.def = def;
    }
    public void setsAtt(int sAtt) {
        this.sAtt = sAtt;
    }
    public void setsDef(int sDef) {
        this.sDef = sDef;
    }
    public void setSpe(int spe) {
        this.spe = spe;
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