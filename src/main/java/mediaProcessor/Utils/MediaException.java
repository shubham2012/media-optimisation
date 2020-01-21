package mediaProcessor.Utils;

public class MediaException extends Exception {

    public MediaException() {
    }

    public MediaException(String msg) {
        super(msg);
    }

    public MediaException(String msg, Throwable e) {
        super(msg, e);
    }

    public MediaException(Throwable e) {
        super(e);
    }
}
