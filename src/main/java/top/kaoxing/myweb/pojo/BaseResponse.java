package top.kaoxing.myweb.pojo;


import com.fasterxml.jackson.annotation.JsonProperty;

// this is a response interface
public class BaseResponse {
    public static final String SUCCESS = "OK";
    public static final String ERROR = "ERROR";

    @JsonProperty("code")
    public String code = null;

    @JsonProperty("message")
    public String message = null;

    public BaseResponse() {
    }

    public BaseResponse(String number, String message) {
        this.code = number;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
