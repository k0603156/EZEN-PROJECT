from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView

from ezenbucks_main.api import serializers
from ezenbucks_main.models import Shop


class ShopAPI(APIView):
    def get(self, request):
        shop_list = Shop.objects.all()
        serializer = serializers.ShopSerializer()
        return Response(data=serializer.data, status=status.HTTP_200_OK)
