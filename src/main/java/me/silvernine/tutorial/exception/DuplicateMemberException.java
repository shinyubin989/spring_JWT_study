package me.silvernine.tutorial.exception;

public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException() {
        super();
    }
    public DuplicateMemberException(String message, Throwable cause) {
        super(message, cause);
    }
    public DuplicateMemberException(String message) {
        super(message);
    }
    /*
            {
                "status": 409,
                "message": "이미 가입되어 있는 유저입니다."
            }
     */
    public DuplicateMemberException(Throwable cause) {
        super(cause);
    }
}
