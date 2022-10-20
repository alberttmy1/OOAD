import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class Unit_Test {
    private final Adventurers_stats4 getN = new Adventurers_stats4(1);
    @Test
    void ch_type() {
        assertEquals("Brawlers", getN.getName());
    }
    private final Adventurers_stats4 getN2 = new Adventurers_stats4(2);
    @Test
    void ch_type2() {
        assertEquals("Sneakers ", getN2.getName());
    }
    private final Adventurers_stats4 getN3 = new Adventurers_stats4(3);
    @Test
    void ch_type3() {
        assertEquals("Runners", getN3.getName());
    }
    private final Adventurers_stats4 getN4 = new Adventurers_stats4(4);
    @Test
    void ch_type4() {
        assertEquals("Thieves", getN4.getName());
    }
    private final Creatures_stats4 c_name = new Creatures_stats4(1);
    @Test
    void cre_name() {
        assertEquals("Orbitor", c_name.getName());
    }
    private final Creatures_stats4 c_name2 = new Creatures_stats4(2);
    @Test
    void cre_name2() {
        assertEquals("Seekers", c_name2.getName());
    }
    private final Creatures_stats4 c_name3 = new Creatures_stats4(3);
    @Test
    void cre_name3() {
        assertEquals("Blinkers", c_name3.getName());
    }
    private final Treasure_stats4 tres_name = new Treasure_stats4(1);
    @Test
    void t_name() {
        assertEquals("Sword", tres_name.getName());
    }
    private final Treasure_stats4 tres_name2 = new Treasure_stats4(2);
    @Test
    void t_name2() {
        assertEquals("Gem", tres_name2.getName());
    }
    private final Treasure_stats4 tres_name3 = new Treasure_stats4(3);
    @Test
    void t_name3() {
        assertEquals("Armor", tres_name3.getName());
    }
    private final Treasure_stats4 tres_name4 = new Treasure_stats4(4);
    @Test
    void t_name4() {
        assertEquals("Portal", tres_name4.getName());
    }
    private final Treasure_stats4 tres_name5 = new Treasure_stats4(5);
    @Test
    void t_name5() {
        assertEquals("Trap", tres_name5.getName());
    }
    private final Treasure_stats4 tres_name6 = new Treasure_stats4(6);
    @Test
    void t_name6() {
        assertEquals("Potion", tres_name6.getName());
    }
    private final Adventurers_stats4 gets = new Adventurers_stats4(1);
    @Test
    void ch_s() {
        assertEquals(Arrays.toString(new int[]{0,1,1}),Arrays.toString(gets.getSpawn()));
    }
    private final Adventurers_stats4 gethp = new Adventurers_stats4(1);
    @Test
    void ch_hp() {
        assertEquals(12,gethp.getHP());
    }

}
