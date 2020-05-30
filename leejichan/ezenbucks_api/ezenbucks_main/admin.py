from django.contrib import admin
from ezenbucks_main.models import *


@admin.register(Product)
class ProductAdmin(admin.ModelAdmin):
    list_display = [
        'id',
        'product_name',
        'unit_price',
        'product_species',
    ]


@admin.register(Customer)
class CustomerAdmin(admin.ModelAdmin):
    list_display = [
        'id',
        'customer_name',
    ]


@admin.register(OrderProduct)
class OrderDetailsAdmin(admin.ModelAdmin):
    list_display = [
        'order_id',
        'product_id',
        'product_temp',
        'product_size',
        'quantity',
    ]


@admin.register(Order)
class OrderAdmin(admin.ModelAdmin):
    list_display = [
        'id',
        'customer_id',
        'order_status',
        'order_date',
        'shop_id'
    ]


@admin.register(Shop)
class ShopAdmin(admin.ModelAdmin):
    list_display = [
        'name'
    ]