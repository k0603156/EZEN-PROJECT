from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from ezenbucks_main import models
from ezenbucks_main.api import serializers


class OrderProductAPI(APIView):
    def get(self, request):
        order_detail_list = models.OrderProduct.objects.all()
        serializer = serializers.OrderProductSerializer(order_detail_list, many=True)
        return Response(data=serializer.data, status=status.HTTP_200_OK)

    def post(self, request):
        serializer = serializers.OrderProductSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        serializer.save()
        return Response(serializer.data, status=status.HTTP_201_CREATED)
