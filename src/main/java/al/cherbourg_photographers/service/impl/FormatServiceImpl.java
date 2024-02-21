package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.FormatDTO;
import al.cherbourg_photographers.entity.FormatEntity;
import al.cherbourg_photographers.exception.ResourceNotFoundException;
import al.cherbourg_photographers.repository.FormatEntityRepository;
import al.cherbourg_photographers.service.FormatService;
import al.cherbourg_photographers.utils.FormatMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormatServiceImpl implements FormatService {
    private final FormatEntityRepository formatEntityRepository;
    private final FormatMapper mapper;
    @Autowired
    public FormatServiceImpl(FormatEntityRepository formatEntityRepository, FormatMapper mapper) {
        this.formatEntityRepository = formatEntityRepository;
        this.mapper = mapper;
    }

    @Override
    public FormatDTO createFormat(FormatDTO formatDTO) {
        if (formatEntityRepository.existsByFormatName(formatDTO.getFormatName())) {
            throw new IllegalArgumentException("Le nom de format spécifié existe déjà.");
        }
        if (formatEntityRepository.existsByFormatSize(formatDTO.getFormatSize())) {
            throw new IllegalArgumentException("La taille de format spécifiée existe déjà.");
        }
        FormatEntity newFormat = formatEntityRepository.save(mapper.mapToFormatEntity(formatDTO));
        return mapper.mapToFormatDTO(newFormat);
    }

    @Override
    public List<FormatDTO> getAllFormats() {
        List<FormatEntity> formats = (List<FormatEntity>)formatEntityRepository.findAll();
        List<FormatDTO> formatsDTOList = formats.stream().map(view->mapper.mapToFormatDTO(view)).collect(Collectors.toList());
        return formatsDTOList;
    }

    @Override
    public FormatDTO getFormatById(int id) {
        FormatEntity formatEntity = getFormatByIdInDB(id);
        return mapper.mapToFormatDTO(formatEntity);
    }

    @Override
    public FormatDTO updateFormat(FormatDTO formatDTO, int id) {
        FormatEntity formatEntity = getFormatByIdInDB(id);
        formatEntity.setFormatName(formatDTO.getFormatName());
        formatEntity.setFormatSize(formatDTO.getFormatSize());
        FormatEntity updateFormat = formatEntityRepository.save(formatEntity);
        return mapper.mapToFormatDTO(updateFormat);
    }

    @Override
    public void deleteFormatById(int id) {
        FormatEntity formatEntity = getFormatByIdInDB(id);
        formatEntityRepository.deleteById(formatEntity.getId());
    }

    private FormatEntity getFormatByIdInDB(int id) {
        return formatEntityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Format", "id", id));
    }
}
