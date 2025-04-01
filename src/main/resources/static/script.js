// 语言数据
const languageData = {
    zh: {
        headerTitle: "欢迎来到兴的小站",
        navAbout: "关于自己",
        navProjects: "项目展示",
        navContact: "给我留言",
        aboutTitle: "关于自己",
        aboutContent: "你好！我是凌兴，一名热爱学习编程和AI的计算机专业硕士学生，目前就读于加州大学尔湾分校，主修课程为机器学习，算法设计，操作系统，分布式系统；" +
            "本科期间主要研究内容为基于深度学习的计算机视觉，旨在提高医学影像的语义分割任务中模型的性能。" +
            "目前研究方向为分割计算，主要研究在深度学习下游任务中（分类，检测，自动导航），如何在算力和网络受限的边缘设备上（无人机，无人小车）做出智能决策，提高模型性能，减少数据传输和计算时间。",
        projectsTitle: "有趣项目",
        project1Title: "维基百科搜索引擎",
        project1Content: "这是一个基于Hadoop和Lucene的维基百科搜索引擎，使用分布式索引和计算，且具备一定容灾能力，后端基于SpringBoot编写。",
        project2Title: "扫雷小游戏",
        project2Content: "扫雷小游戏，可以使用自实现的AI或者调用阿里巴巴通义千问帮你扫雷，后端基于SpringBoot编写，扫雷和AI算法使用Python实现。",
        project3Title: "课程项目：对协作任务中参与者角色分类",
        project3Content: "基于一系列机器学习和降维算法，对一项协作任务中的参与者进行角色分类。",
        project4Title: "本科毕设：心脏图像分割算法研究",
        project4Content: "基于深度学习算法对心脏医学影像进行语义分割，通过引入边缘感知任务和特征融合模块提高模型性能。",
        contactTitle: "给我留言",
        labelName: "姓名:",
        labelEmail: "邮箱:",
        labelMessage: "留言:",
        submitButton: "提交",
        messageListTitle: "所有留言",
        footerText: "&copy; 2025 兴的个人网站. 保留所有权利.",
        languageToggle: "切换至英文 / Switch to English",
        project1Button: "查看详情",
        project2Button: "查看详情",
        project3Button: "查看详情",
        project4Button: "查看详情",
        toggleBtn: "收起",
        playPauseBtn: "播放",
        volumeLabel: "音量:",
        defaultSongLabel: "请选择曲目",
    },
    en: {
        headerTitle: "Welcome to Xing's Little Station",
        navAbout: "About Me",
        navProjects: "Projects",
        navContact: "Contact Me",
        aboutTitle: "About Me",
        aboutContent: "Hello! I am Ling Xing, a master's student in computer science passionate about programming and AI. I am currently studying at the University of California, Irvine, focusing on machine learning, algorithm design, operating systems, and distributed systems. During my undergraduate studies, my main research area was deep learning-based computer vision, aiming to improve model performance in semantic segmentation tasks for medical imaging. My current research direction is split computing, focusing on how to make intelligent decisions on edge devices with limited computational power and network capabilities (such as drones and unmanned vehicles) in downstream deep learning tasks (classification, detection, autonomous navigation), to enhance model performance and reduce data transmission and computation time.",
        projectsTitle: "Projects",
        project1Title: "Wikipedia Search Engine",
        project1Content: "A Wikipedia search engine built on Hadoop and Lucene, featuring distributed indexing, computation, and disaster recovery. Backend: SpringBoot.",
        project2Title: "Minesweeper Game",
        project2Content: "A Minesweeper game with self-built AI or Alibaba's Tongyi Qianwen. Backend: SpringBoot; Minesweeper & AI: Python.",
        project3Title: "Course Project: Role Classification in Collaborative Tasks",
        project3Content: "Based on a series of machine learning and dimensionality reduction algorithms, this project classifies the roles of participants in a collaborative task.",
        project4Title: "Undergraduate Thesis: Research on Heart Image Segmentation Algorithms",
        project4Content: "This research focuses on semantic segmentation of cardiac medical images using deep learning algorithms, improving model performance by introducing edge-aware tasks and feature fusion modules.",
        contactTitle: "Contact Me",
        labelName: "Name:",
        labelEmail: "Email:",
        labelMessage: "Message:",
        submitButton: "Submit",
        messageListTitle: "All Messages",
        footerText: "&copy; 2025 Xing's Personal Website. All rights reserved.",
        languageToggle: "切换至中文 / Switch to Chinese",
        project1Button: "View Project",
        project2Button: "View Project",
        project3Button: "View Project",
        project4Button: "View Project",
        toggleBtn: "Collapse",
        playPauseBtn: "Play",
        volumeLabel: "Volume:",
        defaultSongLabel: "Select a Song",
    }
};

