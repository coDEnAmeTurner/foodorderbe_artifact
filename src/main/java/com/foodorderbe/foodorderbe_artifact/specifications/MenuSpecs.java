package com.foodorderbe.foodorderbe_artifact.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.foodorderbe.foodorderbe_artifact.entities.Menu;

public class MenuSpecs {
    public static Specification<Menu> isOfShop(Long shopId){
        return (root,query,builder)->{
            return shopId == 0?builder.conjunction(): builder.equal(root.get("shop").get("userId"), shopId);
        };
    }
    public static Specification<Menu> containsName(String name){
        return (root,query,builder)->{
            return name.equals("")?builder.conjunction(): builder.like(root.get("name"), "%"+name+"%");
        };
    }
}
