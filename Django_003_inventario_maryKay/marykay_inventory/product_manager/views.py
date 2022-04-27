from django.shortcuts import render
from rest_framework.viewsets import ModelViewSet
from product_manager.models import Cliente, Factura, Producto, Venta
from product_manager.serializer import ClienteSerializer, DetailCliente, DetailFactura, FacturaSerializer, ProductoSerializer, VentaSerializer



class ProductoApiView(ModelViewSet):
    queryset = Producto.objects.all()
    serializer_class = ProductoSerializer

class ClienteApiView(ModelViewSet):
    queryset = Cliente.objects.all()
    serializer_class = ClienteSerializer

    def get_serializer_class(self):
        return (self.serializer_class,DetailCliente)[self.action=='retrieve']

class FacturaApiView(ModelViewSet):
    queryset = Factura.objects.all()
    serializer_class = FacturaSerializer

#This method change the serializer when the action is retrieve

    def get_serializer_class(self):
        return (self.serializer_class, DetailFactura)[self.action == 'retrieve']


class VentaApiView(ModelViewSet):
    queryset = Venta.objects.all()
    serializer_class = VentaSerializer