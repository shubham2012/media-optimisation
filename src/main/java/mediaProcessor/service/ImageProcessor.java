package mediaProcessor.service;

import mediaProcessor.domain.MediaProcessRequest;
import mediaProcessor.domain.MediaProcessResponse;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

public class ImageProcessor implements MediaProcessor {

    public MediaProcessResponse processScale(MediaProcessRequest request) {
        String mediaName = request.getLocalFilePath().substring(request.getLocalFilePath().lastIndexOf("/") + 1);
        String localFilePath = StringUtils.join("/data/", UUID.randomUUID().toString(), "/", mediaName);
        try {
            if (Objects.nonNull(request.getRatio())) {
                Thumbnails.of(request.getLocalFilePath())
                        .scale(request.getRatio())
                        .toFile(new File(localFilePath));
            } else {
                Thumbnails.of(request.getLocalFilePath())
                        .scale(request.getDimension().getWidth(), request.getDimension().getHeight())
                        .toFile(new File(localFilePath));
            }
        } catch (IOException e) {
            return new MediaProcessResponse(false, e.toString());
        }
        return new MediaProcessResponse(true, "SuccessFully processed image", localFilePath);
    }

    public MediaProcessResponse processResolution(MediaProcessRequest request) {
        String mediaName = request.getLocalFilePath().substring(request.getLocalFilePath().lastIndexOf("/") + 1);
        String localFilePath = StringUtils.join("/data/", UUID.randomUUID().toString(), "/", mediaName);
        try {
            Thumbnails.of(request.getLocalFilePath())
                    .outputQuality(request.getResolution())
                    .toFile(new File(localFilePath));
        } catch (IOException e) {
            return new MediaProcessResponse(false, e.toString());
        }
        return new MediaProcessResponse(true, "SuccessFully processed image", localFilePath);
    }

    @Override
    public MediaProcessResponse processScaleAndResolution(MediaProcessRequest request) {
        String mediaName = request.getLocalFilePath().substring(request.getLocalFilePath().lastIndexOf("/") + 1);
        String localFilePath = StringUtils.join("/data/", UUID.randomUUID().toString(), "/", mediaName);
        try {
            if (Objects.nonNull(request.getRatio())) {
                Thumbnails.of(request.getLocalFilePath())
                        .scale(request.getRatio())
                        .outputQuality(request.getResolution())
                        .toFile(new File(localFilePath));
            } else {
                Thumbnails.of(request.getLocalFilePath())
                        .scale(request.getDimension().getWidth(), request.getDimension().getHeight())
                        .outputQuality(request.getResolution())
                        .toFile(new File(localFilePath));
            }
        } catch (IOException e) {
            return new MediaProcessResponse(false, e.toString());
        }
        return new MediaProcessResponse(true, "SuccessFully processed image", localFilePath);
    }
}
