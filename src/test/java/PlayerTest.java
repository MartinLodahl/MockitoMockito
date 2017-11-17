/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Monopoly.IBoard;
import Monopoly.IDie;
import Monopoly.IPiece;
import Monopoly.ISquare;
import Monopoly.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author MartinLodahl
 */
@RunWith(MockitoJUnitRunner.class)
public class PlayerTest {

    public PlayerTest() {
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
    @Mock
    private IDie die1, die2;
    @Mock
    private IPiece piece;
    @Mock
    private IBoard board;
    @Mock
    private ISquare newLoc, oldLoc;

    @Test
    public void testPlayerTurn() {
        //Initilizing mock objects
        die1 = mock(IDie.class);
        die2 = mock(IDie.class);
        piece = mock(IPiece.class);
        board = mock(IBoard.class);
        newLoc = mock(ISquare.class);
        oldLoc = mock(ISquare.class);

        // setup expectations about collaborating behavior  
        InOrder inOrder = inOrder(die1);
        InOrder inOrderDie2 = inOrder(die2);
        InOrder inOrderPiece = inOrder(piece);
        InOrder inOrderBoard = inOrder(board);
        when(die1.getFaceValue()).thenReturn(2);
        when(die2.getFaceValue()).thenReturn(3);
        when(piece.getLocation()).thenReturn(oldLoc);
        when(board.getSquare(oldLoc, 5)).thenReturn(newLoc);
        //Execute test
        Player p = new Player(die1, die2, piece, board);
        p.takeTurn();
        //verify behaviour
        inOrder.verify(die1, times(1)).getFaceValue();
        inOrderDie2.verify(die2, times(1)).getFaceValue();
        inOrderPiece.verify(piece, times(1)).getLocation();
        inOrderPiece.verify(piece, times(1)).setLocation(newLoc);
        inOrderBoard.verify(board, times(1)).getSquare(oldLoc, 5);
        
    }

    /* @Test
    public void testFill()
    {
        //Initialize mock object
        mockWarehouse = mock(IWarehouse.class);
        Order order = new Order(NUMBER, PRODUCT, mockWarehouse);
        
        // setup expectations about collaborating behavior      
	InOrder inOrder = inOrder(mockWarehouse);
        when(mockWarehouse.getInventory(PRODUCT)).thenReturn(INVENTORY);
	when(mockWarehouse.setNumber(INVENTORY-NUMBER)).thenReturn(Boolean.TRUE);

        // execute test
	order.fill();
	boolean isFilled = order.isFilled();
        
        //Verify State
        assertTrue(isFilled);
        //verify behaviour
        inOrder.verify(mockWarehouse, times(1)).getInventory(PRODUCT);
        inOrder.verify(mockWarehouse, times(1)).setNumber(INVENTORY-NUMBER);


    }*/
}
