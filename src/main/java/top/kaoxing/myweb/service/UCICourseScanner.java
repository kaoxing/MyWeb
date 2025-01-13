package top.kaoxing.myweb.service;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import top.kaoxing.myweb.pojo.courseScanner.CourseScannerResponse;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//Submit: Display Web Results
//YearTerm: 2025-03
//ShowComments: on
//ShowFinals: on
//Breadth: ANY
//Dept:  ALL
//CourseNum:
//Division: ANY
//CourseCodes: 17365
//InstrName:
//CourseTitle:
//ClassType: ALL
//Units:
//Modality:
//Days:
//StartTime:
//EndTime:
//MaxCap:
//FullCourses: ANY
//FontSize: 100
//CancelledCourses: Exclude
//Bldg:
//Room:

@Component
public class UCICourseScanner {

    @Value("${UCICourseScan.url}")
    private String url;

    @Autowired
    private RestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();

    @PostConstruct
    public void init() {
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
    }

    public String scanCourse(String courseCode) {

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Submit", "Display Web Results");
        map.add("YearTerm", "2025-03");
        map.add("CourseCodes", courseCode);
        map.add("InstrName", "");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        String response = restTemplate.postForObject(url, request, String.class);

        if (response != null) {
            System.out.println(response.contains("FULL"));
        }else{
            throw new RuntimeException("Failed to scan course");
        }

        String status = response.contains("FULL") ? "FULL" : "OPEN";

        System.out.println(courseCode + " " + status);

        return status;

    }

}
