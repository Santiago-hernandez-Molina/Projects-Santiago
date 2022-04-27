from django.contrib import admin

from product_manager.models import Cliente, Factura, Producto, Venta

# Register your models here.
admin.site.register(Producto)
admin.site.register(Cliente)
admin.site.register(Factura)
admin.site.register(Venta)
