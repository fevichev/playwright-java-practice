package org.play.utils;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Singleton
public class Utils {
    public Map<String, String> session = new HashMap<>();
    public List<Integer> priceValues = new ArrayList<>();

//    public Utils(Page page) {
//        this.page = page;
//    }
//
//    public void acceptDialog() {
//        this.page.onceDialog(dialog -> {
//            System.out.printf("Dialog message: %s%n", dialog.message());
//            dialog.accept();
//        });
//    }
}
