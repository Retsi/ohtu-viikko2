/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lmsainio
 */
public class StatisticsTest {
    
    Statistics stats;
    List<Player> players;
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
    
    
    
    public StatisticsTest() {
    }
    
    @Before
    public void setUp() {
        players = readerStub.getPlayers();
        stats = new Statistics(readerStub);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of search method, of class Statistics.
     */
    
    @Test
    public void testSearch(){
        Player pelaaja = players.get(1);
        Player tulos = null;
        System.out.println(pelaaja.getName());
        tulos = stats.search(pelaaja.getName());
        assertEquals(pelaaja.getName(), tulos.getName());
        System.out.println(tulos.getGoals());
        assertEquals(null, stats.search("sda"));

        
    }

    @Test
    public void testTeam() {
        List<Player> tiimi = stats.team("DET");
        Player pelaaja = tiimi.get(0);
        assertEquals("Yzerman", pelaaja.getName());

    }
    
    @Test
    public void testTopScorers() {
        Player huippu = stats.topScorers(1).get(0);
        assertEquals("Gretzky", huippu.getName());
    }
}
