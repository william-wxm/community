package life.weike.community.community.Exception;

public enum CustomizeErrorCode implements ICustomizeErrorCode{
    QUESTION_NOT_FOUND(20001,"你找的问题不存在了，要不换个试试！！！"),
    NO_LOGIN(20003,"当前未登录，登录后再试！！！"),
    TARGET_PARAM_NOT_FOUND(20002,"未选择任何问题惊醒回复！！！"),
    SYS_ERROR(20004,"服务器冒烟了，请稍后再试！！！"),
    TYPE_PARAM_WRONG(20005,"评论类型错误或不存在！！！"),
    COMMENT_NOT_FOUND(20006,"回复的评论不存在，要不换个试试！！！"),
    COMMENT_IS_EMPTY(20007,"评论的内容不能为空！！！");
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
