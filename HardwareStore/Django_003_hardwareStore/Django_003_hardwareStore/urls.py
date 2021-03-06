from django.contrib import admin
from django.shortcuts import redirect
from django.urls import path
from django.conf.urls.static  import static
from django.conf import settings
from django.urls.conf import include
from perfiles import views


urlpatterns = [
    path('admin/', admin.site.urls),
    path('products/',include('products.urls', namespace="products")),
    path('users/login', views.SignIn.as_view(), name='login'),
    path("users/logout",views.logout_v,name='logout' ),
    path('users/singup', views.SignUp.as_view(), name='sign_up'),
]+ static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
