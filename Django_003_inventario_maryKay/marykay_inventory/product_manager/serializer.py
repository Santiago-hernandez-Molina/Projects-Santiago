from rest_framework.serializers import ModelSerializer
from rest_framework.fields import SerializerMethodField
from product_manager.models import Cliente, Factura, Producto, Venta

class FacturaSerializer(ModelSerializer):
    #Return the name of the client instead id
    cliente_name=SerializerMethodField()
    total=SerializerMethodField()
    def get_cliente_name(self,factura:Factura):
        return factura.cliente.name

    def get_total(self,factura:Factura)->float:
        ventas=factura.venta_set.all()
        sum=0
        for venta in ventas:
            sum+=venta.precio
            sum-=venta.descuento
        return sum

    class Meta:
        model=Factura
        fields=('id','cliente','cliente_name','total')

class ProductoSerializer(ModelSerializer):
    class Meta:
            model=Producto
            fields='__all__'

class ClienteSerializer(ModelSerializer):
    class Meta:
            model=Cliente
            fields=('id','name','lastName','address')

class VentaSerializer(ModelSerializer):
    class Meta:
        model=Venta
        fields=('__all__')

class DetailCliente(ModelSerializer):
    facturas= FacturaSerializer(source='factura_set',many=True)

    class Meta:
        model=Cliente
        fields=('id','name','lastName','facturas')

class DetailFactura(ModelSerializer):
    ventas = VentaSerializer(source='venta_set',many=True)
    total =SerializerMethodField()
    total_productos=SerializerMethodField()
    
    def get_total_productos(self,factura:Factura):
        return factura.venta_set.count() 

    def get_total(self,factura:Factura)->float:
        ventas=factura.venta_set.all()
        sum=0
        for venta in ventas:
            sum+=venta.precio
            sum-=venta.descuento
        return sum

    class Meta:
        model=Factura
        fields=('id','cliente','ventas','total','total_productos')
