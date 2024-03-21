package com.health.service;

import dev.samstevens.totp.code.CodeVerifier;
import dev.samstevens.totp.code.HashingAlgorithm;
import dev.samstevens.totp.exceptions.QrGenerationException;
import dev.samstevens.totp.qr.QrData;
import dev.samstevens.totp.qr.QrGenerator;
import dev.samstevens.totp.secret.SecretGenerator;
import dev.samstevens.totp.util.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TotpManagerImpl implements TotpManager {

	@Autowired
    private  SecretGenerator secretGenerator;
	@Autowired
    private  QrGenerator qrGenerator;
	@Autowired
    private  CodeVerifier myCodeVerifier;

   

    @Override
    public String generateSecretKey() {
        return secretGenerator.generate(); // 32 Byte Secret Key
    }

    @Override
    public String getQRCode(String secret) throws QrGenerationException {
        QrData qrData = new QrData.Builder().label("2FA Server")
                .issuer("VISHWA")
                .secret(secret)
                
                .digits(6)
                .period(60)
                .algorithm(HashingAlgorithm.SHA512)
                .build();

        return Utils.getDataUriForImage(qrGenerator.generate(qrData), qrGenerator.getImageMimeType());
    }

    @Override
    public boolean verifyTotp(String code, String secret) {
    	System.out.println(code+" "+secret);
    	
        return myCodeVerifier.isValidCode(secret, code);
    }
}