// 默认语言
let currentLanguage = "zh";

// 切换语言
function toggleLanguage() {
    currentLanguage = currentLanguage === "zh" ? "en" : "zh";
    updateContent();
}

// 更新页面内容
function updateContent() {
    const data = languageData[currentLanguage];
    document.getElementById("header-title").textContent = data.headerTitle;
    document.getElementById("nav-about").textContent = data.navAbout;
    document.getElementById("nav-projects").textContent = data.navProjects;
    document.getElementById("nav-contact").textContent = data.navContact;
    document.getElementById("about-title").textContent = data.aboutTitle;
    document.getElementById("about-content").textContent = data.aboutContent;
    document.getElementById("projects-title").textContent = data.projectsTitle;
    document.getElementById("project1-title").textContent = data.project1Title;
    document.getElementById("project1-content").textContent = data.project1Content;
    document.getElementById("project2-title").textContent = data.project2Title;
    document.getElementById("project2-content").textContent = data.project2Content;
    document.getElementById("project3-title").textContent = data.project3Title;
    document.getElementById("project3-content").textContent = data.project3Content;
    document.getElementById("project4-title").textContent = data.project4Title;
    document.getElementById("project4-content").textContent = data.project4Content;
    document.getElementById("contact-title").textContent = data.contactTitle;
    document.getElementById("label-email").textContent = data.labelEmail;
    document.getElementById("label-name").textContent = data.labelName;
    document.getElementById("label-message").textContent = data.labelMessage;
    document.getElementById("submit-button").textContent = data.submitButton;
    document.getElementById("messages-label").textContent = data.messageListTitle;
    document.getElementById("footer-text").innerHTML = data.footerText;
    document.getElementById("language-toggle").textContent = data.languageToggle;
    document.getElementById("project1-button").textContent = data.project1Button;
    document.getElementById("project2-button").textContent = data.project2Button;
    document.getElementById("project3-button").textContent = data.project3Button;
    document.getElementById("project4-button").textContent = data.project4Button;
    document.getElementById("toggle-btn").textContent = data.toggleBtn;
    document.getElementById("play-pause-btn").textContent = data.playPauseBtn;
    document.getElementById("volume-label").textContent = data.volumeLabel;
    document.getElementById("default-song-label").textContent = data.defaultSongLabel;
}

// 初始化页面
document.getElementById("language-toggle").addEventListener("click", toggleLanguage);
updateContent();
document.getElementById('contact-form').addEventListener('submit', function(event) {
    event.preventDefault();
    alert('感谢你的留言！我会尽快回复你。\nThank you for your message! I will get back to you soon.');
    document.getElementById('contact-form').reset();
});

