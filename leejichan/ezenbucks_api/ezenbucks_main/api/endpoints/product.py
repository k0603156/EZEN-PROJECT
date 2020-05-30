from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from ezenbucks_main import models
from ezenbucks_main.api import serializers


class ProductAPI(APIView):
    def get(self, request):
        product_list = models.Product.objects.all()
        serializer = serializers.ProductSerializer(product_list, many=True)
        return Response(data=serializer.data, status=status.HTTP_200_OK)
