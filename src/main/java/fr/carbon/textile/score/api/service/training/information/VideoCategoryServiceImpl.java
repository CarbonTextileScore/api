package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.repository.training.information.VideoCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService {
    private VideoCategoryRepository _videoCategoryRepository;

    public VideoCategoryServiceImpl(VideoCategoryRepository videoCategoryRepository) {
        super();
        videoCategoryRepository = videoCategoryRepository;
    }
}
