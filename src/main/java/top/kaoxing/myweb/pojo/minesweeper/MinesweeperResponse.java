package top.kaoxing.myweb.pojo.minesweeper;

import com.fasterxml.jackson.annotation.JsonProperty;
import top.kaoxing.myweb.pojo.BaseResponse;

import java.util.List;

public class MinesweeperResponse extends BaseResponse {

    @JsonProperty("token")
    public String token = null;

    @JsonProperty("gameState")
    public String gameState = null;

    @JsonProperty("board")
    public Object board = null;

    public MinesweeperResponse(String code, String message, String token, String gameState, Object board) {
        this.code = code;
        this.message = message;
        this.token = token;
        this.gameState = gameState;
        this.board = board;
    }

    public String getToken() {
        return token;
    }

    public String getGameState() {
        return gameState;
    }

    public Object getBoard() {
        return board;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void setBoard(List<Integer> board) {
        this.board = board;
    }

}
