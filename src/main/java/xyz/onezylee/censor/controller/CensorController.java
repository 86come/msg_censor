package xyz.onezylee.censor.controller;

import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.onezylee.censor.model.CensorRequest;
import xyz.onezylee.censor.model.CensorResponse;
import xyz.onezylee.censor.service.SensitiveWordService;
import xyz.onezylee.censor.entity.CensorCheckLog;
import xyz.onezylee.censor.mapper.CensorCheckLogMapper;

@RestController
@Validated
@RequestMapping(path = "/api/censor", produces = MediaType.APPLICATION_JSON_VALUE)
public class CensorController {

    private final SensitiveWordService sensitiveWordService;
    private final CensorCheckLogMapper logMapper;

    public CensorController(SensitiveWordService sensitiveWordService, CensorCheckLogMapper logMapper) {
        this.sensitiveWordService = sensitiveWordService;
        this.logMapper = logMapper;
    }

    @PostMapping(path = "/check", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CensorResponse check(@Valid @RequestBody CensorRequest request) {
        boolean hasKeyword = sensitiveWordService.contains(request.getText());
        String masked = sensitiveWordService.replace(request.getText());
        // 明文落库，便于连接测试
        CensorCheckLog log = new CensorCheckLog();
        log.setHasKeyword(hasKeyword);
        log.setOriginalText(request.getText());
        log.setMaskedText(masked);
        try {
            logMapper.insert(log);
        } catch (Exception ignore) {
            // 若数据库不可用，不影响接口返回
        }
        return new CensorResponse(hasKeyword, masked);
    }
}
