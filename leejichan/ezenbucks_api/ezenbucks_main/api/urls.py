from django.urls import path

from ezenbucks_main.api.endpoints.customer import CustomerAPI
from ezenbucks_main.api.endpoints.order import OrderAPI
from ezenbucks_main.api.endpoints.order_product import OrderProductAPI
from ezenbucks_main.api.endpoints.order_retrieve import OrderRetrieveAPI
from ezenbucks_main.api.endpoints.product import ProductAPI

urlpatterns = [
    # /api/order
    path('order', OrderAPI.as_view(), name='order'),
    path('order/<int:pk>', OrderRetrieveAPI.as_view(), name='order-retrieve'),

    # /api/order-product
    path('order-product', OrderProductAPI.as_view(), name='order-product'),

    path('product', ProductAPI.as_view(), name='product'),
    path('customer', CustomerAPI.as_view(), name='customer'),
]
