new Vue({
    el: '#app',
    data() {
        return {
            boardSize: '',
            numMines: '',
            board: [],
            gameStarted: false,
            //apiBaseUrl: 'https://web.kaoxing.top/minesweeper',
            apiBaseUrl: 'http://localhost/minesweeper',
            token: '',
        };
    },
    methods: {
        async startGame() {
            if(this.boardSize<=0){
                alert('Please input a valid board size | 请输入一个有效的棋盘大小');
                return;
            }
            if(this.numMines<0){
                alert('Please input a valid number of mines | 请输入一个有效的雷数');
                return;
            }
            try {
                const response = await fetch(`${this.apiBaseUrl}/create`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ boardSize: this.boardSize, numOfMines: this.numMines }),
                });
                const data = await response.json();
                this.board = data.board;
                this.token = data.token;
                this.gameStarted = true;
            } catch (error) {
                console.error(error);
            }
        },
        async resetGame() {
            try {
                const response = await fetch(`${this.apiBaseUrl}/reset`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ token: this.token }),
                });
                const data = await response.json();
                this.board = data.board;
            } catch (error) {
                console.error(error);
            }
        },
        async agentReveal() {
            if(this.boardSize > 7 || this.boardSize< 3 ){
                alert('Sorry, due to the cpu limitation of server, only when the board size is between 3 and 7, you can ' +
                    'request AI to play the game：） | 抱歉，目前服务器的算力不允许处理大于7或小于3的棋盘大小哦：）');
                return;
            }
            try {
                const response = await fetch(`${this.apiBaseUrl}/agentReveal`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ token: this.token }),
                });
                const data = await response.json();
                this.board = data.board;

                if (data.gameState !== 'inProgress') {
                    setTimeout(() => {
                        alert(data.gameState === 'win' ? 'You Win!' : 'You Lose!');
                        this.gameStarted = false;
                    }, 200);
                }
            } catch (error) {
                console.error(error);
            }
        },
        async llmReveal() {
            try {
                const response = await fetch(`${this.apiBaseUrl}/LLMReveal`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ token: this.token }),
                });
                const data = await response.json();
                this.board = data.board;

                if (data.gameState !== 'inProgress') {
                    setTimeout(() => {
                        alert(data.gameState === 'win' ? 'You Win!' : 'You Lose!');
                        this.gameStarted = false;
                    }, 200);
                }
            } catch (error) {
                console.error(error);
            }
        },
        async revealCell(col, row) {
            try {
                const response = await fetch(`${this.apiBaseUrl}/reveal`, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ token: this.token, row, col }),
                });
                const data = await response.json();
                this.board = data.board;

                if (data.gameState !== 'inProgress') {
                    setTimeout(() => {
                        alert(data.gameState === 'win' ? 'You Win!' : 'You Lose!');
                        this.gameStarted = false;
                    }, 200);
                }
            } catch (error) {
                console.error(error);
            }
        },
    },
});