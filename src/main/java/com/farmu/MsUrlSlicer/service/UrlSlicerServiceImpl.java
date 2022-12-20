package com.farmu.MsUrlSlicer.service;

import com.farmu.MsUrlSlicer.dao.UrlSlicerDao;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Cristian Camilo Beltrán
 * @since  19/12/2022
 */
@Service
public class UrlSlicerServiceImpl implements UrlSlicerService{

    @Autowired
    private UrlSlicerDao urlSlicerDao;
    
    @Override
    public String generateSlicer(String originalUrl) throws Exception{
        String shortUrl = toHexString(getSHA(originalUrl));
        urlSlicerDao.saveUrlSlicer(originalUrl, shortUrl);
        return "https://go.com/"+shortUrl;
    }

    @Override
    public String queryShortUrl(String shotUrl) {
        return urlSlicerDao.queryShortUrl(shotUrl);
    }
    
    
    
    private byte[] getSHA(String input) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("MD5");
        return md.digest(input.getBytes(StandardCharsets.UTF_8));
    }
     
    private String toHexString(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
 
        StringBuilder hexString = new StringBuilder(number.toString(16));
 
        while (hexString.length() < 32){
            hexString.insert(0, '0');
        }
 
        return hexString.toString();
    }
 
    
}
