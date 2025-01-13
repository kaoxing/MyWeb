package top.kaoxing.myweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
public class MinesweeperRemoteServer {

    @Value("${minesweeper.remoteServer.url}")
    private String url;

    @Value("${minesweeper.remoteServer.create}")
    private String create;

    @Value("${minesweeper.remoteServer.reset}")
    private String reset;

    @Value("${minesweeper.remoteServer.reveal}")
    private String reveal;

    @Value("${minesweeper.remoteServer.delete}")
    private String delete;

    @Autowired
    RestTemplate restTemplate;


    public Map createGame(String token, int boardSize, int numOfMines) {

        Map<String, Object> map = Map.of("board_size", boardSize, "num_mines", numOfMines, "token", token);


        return restTemplate.postForObject(url+create, map, Map.class);
    }

    public Map resetGame(String token) {
        //reset the game
        Map<String, Object> map = Map.of("token", token);

        return restTemplate.postForObject(url+reset, map, Map.class);
    }

    public Map revealCell(String token, int row, int col) {
        //reveal a cell
        Map<String, Object> map = Map.of("token", token, "row", row, "col", col);

        return restTemplate.postForObject(url+reveal, map, Map.class);

    }

    public Map agentReveal(String token) {
        //let the agent reveal a cell
        Map<String, Object> map = Map.of("token", token);

        return restTemplate.postForObject(url+reveal, map, Map.class);
    }

    public void deleteGame(String token) {
        // delete the game
        Map<String, Object> map = Map.of("token", token);

        restTemplate.postForObject(url+delete, map, Map.class);

    }
}


