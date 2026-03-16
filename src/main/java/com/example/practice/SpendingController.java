package com.example.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SpendingController {

    @Autowired
    private SpendingRepository repository;

    // 家計簿の一覧表示
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("list", repository.findAll());
        model.addAttribute("spending", new Spending()); // 入力フォーム用
        return "index"; // index.htmlを呼び出す
    }

    // データの保存処理
    @PostMapping("/add")
    public String add(Spending spending) {
        repository.save(spending);
        return "redirect:/"; // 保存したら一覧に戻る
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        repository.deleteById(id);
        return "redirect:/"; // 削除したら一覧にリダイレクト
    }
}