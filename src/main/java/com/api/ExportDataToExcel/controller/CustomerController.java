package com.api.ExportDataToExcel.controller;

import com.api.ExportDataToExcel.entity.Customer;
import com.api.ExportDataToExcel.repository.CustomerRepository;
import com.api.ExportDataToExcel.utils.BaseResponse;
import com.api.ExportDataToExcel.utils.ExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/import-excel")
public class CustomerController {
    private final CustomerRepository customerRepository;

    public ResponseEntity<Resource> exportCustomer() throws Exception {
        List<Customer> customerList = customerRepository.findAll();

        if(!CollectionUtils.isEmpty(customerList)){
            String fileName = "Customer Export" + ".xlsx";

            ByteArrayInputStream in = new ExcelUtils().exportCustomer(fileName, StandardCharsets.UTF_8);

            InputStreamResource inputStreamResource = new InputStreamResource(in);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename="
                    + URLEncoder.encode(fileName, StandardCharsets.UTF_8))
                    .body(inputStreamResource);
        }
        else {
            throw new Exception("No data");
        }

        @PostMapping("/import")
        public ResponseEntity<BaseResponse> importCustomerData(@RequestParam("file")){

        }
    }
}
