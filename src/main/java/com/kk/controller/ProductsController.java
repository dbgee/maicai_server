package com.kk.controller;

import com.kk.model.Products;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductsController {

    @ResponseBody
    @RequestMapping("/all")
    public Object getAllProducts(){
        List<Products> products=new ArrayList<>();
        Products huanggua=new Products();
        huanggua.setId(1001);
        huanggua.setName("黄瓜");
        huanggua.setPrice(5.0);
        huanggua.setDescription("新鲜的黄瓜，今日热卖");

        Products tudou=new Products();
        tudou.setId(1002);
        tudou.setName("土豆");
        tudou.setPrice(3.0);
        tudou.setDescription("特大号的土豆，很实惠!");
        products.add(huanggua);
        products.add(tudou);

        return products;
    }
}
