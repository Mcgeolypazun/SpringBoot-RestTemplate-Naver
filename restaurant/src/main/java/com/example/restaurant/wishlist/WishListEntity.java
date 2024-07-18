package com.example.restaurant.wishlist;

import com.example.restaurant.db.MemoryDbEntity;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WishListEntity extends MemoryDbEntity {

    private String title;
    private String category;
    private String address;
    private String roadAddress;
    private String homePageLink;
    private String imageLink;
    private Boolean isVisit;
    private int visitCount;
    private LocalDateTime lastVisitDate;
}
