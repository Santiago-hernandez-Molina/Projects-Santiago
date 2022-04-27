from django.shortcuts import redirect, render
from characters.models import Character, City, Universe
from .forms import CharacterForm

# Create your views here.


def list(request):

    querySet = request.GET.get("search")
    list2= Universe.objects.all()

    if querySet:
        list = Character.objects.all().filter(name__contains=querySet.capitalize())
        return render(request, 'characters/index.html', {"list": list,"list2":list2})
    else:
        list = Character.objects.all()
        return render(request, 'characters/index.html', {"list": list,"list2":list2})


def filter_by_universe(request,id):
    list=Character.objects.filter(universe=id)
    list2=Universe.objects.all()
    return render(request, 'characters/index.html', {"list": list,"list2":list2})

def save(request):
    if request.method == "GET":
        form=CharacterForm()
        list = Universe.objects.all()
        list2 = City.objects.all()
        return render(request, 'characters/save.html',{"list":list,"list2":list2,"form":form})
    form=CharacterForm(request.POST,request.FILES)
    if form.is_valid():
        form.save()
        return redirect("characters:list_characters")
    return redirect('characters:save_characters')


def detail(request, id):
    list=Character.objects.all().filter(id__contains=id)
    return render(request, 'characters/detail.html',{"list":list})
