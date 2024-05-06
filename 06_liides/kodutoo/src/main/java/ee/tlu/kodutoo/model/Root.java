package ee.tlu.kodutoo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Root{
    public int id;
    public String name;
    public String last_updated;
    public boolean incomplete;
    public boolean members;
    public String release_date;
    public int combat_level;
    public int size;
    public int hitpoints;
    public int max_hit;
    public ArrayList<String> attack_type;
    public int attack_speed;
    public boolean aggressive;
    public boolean poisonous;
    public boolean venomous;
    public boolean immune_poison;
    public boolean immune_venom;
    public ArrayList<Object> attributes;
    public ArrayList<Object> category;
    public boolean slayer_monster;
    public Object slayer_level;
    public Object slayer_xp;
    public ArrayList<Object> slayer_masters;
    public boolean duplicate;
    public String examine;
    public String wiki_name;
    public String wiki_url;
    public int attack_level;
    public int strength_level;
    public int defence_level;
    public int magic_level;
    public int ranged_level;
    public int attack_bonus;
    public int strength_bonus;
    public int attack_magic;
    public int magic_bonus;
    public int attack_ranged;
    public int ranged_bonus;
    public int defence_stab;
    public int defence_slash;
    public int defence_crush;
    public int defence_magic;
    public int defence_ranged;;
}
