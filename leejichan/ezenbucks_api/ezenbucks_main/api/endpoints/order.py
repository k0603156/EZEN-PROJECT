from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView

from ezenbucks_main import models
from ezenbucks_main.api import serializers


class OrderAPI(APIView):
    def get(self, request):
        order_list = models.Order.objects.all()
        serializer = serializers.OrderSerializer(order_list, many=True)
        return Response(data=serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        # product, option, shop, customer, status
        serializer = serializers.OrderSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
