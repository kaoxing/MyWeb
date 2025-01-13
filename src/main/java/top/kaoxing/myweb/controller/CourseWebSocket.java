package top.kaoxing.myweb.controller;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.kaoxing.myweb.service.UCICourseScannerManager;


@ServerEndpoint(value = "/websocket/course")
@Component
public class CourseWebSocket{

    //由于是静态变量，无法通过直接注入的方式注入，所以通过set方法注入0

    private static UCICourseScannerManager uciCourseScannerManager;

    private Session session;

    @Autowired
    public void setUCICourseScannerManager(UCICourseScannerManager uciCourseScannerManager) {
        CourseWebSocket.uciCourseScannerManager = uciCourseScannerManager;
    }

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
//        System.out.println("Session opened");
    }

    @OnClose
    public void onClose(Session session) {
//        System.out.println("Session closed");
        uciCourseScannerManager.removeSession(session);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.println("Message from client: " + message);
//        System.out.println("Session: " + session);
        uciCourseScannerManager.addCourse(session, message);
    }

    public void sendMessage(String message) {
        try {
            session.getBasicRemote().sendText(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}