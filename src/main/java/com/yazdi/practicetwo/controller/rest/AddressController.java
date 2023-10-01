package com.yazdi.practicetwo.controller.rest;

import com.yazdi.practicetwo.domain.Address;
import com.yazdi.practicetwo.dto.request.AddressDtoRequest;
import com.yazdi.practicetwo.dto.response.AddressDtoResponse;
import com.yazdi.practicetwo.mapper.AddressMapper;
import com.yazdi.practicetwo.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/address")
@RequiredArgsConstructor
public class AddressController {

    private final Logger logger = LoggerFactory.getLogger(AddressController.class);
    private final AddressService service;
    private final AddressMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<AddressDtoResponse> saveAddress(@Valid @RequestBody AddressDtoRequest addressDtoRequest){
        Address address = mapper.addressDtoRequestToAddress(addressDtoRequest);
        address = service.saveAddress(address);
        logger.info("address saved successfully");
        return new ResponseEntity<>(
                mapper.addressToAddressDtoResponse(address)
                , HttpStatus.CREATED
        );
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateAddress(@Valid @RequestBody AddressDtoRequest addressDtoRequest){
        service.updateAddress(mapper.addressDtoRequestToAddress(addressDtoRequest));
        logger.info("address updated successfully");
        return new ResponseEntity<>(
                "address updated successfully"
                , HttpStatus.ACCEPTED
        );
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AddressDtoResponse>> getAll(){
        List<Address> addressList = service.getAll();
        List<AddressDtoResponse> dtoResponses = new ArrayList<>();
        addressList.forEach(address -> {
            dtoResponses.add(mapper.addressToAddressDtoResponse(address));
        });
        logger.info("getting all addresses");
        return new ResponseEntity<>(dtoResponses, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteAddress(long addressId){
        service.deleteAddressById(addressId);
        logger.info("address deleted successfully");
        return new ResponseEntity<>("address deleted successfully", HttpStatus.ACCEPTED);
    }

}
