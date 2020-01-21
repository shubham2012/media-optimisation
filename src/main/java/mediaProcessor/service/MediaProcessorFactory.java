package mediaProcessor.service;

import mediaProcessor.Utils.MediaException;
import mediaProcessor.domain.MediaProcessRequest;
import mediaProcessor.domain.MediaType;

public class MediaProcessorFactory {

    public MediaProcessor getInstance(MediaProcessRequest request) throws MediaException {
        if (request.getMediaType() == MediaType.IMAGE){
            return new ImageProcessor();
        } else if (request.getMediaType() == MediaType.VIDEO){
            return new VideoProcessor();
        } else if (request.getMediaType() == MediaType.GIF){
            return new GIFProcessor();
        } else {
            throw new MediaException("Media Type not supported");
        }
    }

}
