package xyz.onezylee.censor.service;

import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import org.springframework.stereotype.Service;

@Service
public class SensitiveWordService {

    private final SensitiveWordBs bs;

    public SensitiveWordService() {
        // Initialize with default configuration and dictionary
        this.bs = SensitiveWordBs.newInstance().init();
    }

    public boolean contains(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        return bs.contains(text);
    }

    public String replace(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        // Replace sensitive words with '*'
        return bs.replace(text);
    }
}

