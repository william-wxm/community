package life.weike.community.community.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(20001,"你找的问题不存在了，要不换个试试！！！"),
    TARGET_PARAM_NOT_FOUND(20002,"未选择任何问题惊醒回复！！！");
    private String message;
    private  Integer code;
    @Override
    public String getMessage(){
        return message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    CustomizeErrorCode(Integer code , String message){
        this.message = message;
        this.code = code;
    }
}
