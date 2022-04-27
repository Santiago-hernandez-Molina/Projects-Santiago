from django.db import router
from rest_framework.routers import DefaultRouter
from product_manager.views import ClienteApiView, FacturaApiView, ProductoApiView, VentaApiView

router = DefaultRouter()

router.register(prefix='producto', basename='producto', viewset=ProductoApiView);
router.register(prefix='cliente', basename='cliente', viewset=ClienteApiView);
router.register(prefix='factura', basename='factura', viewset=FacturaApiView);
router.register(prefix='venta', basename='venta', viewset=VentaApiView);
