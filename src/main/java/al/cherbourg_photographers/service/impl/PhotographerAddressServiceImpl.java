package al.cherbourg_photographers.service.impl;

import al.cherbourg_photographers.dto.AddressDTO;
import al.cherbourg_photographers.dto.PhotographerAddressDTOReq;
import al.cherbourg_photographers.dto.PhotographerAddressDTORes;
import al.cherbourg_photographers.dto.PhotographerDTO;
import al.cherbourg_photographers.entity.AddressEntity;
import al.cherbourg_photographers.entity.PhotographerAddressEntity;
import al.cherbourg_photographers.entity.PhotographerEntity;
import al.cherbourg_photographers.repository.PhotographerAddressEntityRepository;
import al.cherbourg_photographers.service.AddressService;
import al.cherbourg_photographers.service.PhotographerAddressService;
import al.cherbourg_photographers.service.PhotographerService;
import al.cherbourg_photographers.utils.GenericMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotographerAddressServiceImpl implements PhotographerAddressService {
    private final PhotographerAddressEntityRepository photographerAddressEntityRepository;
    private final GenericMapper mapper;
    private final PhotographerService photographerService;
    private final AddressService addressService;

    public PhotographerAddressServiceImpl(PhotographerAddressEntityRepository photographerAddressEntityRepository, GenericMapper mapper, PhotographerService photographerService, AddressService addressService) {
        this.photographerAddressEntityRepository = photographerAddressEntityRepository;
        this.mapper = mapper;
        this.photographerService = photographerService;
        this.addressService = addressService;
    }

    @Override
    public PhotographerAddressDTORes createPhotographerAddress(PhotographerAddressDTOReq photographerAddressDTOReq) {
        PhotographerEntity photographer = (PhotographerEntity) mapper.mapToEntity(photographerService.getPhotographerById(photographerAddressDTOReq.getPhotographerId()), PhotographerEntity.class );
        AddressEntity address = (AddressEntity) mapper.mapToEntity(addressService.getAddressById(photographerAddressDTOReq.getAddressId()), AddressEntity.class );
        PhotographerAddressEntity photographerAddressEntity = PhotographerAddressEntity.builder()
                .photographer(photographer)
                .address(address)
                .addressStartDate(photographerAddressDTOReq.getAddressStartDate())
                .exactStartDate(photographerAddressDTOReq.isExactStartDate())
                .addressEndDate(photographerAddressDTOReq.getAddressEndDate())
                .exactEndDate(photographerAddressDTOReq.isExactEndStart())
                .build();
        PhotographerAddressEntity photographerAddressSaved = photographerAddressEntityRepository.save(photographerAddressEntity);
        return (PhotographerAddressDTORes) mapper.mapToDTO(photographerAddressSaved, PhotographerAddressDTORes.class);
    }

    @Override
    public List<PhotographerAddressDTORes> getAllAddressByPhotographer(int photographerId) {
        return null;
    }

    @Override
    public List<PhotographerAddressDTORes> getAllPhotographerByAddress(int AddressId) {
        return null;
    }

    @Override
    public PhotographerAddressDTORes updatePhotographerAddress(PhotographerAddressDTOReq photographerAddressDTOReq, int id) {
        return null;
    }

    @Override
    public void deletePhotographerAddressById(int id) {

    }
}
