api
## Item API
- LIST -
```bash
Method : GET
URL : Domain/api/item/list
DATA : {
           "item_id":1,
           "item_name":"아메리카노",
           "item_price":1500,
           "item_species":"coffee"
}
Response : 200
```

## Shop API
-LIST-
```bash
Method : GET
URL : Domain/api/shop/list
DATA : {
           "shop_id":1,
           "shop_name":"강남역점",
           "shop_latitude":37.4984305,
           "shop_longitude":127.0272601
}
Response : 200
```
## Order API
-LIST-
```bash
Method : GET
URL : Domain/api/order/list
DATA : {
           "order_id":1,
           "item_id":1,
           "item_option_id":1,
           "shop_id":1,
           "order_count":1,
           "order_datetime":1590360673000, <- 수정해야됨
           "order_total_price":10000,
           "order_status":"1"
}
Response : 200
```
## Order_Detail API
-LIST-
```bash
Method : GET
URL : Domain/api/order-detail
DATA : {
           "order_detail_id":1,"item_id":1,"item_option_id":1,"shop_id":1,
           "order_detail_id":2,"item_id":2,"item_option_id":2,"shop_id":1,
           "order_detail_id":3,"item_id":3,"item_option_id":3,"shop_id":1,
           "order_detail_id":4,"item_id":4,"item_option_id":4,"shop_id":1,
           "order_detail_id":5,"item_id":5,"item_option_id":0,"shop_id":1
}
Response : 200
```
## Cart API
-LIST-
```bash
Method : GET
URL : Domain/api/cart/list
DATA : {
           "cart_id":1,
           "item_id":1,
           "item_option_id":1,
           "cart_count":10,
           "cart_datetime":1590390619000
}
Response : 200
```