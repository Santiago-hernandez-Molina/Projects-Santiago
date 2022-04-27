from django.http import HttpResponse
from django.shortcuts import redirect, render
from django.views.generic.base import View
from django.contrib.auth import authenticate, login, logout

# Create your views here.
class loginView(View):
    def get(self,request):
        return render(request,'login.html')

    def post(self,request):
        user = authenticate(request,username=request.POST['username'],password=request.POST['password'])
        if user is not None:
            login(request,user)
            return HttpResponse(content='success') 
        return self.get(request)

class LogoutView(View):
    def get(self,request):
        if request.user.is_authenticated:
            logout(request)
        return redirect('login')
