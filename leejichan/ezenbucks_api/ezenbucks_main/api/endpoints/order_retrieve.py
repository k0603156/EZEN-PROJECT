from rest_framework import status
from rest_framework.generics import get_object_or_404
from rest_framework.response import Response
from rest_framework.views import APIView
from ezenbucks_main.api.serializers import OrderRetrieveSerializer
from ezenbucks_main.models import Order


class OrderRetrieveAPI(APIView):
    def get(self, request, pk):
        order = get_object_or_404(Order.objects.filter(id=pk))
        serializer = OrderRetrieveSerializer(order)
        return Response(data=serializer.data, status=status.HTTP_200_OK)
