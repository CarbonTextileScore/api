package fr.carbon.textile.score.api.service.training.information;

import fr.carbon.textile.score.api.database.entity.training.information.VideoCategoryEntity;
import fr.carbon.textile.score.api.dto.training.information.VideoCategoryDTO;
import fr.carbon.textile.score.api.repository.training.information.VideoCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoCategoryServiceImpl implements VideoCategoryService {
    private VideoCategoryRepository _videoCategoryRepository;

    public VideoCategoryServiceImpl(VideoCategoryRepository videoCategoryRepository) {
        super();
        _videoCategoryRepository = videoCategoryRepository;
    }

    @Override
    public List<VideoCategoryDTO> getAll() {
        return _videoCategoryRepository.findAll().stream().map(videoCategoryEntity -> VideoCategoryDTO.builder()
                .id(videoCategoryEntity.getId())
                .name(videoCategoryEntity.getName())
                .build()).toList();
    }
}
