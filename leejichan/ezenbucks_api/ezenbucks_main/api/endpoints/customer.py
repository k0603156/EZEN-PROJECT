from rest_framework import status
from rest_framework.response import Response
from rest_framework.views import APIView
from ezenbucks_main import models
from ezenbucks_main.api import serializers


class CustomerAPI(APIView):
    def get(self, request):
        customer_list = models.Customer.objects.all()
        serializer = serializers.CustomerSerializer(customer_list, many=True)
        return Response(data=serializer.data, status=status.HTTP_200_OK)
