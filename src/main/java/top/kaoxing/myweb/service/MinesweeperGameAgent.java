package top.kaoxing.myweb.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class MinesweeperGameAgent{

    // Random number generator
    private final Random random = new Random();

    // Redis cache
    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private MinesweeperRemoteServer minesweeperRemoteServer;

    private ValueOperations<String, String> valueOperations;

    @PostConstruct
    public void init(){
        valueOperations = redisTemplate.opsForValue();
        valueOperations.set("test", "test");
        System.out.println(valueOperations.get("test"));
    }

    private String GenerateGameId() {
        int count = 0;
        int gameId = random.nextInt(10000);
        String token = tokenGenerator.minesweeperGameTokenGenerator(String.valueOf(gameId));
        while (valueOperations.setIfAbsent(token, "").equals(false)) {
            gameId = random.nextInt(10000);
            token = tokenGenerator.minesweeperGameTokenGenerator(String.valueOf(gameId));
            count++;
            if (count > 100) {
                throw new RuntimeException("Failed to generate a unique token");
            }
        }
        deleteTakenInRemote(token);
        return token;
    }

    private void deleteTakenInRemote(String token) {
        minesweeperRemoteServer.deleteGame(token);
    }

    public Map<String,Object> createGame(int boardSize, int numOfMines) {
        // create a new game
        String token = GenerateGameId();

        System.out.println("token: " + token);

        Map<String,Object> map = minesweeperRemoteServer.createGame(token, boardSize, numOfMines);

        return Map.of(
                "token", token,
                "board", map.get("board"),
                "gameState", map.get("gameState")
        );

    }

    public Map<String,Object> resetGame(String token) {
        // reset the game
        Map<String,Object> map = minesweeperRemoteServer.resetGame(token);

        return Map.of(
                "board", map.get("board"),
                "gameState", map.get("gameState")
        );
    }


    public Map<String,Object> revealCell(int col, int row, String token) {
        // reveal a cell
        Map<String,Object> map = minesweeperRemoteServer.revealCell(token, col, row);

        return Map.of(
                "board", map.get("board"),
                "gameState", map.get("gameState")
        );
    }



    public void agentReveal() {

    }
}
