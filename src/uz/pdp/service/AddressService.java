package uz.pdp.service;

import uz.pdp.entity.Address;
import uz.pdp.payload.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> all();

    AddressDTO add(AddressDTO genreDTO);

    AddressDTO edit(Integer id, AddressDTO genreDTO);

    String delete(Integer id);

    Address getByIdOrElseThrow(Integer id);
}
