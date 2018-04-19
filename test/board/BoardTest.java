/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package board;

import Player.Player;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pieces.Pawn;
import pieces.Piece;

/**
 *
 * @author Dell
 */
public class BoardTest {
    
    public BoardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Board.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Board instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of whitePlayer method, of class Board.
     */
    @Test
    public void testWhitePlayer() {
        System.out.println("whitePlayer");
        Board instance = null;
        Player expResult = null;
        Player result = instance.whitePlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of blackPlayer method, of class Board.
     */
    @Test
    public void testBlackPlayer() {
        System.out.println("blackPlayer");
        Board instance = null;
        Player expResult = null;
        Player result = instance.blackPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of currentPlayer method, of class Board.
     */
    @Test
    public void testCurrentPlayer() {
        System.out.println("currentPlayer");
        Board instance = null;
        Player expResult = null;
        Player result = instance.currentPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnPassantPawn method, of class Board.
     */
    @Test
    public void testGetEnPassantPawn() {
        System.out.println("getEnPassantPawn");
        Board instance = null;
        Pawn expResult = null;
        Pawn result = instance.getEnPassantPawn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlackPieces method, of class Board.
     */
    @Test
    public void testGetBlackPieces() {
        System.out.println("getBlackPieces");
        Board instance = null;
        Collection<Piece> expResult = null;
        Collection<Piece> result = instance.getBlackPieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWhitePieces method, of class Board.
     */
    @Test
    public void testGetWhitePieces() {
        System.out.println("getWhitePieces");
        Board instance = null;
        Collection<Piece> expResult = null;
        Collection<Piece> result = instance.getWhitePieces();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTile method, of class Board.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        int tileCoordinate = 0;
        Board instance = null;
        Tile expResult = null;
        Tile result = instance.getTile(tileCoordinate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createStandardBoard method, of class Board.
     */
    @Test
    public void testCreateStandardBoard() {
        System.out.println("createStandardBoard");
        Board expResult = null;
        Board result = Board.createStandardBoard();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllLegalMoves method, of class Board.
     */
    @Test
    public void testGetAllLegalMoves() {
        System.out.println("getAllLegalMoves");
        Board instance = null;
        Iterable<Move> expResult = null;
        Iterable<Move> result = instance.getAllLegalMoves();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
