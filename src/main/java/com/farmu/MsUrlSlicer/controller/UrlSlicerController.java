
package com.farmu.MsUrlSlicer.controller;

import com.farmu.MsUrlSlicer.dto.UrlSlicerRequest;
import com.farmu.MsUrlSlicer.dto.UrlSlicerResponse;
import com.farmu.MsUrlSlicer.service.UrlSlicerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cristian Camilo Beltrán
 * @since  19/12/2022
 */
@RestController
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT })
@RequestMapping("/v1")
public class UrlSlicerController {
    
    @Autowired
    private UrlSlicerService urlSlicerService;
    
    @PostMapping("/url-slicer")
    public ResponseEntity urlSlicer(@RequestBody UrlSlicerRequest urlSlicerRequest) throws Exception{
        String response = urlSlicerService.generateSlicer(urlSlicerRequest.getLongUrl());
        
        UrlSlicerResponse urlSlicerResponse = new UrlSlicerResponse();
        urlSlicerResponse.setShortUrl(response);
        
        return ResponseEntity.ok(urlSlicerResponse);
    }
    
    @GetMapping("/url-slicer/{shortUrl}")
    public ResponseEntity queryState(@PathVariable("shortUrl") String shortUrl){
        String response = urlSlicerService.queryShortUrl(shortUrl);
        UrlSlicerResponse urlSlicerResponse = new UrlSlicerResponse();
        urlSlicerResponse.setLongUrl(response);
        
        return ResponseEntity.ok(urlSlicerResponse);
        
    }
    
}
