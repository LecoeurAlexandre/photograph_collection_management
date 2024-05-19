package al.cherbourg_photographers.service;

import al.cherbourg_photographers.dto.PhotographerAddressDTOReq;
import al.cherbourg_photographers.dto.PhotographerAddressDTORes;

import java.util.List;

public interface PhotographerAddressService {
    PhotographerAddressDTORes createPhotographerAddress(PhotographerAddressDTOReq photographerAddressDTOReq);
    List<PhotographerAddressDTORes> getAllAddressByPhotographer(int photographerId);
    List<PhotographerAddressDTORes> getAllPhotographerByAddress (int AddressId);
    PhotographerAddressDTORes updatePhotographerAddress(PhotographerAddressDTOReq photographerAddressDTOReq, int id);
    void deletePhotographerAddressById(int id);
}
