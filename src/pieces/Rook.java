/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pieces;

import Utils.Alliance;
import board.Board;
import board.BoardUtils;
import board.Move;
import board.Move.AttackMove;
import board.Move.MajorAttackMove;
import board.Move.MajorMove;
import board.Tile;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Rook extends Piece{

    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = {-8,-1,1,8};
    
    public Rook(final Alliance pieceAlliance,final int piecePosition) {
        super(PieceType.ROOK,piecePosition, pieceAlliance,true);
    }

    public Rook(final Alliance pieceAlliance,
                final int piecePosition,
                final boolean isFirstMove){
        super(PieceType.ROOK,piecePosition, pieceAlliance,isFirstMove);
    }
    
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        
        for(final int candidateCoordinateOffset: CANDIDATE_MOVE_VECTOR_COORDINATES){
            int candidateDestinationCoordinate = this.piecePosition;
            while(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                if(isFirstColumnExclusion(candidateDestinationCoordinate,candidateCoordinateOffset)||
                   isEighthColumnExclusion(candidateDestinationCoordinate,candidateCoordinateOffset) ){
                    break;
                }
                candidateDestinationCoordinate += candidateCoordinateOffset;
                if(BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)){
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                    //null statement added to remove NullPointerException
                    if((candidateDestinationTile != null) && !candidateDestinationTile.isTileOccupied()){
                            legalMoves.add(new MajorMove(board,this,candidateDestinationCoordinate));
                    }
                    else{
                        //null statement added to remove NullPointerException
                        if(candidateDestinationTile != null){
                            final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                            final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();
                            if(this.pieceAlliance != pieceAlliance){
                                legalMoves.add(new MajorAttackMove(board,this,candidateDestinationCoordinate,pieceAtDestination));
                            }
                            break;
                        }
                    }
                }
            }
        }
        
        return ImmutableList.copyOf(legalMoves);
    }
    
    @Override
    public Rook movePiece(final Move move) {
        return new Rook(move.getMovedPiece().getPieceAlliance(),move.getDestinationCoordinate());
    }
    
    public String toString() {
        return PieceType.ROOK.toString();
    }
    
    private static boolean isFirstColumnExclusion(final int currentPosition,
                                                  final int candidateOffset) {
        return (BoardUtils.FIRST_COLUMN[currentPosition] &&
                (candidateOffset == -1));
    }

    private static boolean isEighthColumnExclusion(final int currentPosition,
                                                  final int candidateOffset) {
        return (BoardUtils.EIGHTH_COLUMN[currentPosition] &&
                (candidateOffset == 1));
    }
    
}
