
import Gui.Table;
import board.Board;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dell
 */
public class JChess {
    public static void main(String args[]){
        Board board = Board.createStandardBoard();
        System.out.println(board.toString());
        Table table = new Table();
    }
}
