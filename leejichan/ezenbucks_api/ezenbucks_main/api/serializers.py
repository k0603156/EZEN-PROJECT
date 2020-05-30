from rest_framework import serializers
from ezenbucks_main import models


class ProductSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Product
        fields = (
            'id',
            'product_name',
            'unit_price',
            'product_species',
        )


class CustomerSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Customer
        fields = (
            'id',
            'customer_name'
        )


class OrderProductSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.OrderProduct
        fields = (
            'order',
            'product',
            'quantity',
            'product_temp',
            'product_size'
        )


class OrderSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Order
        fields = (
            'id',
            'order_status',
            'order_date',
            'customer',
            'shop_id',
        )


class OrderRetrieveSerializer(serializers.ModelSerializer):
    products = OrderProductSerializer(many=True, read_only=True)

    class Meta:
        model = models.Order
        fields = (
            'id',
            'order_status',
            'order_date',
            'customer',
            'products'
        )


class ShopSerializer(serializers.ModelSerializer):

    class Meta:
        model = models.Shop
        fields = '__all__'
