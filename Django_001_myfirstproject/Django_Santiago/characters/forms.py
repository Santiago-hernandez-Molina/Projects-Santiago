from dataclasses import fields
from pyexpat import model
from django import forms


from .models import Character
from characters import models

class CharacterForm(forms.ModelForm):
    path=forms.FileField()
    class Meta:
        model=Character
        fields=['city','universe','name','description','path','birthdate']