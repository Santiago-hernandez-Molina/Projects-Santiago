from datetime import date
from django.db.models import CASCADE
from django.db import models


class Producto(models.Model):
    name=models.CharField(max_length=50)
    description=models.TextField(max_length=150)
    stock=models.IntegerField(default=0)

    class Meta:
        db_table='productos'
    def __str__(self) -> str:
        return f'Product: {self.name}'

class Cliente(models.Model):
    name=models.CharField(max_length=50)
    lastName=models.CharField(max_length=80)
    address=models.CharField(max_length=100,null=True,blank=True)

    class Meta:
        db_table='clientes'
    def __str__(self) -> str:
        return f'{self.name}'


class Factura(models.Model):
    cliente=models.ForeignKey(Cliente,on_delete=CASCADE)

    class Meta:
        db_table='facturas'

    def __str__(self) -> str:
        return f'{self.pk}__{self.cliente}'

class Venta(models.Model):
    producto=models.ForeignKey(Producto,on_delete=CASCADE)
    fecha_venta=models.DateField(default=date.today)
    cantidad=models.IntegerField()
    precio=models.FloatField()
    descuento=models.FloatField()
    factura=models.ForeignKey(Factura,on_delete=CASCADE)

    class Meta:
        db_table='ventas'

    def __str__(self) -> str:
        return f'{self.pk}__{self.producto.name}'

    


    

