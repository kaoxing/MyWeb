package top.kaoxing.myweb.controller;

// this is a controller class for the Minesweeper game

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import top.kaoxing.myweb.pojo.minesweeper.MinesweeperResponse;
import top.kaoxing.myweb.service.MinesweeperGameAgent;

import java.util.Map;

@RestController
@RequestMapping("/minesweeper")
@CrossOrigin(origins = "*")
public class MinesweeperController {

    @Autowired
    private MinesweeperGameAgent agent;

    @PostMapping("/create")
    public ResponseEntity<MinesweeperResponse> createGame(@RequestBody Map<String,Object> params) {

        int boardSize = Integer.parseInt(params.get("boardSize").toString());
        int numOfMines = Integer.parseInt(params.get("numOfMines").toString());
        // create a new game
        Map<String, Object> map = agent.createGame(boardSize, numOfMines);

        String token = map.get("token").toString();
        String gameState = map.get("gameState").toString();
        Object board = map.get("board");

        return ResponseEntity.ok(new MinesweeperResponse("200", "Game created", token, gameState, board));
    }

    @PostMapping("/reset")
    public ResponseEntity<MinesweeperResponse> resetGame(@RequestBody Map<String,Object> params) {

        String token = params.get("token").toString();
        // reset the game
        Map<String, Object> map = agent.resetGame(token);

        String gameState = map.get("gameState").toString();
        Object board = map.get("board");

        return ResponseEntity.ok(new MinesweeperResponse("200", "Game reset", token, gameState, board));
    }

    @PostMapping("/reveal")
    public ResponseEntity<MinesweeperResponse> revealCell(@RequestBody Map<String,Object> params) {

        String token = params.get("token").toString();
        int row = Integer.parseInt(params.get("row").toString());
        int col = Integer.parseInt(params.get("col").toString());
        // reveal a cell
        Map<String, Object> map = agent.revealCell(row, col, token);

        String gameState = map.get("gameState").toString();
        Object board = map.get("board");

//        System.out.println(gameState);

        return ResponseEntity.ok(new MinesweeperResponse("200", "Cell revealed", token, gameState, board));
    }

    @PostMapping("/agentReveal")
    public ResponseEntity<MinesweeperResponse> agentReveal(@RequestBody Map<String,Object> params) {
        String token = params.get("token").toString();
        // let the agent reveal a cell
        Map<String, Object> map = agent.agentReveal(token);
        Object board = map.get("board");
        String gameState = map.get("gameState").toString();
        return ResponseEntity.ok(new MinesweeperResponse("200", "Agent revealed", token, gameState, board));
    }

    @PostMapping("/LLMReveal")
    public ResponseEntity<MinesweeperResponse> LLMReveal(@RequestBody Map<String,Object> params) {
        String token = params.get("token").toString();
        // let the agent reveal a cell
        Map<String, Object> map = agent.LLMReveal(token);
        Object board = map.get("board");
        String gameState = map.get("gameState").toString();
        return ResponseEntity.ok(new MinesweeperResponse("200", "LLM revealed", token, gameState, board));
    }

}