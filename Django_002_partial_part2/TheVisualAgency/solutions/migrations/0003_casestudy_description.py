# Generated by Django 3.2.8 on 2021-11-09 20:51

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('solutions', '0002_rename_projectobjetive_casestudy_projectobjective'),
    ]

    operations = [
        migrations.AddField(
            model_name='casestudy',
            name='description',
            field=models.CharField(default='a', max_length=200),
            preserve_default=False,
        ),
    ]
