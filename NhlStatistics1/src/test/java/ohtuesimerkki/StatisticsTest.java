package ohtuesimerkki;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {
    Reader readerStub = new Reader() {
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;
  
    @Before
    public void setUp(){
        stats = new Statistics(readerStub);
    }
    @Test
    public void searchLoytaaPelaajan(){
        Player g = stats.search("Gretzky");
        assertEquals(g.getGoals(),35);
    }

    @Test 
    public void searchPalauttaaNullJosPelaajaaEiLoydy(){
        Player a = stats.search("Aho");
        assertNull(a);
    }

    @Test 
    public void teamPalauttaaListanJoukkueenPelaajista(){
        List<Player> e = stats.team("EDM");
        assertEquals(e.get(0).getName(), "Semenko");
        assertEquals(e.get(1).getName(), "Kurri");
        assertEquals(e.get(2).getName(), "Gretzky");
    }
    @Test
    public void topScorersPalauttaaRajatunJaJarjestetynListan(){
        List<Player> top = stats.topScorers(1);
        assertEquals(top.size(), 2);
        assertEquals(top.get(0).getName(), "Gretzky");
        assertEquals(top.get(1).getName(), "Lemieux");
        
    }
}