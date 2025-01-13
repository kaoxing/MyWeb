package top.kaoxing.myweb.pojo.courseScanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import top.kaoxing.myweb.pojo.BaseResponse;

public class CourseScannerResponse extends BaseResponse {

    @JsonProperty("courseCode")
    private String courseCode = null;

    @JsonProperty("status")
    private String status = null;


    public CourseScannerResponse(String courseCode, String status) {
        this.courseCode = courseCode;
        this.status = status;
    }

}
