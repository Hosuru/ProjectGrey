public enum E_PokeType {
    BUG,
    ELECTR,
    FLYING,
    GROUND,
    POISON,
    STEEL,
    DARK,
    FIGHT,
    GHOST,
    ICE,
    PSYCHC,
    WATER,
    DRAGON,
    FIRE,
    GRASS,
    NORMAL,
    ROCK,
    FAIRY,
    NULL,
    TOUGH,
    CLEVER,
    COOL,
    BEAUTIFUL,
    CUTE,
    PHYSICAL,
    SPECIAL,
    OTHER;

    static E_PokeType type(String type){
        switch(type){
            case "Bug":
                return BUG;
            case "Electr":
                return ELECTR;
            case "Flying":
                return FLYING;
            case "Ground":
                return GROUND;
            case "Poison":
                return POISON;
            case "Steel":
                return STEEL;
            case "Dark":
                return DARK;
            case "Fight":
                return FIGHT;
            case "Ghost":
                return GHOST;
            case "Ice":
                return ICE;
            case "Psychc":
                return PSYCHC;
            case "Water":
                return WATER;
            case "Dragon":
                return DRAGON;
            case "Fire":
                return FIRE;
            case "Grass":
                return GRASS;
            case "Normal":
                return NORMAL;
            case "Rock":
                return ROCK;
            case "Fairy":
                return FAIRY;
            case "Tough":
                return TOUGH;
            case "Clever":
                return CLEVER;
            case "Cool":
                return COOL;
            case "Beautiful":
                return BEAUTIFUL;
            case "Cute":
                return CUTE;
            case "Physical":
                return PHYSICAL;
            case "Special":
                return SPECIAL;
            case "Other":
                return OTHER;
            default:
            return NULL;
        }
    }

    public String ImageLinkSp(){
        switch(this){
            case BUG:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/5/5d/latest/20221208180434/Tipo_bicho_EP.png/120px-Tipo_bicho_EP.png";
            case ELECTR:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/3/38/latest/20221208180452/Tipo_el%C3%A9ctrico_EP.png/120px-Tipo_el%C3%A9ctrico_EP.png";
            case FLYING:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/9/9a/latest/20221208180800/Tipo_volador_EP.png/120px-Tipo_volador_EP.png";
            case GROUND:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/c/c9/latest/20221208180742/Tipo_tierra_EP.png/120px-Tipo_tierra_EP.png";
            case POISON:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/1/11/latest/20221208180751/Tipo_veneno_EP.png/120px-Tipo_veneno_EP.png";
            case STEEL:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/5/52/latest/20221208180543/Tipo_acero_EP.png/120px-Tipo_acero_EP.png";
            case DARK:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/d/de/latest/20221208180734/Tipo_siniestro_EP.png/120px-Tipo_siniestro_EP.png";
            case FIGHT:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/5/5f/latest/20221208180651/Tipo_lucha_EP.png/120px-Tipo_lucha_EP.png";
            case GHOST:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/0/03/latest/20221208180503/Tipo_fantasma_EP.png/120px-Tipo_fantasma_EP.png";
            case ICE:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/1/17/latest/20221208180641/Tipo_hielo_EP.png/120px-Tipo_hielo_EP.png";
            case PSYCHC:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/9/9b/latest/20221208180717/Tipo_ps%C3%ADquico_EP.png/120px-Tipo_ps%C3%ADquico_EP.png";
            case WATER:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/5/59/latest/20221208180426/Tipo_agua_EP.png/120px-Tipo_agua_EP.png";
            case DRAGON:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/b/b8/latest/20221208180443/Tipo_drag%C3%B3n_EP.png/120px-Tipo_drag%C3%B3n_EP.png";
            case FIRE:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/c/c0/latest/20221208180625/Tipo_fuego_EP.png/120px-Tipo_fuego_EP.png";
            case GRASS:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/a/a7/latest/20221208180710/Tipo_planta_EP.png/120px-Tipo_planta_EP.png";
            case NORMAL:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/9/99/latest/20221208180705/Tipo_normal_EP.png/120px-Tipo_normal_EP.png";
            case ROCK:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/8/88/latest/20221208180726/Tipo_roca_EP.png/120px-Tipo_roca_EP.png";
            case FAIRY:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/thumb/9/97/latest/20221208180633/Tipo_hada_EP.png/120px-Tipo_hada_EP.png";
            case TOUGH:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/b/be/latest/20170114102119/Tipo_dureza.gif";
            case CUTE:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/6/6e/latest/20170114102120/Tipo_dulzura.gif";
            case BEAUTIFUL:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/d/dc/latest/20170114102121/Tipo_belleza.gif";
            case CLEVER:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/1/1a/latest/20170114102120/Tipo_ingenio.gif";
            case COOL:
                return "https://images.wikidexcdn.net/mwuploads/wikidex/b/b9/latest/20170114102118/Tipo_carisma.gif";
            case PHYSICAL:
                return "https://archives.bulbagarden.net/media/upload/a/a4/Physical_icon_HOME.png";
            case SPECIAL:
                return "https://archives.bulbagarden.net/media/upload/c/c4/Special_icon_HOME.png";
            case OTHER:
                return "https://archives.bulbagarden.net/media/upload/3/34/Status_icon_HOME.png";
            default:
                return "";
        }
    }

    public String ImageLinkEn(){
        switch(this){
            case BUG:
                return "https://archives.bulbagarden.net/media/upload/thumb/d/d1/BugIC_SV.png/105px-BugIC_SV.png";
            case ELECTR:
                return "https://archives.bulbagarden.net/media/upload/thumb/7/77/ElectricIC_SV.png/105px-ElectricIC_SV.png";
            case FLYING:
                return "https://archives.bulbagarden.net/media/upload/thumb/d/d7/FlyingIC_SV.png/105px-FlyingIC_SV.png";
            case GROUND:
                return "https://archives.bulbagarden.net/media/upload/thumb/f/f8/GroundIC_SV.png/105px-GroundIC_SV.png";
            case POISON:
                return "https://archives.bulbagarden.net/media/upload/thumb/9/9d/PoisonIC_SV.png/105px-PoisonIC_SV.png";
            case STEEL:
                return "https://archives.bulbagarden.net/media/upload/thumb/b/b8/SteelIC_SV.png/105px-SteelIC_SV.png";
            case DARK:
                return "https://archives.bulbagarden.net/media/upload/thumb/3/30/DarkIC_SV.png/105px-DarkIC_SV.png";
            case FIGHT:
                return "https://archives.bulbagarden.net/media/upload/thumb/0/0f/FightingIC_SV.png/105px-FightingIC_SV.png";
            case GHOST:
                return "https://archives.bulbagarden.net/media/upload/thumb/2/2c/GhostIC_SV.png/105px-GhostIC_SV.png";
            case ICE:
                return "https://archives.bulbagarden.net/media/upload/thumb/1/13/IceIC_SV.png/105px-IceIC_SV.png";
            case PSYCHC:
                return "https://archives.bulbagarden.net/media/upload/thumb/9/96/PsychicIC_SV.png/105px-PsychicIC_SV.png";
            case WATER:
                return "https://archives.bulbagarden.net/media/upload/thumb/d/de/WaterIC_SV.png/105px-WaterIC_SV.png";
            case DRAGON:
                return "https://archives.bulbagarden.net/media/upload/thumb/7/7f/DragonIC_SV.png/105px-DragonIC_SV.png";
            case FIRE:
                return "https://archives.bulbagarden.net/media/upload/thumb/a/a2/FireIC_SV.png/105px-FireIC_SV.png";
            case GRASS:
                return "https://archives.bulbagarden.net/media/upload/thumb/7/7b/GrassIC_SV.png/105px-GrassIC_SV.png";
            case NORMAL:
                return "https://archives.bulbagarden.net/media/upload/thumb/0/08/NormalIC_SV.png/105px-NormalIC_SV.png";
            case ROCK:
                return "https://archives.bulbagarden.net/media/upload/thumb/3/32/RockIC_SV.png/105px-RockIC_SV.png";
            case FAIRY:
                return "https://archives.bulbagarden.net/media/upload/thumb/c/c6/FairyIC_SV.png/105px-FairyIC_SV.png";
            case TOUGH:
                return "https://archives.bulbagarden.net/media/upload/b/ba/Tough_icon.png";
            case CUTE:
                return "https://archives.bulbagarden.net/media/upload/6/63/Cute_icon.png";
            case BEAUTIFUL:
                return "https://archives.bulbagarden.net/media/upload/f/f5/Beautiful_icon.png";
            case CLEVER:
                return "https://archives.bulbagarden.net/media/upload/0/0d/Clever_icon.png";
            case COOL:
                return "https://archives.bulbagarden.net/media/upload/d/db/Cool_icon.png";
            case PHYSICAL:
                return "https://archives.bulbagarden.net/media/upload/a/a4/Physical_icon_HOME.png";
            case SPECIAL:
                return "https://archives.bulbagarden.net/media/upload/c/c4/Special_icon_HOME.png";
            case OTHER:
                return "https://archives.bulbagarden.net/media/upload/3/34/Status_icon_HOME.png";
            default:
                return "";
        }
    }
}
