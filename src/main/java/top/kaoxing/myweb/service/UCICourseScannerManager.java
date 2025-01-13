package top.kaoxing.myweb.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.websocket.Session;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UCICourseScannerManager {

    @Autowired
    private UCICourseScanner uciCourseScanner;

    private ConcurrentHashMap<Session, Set<String>> uciCourseScannerMap;

    private Thread scannerThread;

    @PostConstruct
    public void init() {
        uciCourseScannerMap = new ConcurrentHashMap<>();
        scannerThread = new Thread(() -> {
            while (true) {
                try {
                    uciCourseScannerMap.forEach((session, courseSet) -> {
                        courseSet.forEach(courseCode -> {
//                            System.out.println("Scan"+courseCode);
//                            session.getAsyncRemote().sendObject(uciCourseScanner.scanCourse(courseCode));
                            session.getAsyncRemote().sendText(courseCode+"-"+uciCourseScanner.scanCourse(courseCode));
                        });
                    });
                    Thread.sleep(1000 * 30);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        scannerThread.start();
    }

    public void addCourse(Session session, String courseCode) {
        uciCourseScannerMap.computeIfAbsent(session, k -> ConcurrentHashMap.newKeySet()).add(courseCode);
    }

    public void removeCourse(Session session, String courseCode) {
        uciCourseScannerMap.computeIfPresent(session, (k, v) -> {
            v.remove(courseCode);
            return v;
        });
    }

    public void removeSession(Session session) {
        uciCourseScannerMap.remove(session);
    }

}
