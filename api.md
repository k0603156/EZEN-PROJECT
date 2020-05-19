상품리스트 불러오기

```
GET_http://hostname/api/product/list?type=coffee
GET_http://hostname/api/product/list?type=food
@type: coffee | food

[
{
product_id:1,
product_name:”나이트로 바닐라 크림",
product_price:5600,
product_image:”/static/produce1”
},
{
product_id:2,
product_name:”나이트로 바닐라 크림",
product_price:5600,
product_image:”/static/produce2”
},{
product_id:3,
product_name:”나이트로 바닐라 크림",
product_price:5600,
product_image:”/static/produce3”
}
]
```

매장리스트 불러오기

```
GET_http://hostname/api/shop/list
[
{
product_id:1,
shop_name:”한국프레스센터",
shop_address:”서울특별시 중구 세종대로 124(태평로1가)”,
shop_image:”/static/shop1”
},
{
product_id:2,
shop_name:”무교동",
shop_address:”서울특별시 중구  무교로21 (무교동) 코오롱빌딩 1층  ”,
shop_image:”/static/sho청2”
},{
product_id:3,
shop_name:”시청",
shop_address:”서울특별시 중구 세종대로 124(태평로1가)”,
shop_image:”/static/shop3”
}
]
```

주문하기

```
POST_http://hostname/api/order
{
shop_id:1,
orders:{
  product_id:1,
  product_size:”short”,
  product_temp:”ice”
}
}

일단 enum말고 string으로

product_size:[short, tall, grande, venti]
product_temp:[hot,ice]

RETURN
{
status:200
data:{
   order_id:1
}
}
```
