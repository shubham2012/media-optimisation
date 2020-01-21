package mediaProcessor.service;

import mediaProcessor.domain.MediaProcessRequest;
import mediaProcessor.domain.MediaProcessResponse;

public interface MediaProcessor {
    MediaProcessResponse processScale(MediaProcessRequest request);
    MediaProcessResponse processResolution(MediaProcessRequest request);
    MediaProcessResponse processScaleAndResolution(MediaProcessRequest request);
}
