package com.example.practice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpendingController {
    
    @Autowired
    private SpendingRepository repository;

    // ブラウザで http://localhost:8080/test にアクセスすると実行される
    @GetMapping("/test")
    public String testSave() {
        Spending s = new Spending();
        s.setTitle("ランチ");
        s.setAmount(1000);
        s.setCategory("食費");
        
        repository.save(s); // DBに保存！
        
        return "保存しました！";
    }

    // 保存された全データを見るためのURL
    @GetMapping(value="/list", produces = "application/json; charset=utf-8")
    public List<Spending> getAll() {
        return repository.findAll();
    }

}
