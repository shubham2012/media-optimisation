package mediaProcessor.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MediaProcessRequest {
    private String localFilePath;
    private MediaType mediaType;
    private ProcessType processType;
    private Dimension dimension;
    private Double ratio;
    private Double resolution;
}
