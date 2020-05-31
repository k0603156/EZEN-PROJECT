### 상품보기

### GET
### /api/product
### response data
```bash
[{
    "product_id": 1,
    "product_name": "아메리카노",
    "unit_price": 2000,
    "product_species": "drink",
    "temp_opt": "hot,ice",
    "size_opt": "short,tall,grande,venti"
}, {
    "product_id": 2,
    "product_name": "카푸치노",
    "unit_price": 2000,
    "product_species": "drink",
    "temp_opt": "hot,ice",
    "size_opt": "short,tall,grande,venti"
}, {
    "product_id": 3,
    "product_name": "카페라뗴",
    "unit_price": 2000,
    "product_species": "drink",
    "temp_opt": "hot,ice",
    "size_opt": "short,tall,grande,venti"
}, {
    "product_id": 4,
    "product_name": "카푸치노",
    "unit_price": 2000,
    "product_species": "drink",
    "temp_opt": "hot,ice",
    "size_opt": "short,tall,grande,venti"
}, {
    "product_id": 5,
    "product_name": "허니버터브래드",
    "unit_price": 2000,
    "product_species": "food",
    "temp_opt": null,
    "size_opt": null
}, {
    "product_id": 6,
    "product_name": "딸기케이크",
    "unit_price": 2000,
    "product_species": "food",
    "temp_opt": null,
    "size_opt": null
}, {
    "product_id": 7,
    "product_name": "초코케이크",
    "unit_price": 2000,
    "product_species": "food",
    "temp_opt": null,
    "size_opt": null
}]
```
---

### 매장보기

### GET
### /api/shop/{x}/{y}
### x: 위도, y:경도
### response data
```bash
[{
    "place_name": "스타벅스 몬테소리점",
    "distance": "595",
    "address_name": "서울 서초구 서초동 1318-8"
}, {
    "place_name": "스타벅스 강남에비뉴점",
    "distance": "125",
    "address_name": "서울 서초구 서초동 1303-16"
}, {
    "place_name": "스타벅스 강남교보타워R점",
    "distance": "186",
    "address_name": "서울 서초구 서초동 1303-22"
}]
```
---

### 주문하기
### POST
### /api/order

### request data
```bash
{
    "products" : [
        {
            "product_id" : 1,
            "opt_temp" : "ice",
            "opt_size" : "grande",
            "unit_price" : 2000,
            "quantity" : 3
        },
        {
            "product_id" : 5,
            "opt_temp" : "none",
            "opt_size" : "none",
            "unit_price" : 2000,
            "quantity" : 2
        }
    ],
    "shop_name" : "스타벅스 강남교보타워R점"
}
```
---

### 주문내역보기
### GET
### api/receipt
### response data
```bash
[{
    "shop": {
        "shop_name": "스타벅스 강남에비뉴점",
        "shop_address": "서울 서초구 서초동 1303-16",
        "shop_phone": "1522-3232"
    },
    "products": [{
        "product_name": "아메리카노",
        "unit_price": 2000,
        "quantity": 1,
        "subTotal": 2000
    }, {
        "product_name": "허니버터브래드",
        "unit_price": 2000,
        "quantity": 2,
        "subTotal": 4000
    }],
    "total": 6000
}, {
    "shop": {
        "shop_name": "스타벅스 강남교보타워R점",
        "shop_address": "서울 서초구 서초동 1303-22",
        "shop_phone": "1522-3232"
    },
    "products": [{
        "product_name": "아메리카노",
        "unit_price": 2000,
        "quantity": 3,
        "subTotal": 6000
    }, {
        "product_name": "허니버터브래드",
        "unit_price": 2000,
        "quantity": 2,
        "subTotal": 4000
    }],
    "total": 10000
}, {
    "shop": {
        "shop_name": "스타벅스 강남교보타워R점",
        "shop_address": "서울 서초구 서초동 1303-22",
        "shop_phone": "1522-3232"
    },
    "products": [{
        "product_name": "아메리카노",
        "unit_price": 2000,
        "quantity": 3,
        "subTotal": 6000
    }, {
        "product_name": "허니버터브래드",
        "unit_price": 2000,
        "quantity": 2,
        "subTotal": 4000
    }],
    "total": 10000
}, {
    "shop": {
        "shop_name": "스타벅스 강남교보타워R점",
        "shop_address": "서울 서초구 서초동 1303-22",
        "shop_phone": "1522-3232"
    },
    "products": [{
        "product_name": "아메리카노",
        "unit_price": 2000,
        "quantity": 3,
        "subTotal": 6000
    }, {
        "product_name": "허니버터브래드",
        "unit_price": 2000,
        "quantity": 2,
        "subTotal": 4000
    }],
    "total": 10000
}]
```

