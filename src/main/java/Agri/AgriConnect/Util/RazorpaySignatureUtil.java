package Agri.AgriConnect.Util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class RazorpaySignatureUtil {
    @Value("${razorpay.key.secret}")
    private String razorpayKeySecret;
    public boolean verifySignature(
            String orderId,
            String paymentId,
            String razorpaySignature) {
        try {
            String payload = orderId + "|" + paymentId;
            String generatedSignature = generateSignature(payload);
            return generatedSignature.equals(razorpaySignature);
        } catch (Exception e) {
            throw new RuntimeException("Signature Verification Failed");
        }

    }

    private String generateSignature(String payload) throws Exception {
        Mac sha256Hmac = Mac.getInstance("HmacSHA256");
        SecretKeySpec secretKey =
                new SecretKeySpec(
                        razorpayKeySecret.getBytes(StandardCharsets.UTF_8),
                        "HmacSHA256"
                );
        sha256Hmac.init(secretKey);
        byte[] hash = sha256Hmac.doFinal(
                payload.getBytes(StandardCharsets.UTF_8)
        );
        return bytesToHex(hash);
    }
    private String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();
        for (byte b : bytes) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();

    }

}