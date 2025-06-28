package com.foodorderbe.foodorderbe_artifact.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.utils.AppUtils;

public class DishSpecs {

    public static Specification<Dish> isOfShop(Long shopId) {
        return (root,query,builder)->{
            return shopId == 0?builder.conjunction():builder.equal(root.get("shop").get("userId"), shopId);
            
        };
    }

    public static Specification<Dish> containsName(String name) {
        return (root,query,builder)->{
            return name.equals("")?builder.conjunction():builder.like(root.get("name"), "%"+name+"%");
            
        };
    }
    public static Specification<Dish> fromToPrice(float fromPrice, float toPrice) {
        return (root,query,builder)->{
            return AppUtils.floatEqual(fromPrice, 0) && AppUtils.floatEqual(toPrice, 0)? builder.conjunction(): builder.and(
                builder.greaterThanOrEqualTo(root.get("price"), fromPrice), 
                builder.lessThanOrEqualTo(root.get("price"), toPrice));
            
        };
    }
    public static Specification<Dish> isAvailable(boolean available) {
        return (root,query,builder)->{
            return builder.equal(root.get("available"), true);
            
        };
    }
    public static Specification<Dish> equalsDaySession(String daySession) {
        return (root,query,builder)->{
            return daySession.equals("")?builder.conjunction(): builder.equal(root.get("daySession"), daySession);
            
        };
    }
}
