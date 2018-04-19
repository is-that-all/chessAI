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
public class King extends Piece{

    private final static int[] CANDIDATE_MOVE_COORDINATE = {-9,-8,-7,-1,1,7,8,9};
    
    public King(final Alliance pieceAlliance,final int piecePosition) {
        super(PieceType.KING,piecePosition, pieceAlliance,true);
    }

    public King(final Alliance pieceAlliance,
                final int piecePosition,
                final boolean isFirstMove){
        super(PieceType.KING,piecePosition, pieceAlliance,isFirstMove);
    }
    
    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        
        for(final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATE){
            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            
            if(isFirstColumnExclusion(this.piecePosition,currentCandidateOffset)
               || isEighthColumnExclusion(this.piecePosition,currentCandidateOffset)){
                continue;
            }
            
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
                    }
                }
            }
        }
        
        return ImmutableList.copyOf(legalMoves);
    }
    
    @Override
    public King movePiece(final Move move) {
        return new King(move.getMovedPiece().getPieceAlliance(),move.getDestinationCoordinate());
    }
    
    public String toString() {
        return PieceType.KING.toString();
    }
    
    private static boolean isFirstColumnExclusion(final int currentPosition,
                                                  final int candidateOffset) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && ((candidateOffset == -9) ||
                (candidateOffset == -1) || (candidateOffset == 7));
    }

    private static boolean isEighthColumnExclusion(final int currentPosition,
                                                   final int candidateOffset) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && ((candidateOffset == -7) ||
                (candidateOffset == 1) || (candidateOffset == 9));
    }
    
}