document.addEventListener('DOMContentLoaded', function () {
    // 获取元素
    const toggleBtn = document.getElementById('toggle-btn');
    const musicBar = document.getElementById('music-bar');
    const musicContent = document.getElementById('music-content');
    const musicPlayer = document.getElementById('background-music');
    const musicSource = document.getElementById('music-source');
    const playPauseBtn = document.getElementById('play-pause-btn');
    const progressBar = document.getElementById('progress-bar');
    const currentTimeDisplay = document.getElementById('current-time');
    const totalTimeDisplay = document.getElementById('total-time');
    const musicSelect = document.getElementById('music-select');
    const volumeControl = document.getElementById('volume-control');

    // 收起/展开功能
    toggleBtn.addEventListener('click', function () {
        musicBar.classList.toggle('collapsed'); // 切换收起状态

        // 更新按钮文本
        if (musicBar.classList.contains('collapsed')) {
            toggleBtn.textContent = '展开';
        } else {
            toggleBtn.textContent = '收起';
        }
    });

    // 曲目切换功能
    musicSelect.addEventListener('change', function () {
        const selectedSong = musicSelect.value;

        if (selectedSong) {
            // 启用播放按钮、进度条和音量控制
            playPauseBtn.disabled = false;
            progressBar.disabled = false;
            volumeControl.disabled = false;

            // 加载音乐
            musicSource.src = selectedSong;
            musicPlayer.load();
            playPauseBtn.textContent = '播放';
            progressBar.value = 0;
            currentTimeDisplay.textContent = '00:00';
        } else {
            // 如果选择的是默认选项，禁用播放按钮、进度条和音量控制
            playPauseBtn.disabled = true;
            progressBar.disabled = true;
            volumeControl.disabled = true;

            // 暂停音乐并重置播放状态
            musicPlayer.pause();
            playPauseBtn.textContent = '播放';
            progressBar.value = 0;
            currentTimeDisplay.textContent = '00:00';
        }
    });

    // 播放/暂停功能
    playPauseBtn.addEventListener('click', function () {
        if (musicPlayer.paused) {
            musicPlayer.play();
            playPauseBtn.textContent = '暂停';
        } else {
            musicPlayer.pause();
            playPauseBtn.textContent = '播放';
        }
    });

    // 更新进度条和时间显示
    musicPlayer.addEventListener('timeupdate', function () {
        const progress = (musicPlayer.currentTime / musicPlayer.duration) * 100;
        progressBar.value = progress;
        currentTimeDisplay.textContent = formatTime(musicPlayer.currentTime);
    });

    // 歌曲播放完成时
    musicPlayer.addEventListener('ended', function () {
        playPauseBtn.textContent = '播放'; // 按钮内容变为“播放”
        progressBar.value = 0; // 重置进度条
        currentTimeDisplay.textContent = '00:00'; // 重置当前时间
    });

    // 拖动进度条跳转播放位置
    progressBar.addEventListener('input', function () {
        const seekTime = (progressBar.value / 100) * musicPlayer.duration;
        musicPlayer.currentTime = seekTime;
    });

    // 音量控制功能
    volumeControl.addEventListener('input', function () {
        musicPlayer.volume = volumeControl.value;
    });

    // 格式化时间（将秒转换为 MM:SS 格式）
    function formatTime(seconds) {
        const minutes = Math.floor(seconds / 60);
        const secs = Math.floor(seconds % 60);
        return `${String(minutes).padStart(2, '0')}:${String(secs).padStart(2, '0')}`;
    }

    // 初始化总时间显示
    musicPlayer.addEventListener('loadedmetadata', function () {
        totalTimeDisplay.textContent = formatTime(musicPlayer.duration);
    });
});

// 确保 DOM 完全加载后再绑定事件
document.addEventListener('DOMContentLoaded', function () {
    // 绑定提交按钮的点击事件
    document.getElementById('submit-button').addEventListener('click', function () {
        // 获取用户输入的姓名、邮箱和留言内容
        const name = document.getElementById('name').value.trim();
        const email = document.getElementById('email').value.trim();
        const message = document.getElementById('message').value.trim();

        // 打印日志以调试
        console.log('Name:', name);
        console.log('Email:', email);
        console.log('Message:', message);

        // 检查是否为空
        if (!name || !email || !message) {
            alert('请填写所有字段！| Please fill in all fields!');
            return;
        }

        // 发送数据到后端
        fetch('/postMessage', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ name: name, email: email, message: message }),
        })
            // 处理string类型的response
            .then(response => response.text())
            .then(data => {
                console.log('Success:', data);
                if(data==="Success") {
                    alert('提交成功！感谢你的留言。| Message submitted successfully! Thank you!');
                    loadMessages(); // 重新加载留言
                } else{
                    alert('提交失败，请重试。| Submission failed. Please try again.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('提交失败，请重试。');
            });
    });
});

// 页面加载时加载留言
document.addEventListener('DOMContentLoaded', function () {
    loadMessages();
});

// 加载所有留言
function loadMessages() {
    fetch('/getAllMessages')
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log(data); // 打印服务器返回的数据
            const messagesList = document.getElementById('messages-list');
            messagesList.innerHTML = ''; // 清空当前列表

            // 确保 data.messages 是一个数组
            data.forEach(msg => {
                const li = document.createElement('li');
                li.innerHTML = `<strong>${msg.name}</strong> (${msg.email}): ${msg.message}`;
                messagesList.appendChild(li);
            });
        })
        .catch(error => {
            console.error('Error loading messages:', error);
        });
}

