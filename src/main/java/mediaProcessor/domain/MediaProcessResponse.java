package mediaProcessor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaProcessResponse {

    private Status status;
    private String message;
    private Integer statusCode;
    private String localFilePath;

    public MediaProcessResponse(Status status, String message) {
        this.status = status;
        this.message = message;
        this.statusCode = 1;
    }

    public MediaProcessResponse(Boolean isSuccess, String message) {
        if (isSuccess)
            this.status = Status.SUCCESS;
        else
            this.status = Status.ERROR;
        this.message = message;
        this.statusCode = 1;
    }

    public MediaProcessResponse(Boolean isSuccess, String message, String localFilePath) {
        if (isSuccess)
            this.status = Status.SUCCESS;
        else
            this.status = Status.ERROR;
        this.message = message;
        this.statusCode = 1;
        this.localFilePath = localFilePath;
    }

}
