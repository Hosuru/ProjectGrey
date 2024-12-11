import ProjectGreyHelper.MyResources;

public class Pokemon {
    
    private int id;     // num de la pokedex NACIONAL
    private String name;
    private E_PokeType type1;
    private E_PokeType type2 = E_PokeType.NULL; // Siempre pensando en que puede no haber segundo tipo
    private Move movepool[][] = new Move[11][]; // 10 niveles + 1 para los aprendidos por otros medios
    private Move moves[] = new Move[6];         // tratemos de usar un puntero a movepool para aligerar un poco la carga
    private Pokemon prevo[];// Pokemon que evolucionan en this     usa ID
    private Pokemon evo[];  // Pokemon a los que this evoluciona   usa ID
    private String entry;   // Info de la pokedex
    private int level = 1;  // Nivel, donde (1 <= level <= 10)
    private int hp, att, def, sAtt, sDef, spe;


    public Pokemon(int id, String name, String entry, E_PokeType type1, E_PokeType type2,
    int hp, int att, int def, int sAtt, int sDef, int spe,
    int level, Move[][] movepool, Move[] moves,
    Pokemon[] prevo, Pokemon[] evo) {

        //esto va a ser rellenado por un lector de CSVs, por ahora voy a confiar que siempre va a estar bien hecho.
        this.id = id;
        this.name = name;
        this.entry = entry;
        this.type1 = type1;
        this.type2 = type2;
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

    public Pokemon(String file, int rows, int columns){
        String pokeList[][] = MyResources.scanNow(file, ",", rows, columns);

        for (String[] poke : pokeList) {
            
        }
    }

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

    // SETTERS
    public void setMovepool(Move[][] movepool) {
        this.movepool = movepool;
    }
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
    

    @Override
    public String toString() {
        return super.toString();
    }
}